<template>
  <div>
    <b-alert v-if="createdAccount" variant="success" show
      >Created an account with username: {{ this.form.username }}</b-alert
    >
    <div v-else>
      <b-alert v-model="showDismissibleAlert" variant="danger" dismissible>
        <div v-for="data in this.dismissibleAlertData" :key="data">
          {{ data }}
        </div>
      </b-alert>

      <b-form @submit="onSubmit">
        <b-row>
          <b-col>
            <b-form-group
              id="input-group-name"
              label="Your Name:"
              label-for="input-name"
            >
              <b-form-input
                id="input-name"
                v-model="form.name"
                placeholder="Enter name"
                required
              ></b-form-input>
            </b-form-group>
          </b-col>

          <b-col>
            <b-form-group
              id="input-group-2"
              label="Last name:"
              label-for="input-2"
            >
              <b-form-input
                id="input-2"
                v-model="form.surname"
                placeholder="Enter last name"
                required
              ></b-form-input>
            </b-form-group>
          </b-col>
        </b-row>

        <b-row>
          <b-col>
            <b-form-group
              id="input-group-pnr"
              label="Swedish person number:"
              label-for="input-pnr"
            >
              <b-form-input
                id="input-pnr"
                v-model="form.pnr"
                placeholder="YYYYMMDDXXXX"
                required
              ></b-form-input>
            </b-form-group>
          </b-col>
          <b-col>
            <b-form-group
              id="input-group-email"
              label="Email address:"
              label-for="input-email"
            >
              <b-form-input
                id="input-email"
                v-model="form.email"
                type="email"
                placeholder="Enter email"
                required
              ></b-form-input>
            </b-form-group>
          </b-col>
        </b-row>

        <b-row>
          <b-col>
            <b-form-group
              id="input-group-username"
              label="Username:"
              label-for="input-usename"
            >
              <b-form-input
                id="input-username"
                v-model="form.username"
                placeholder="Enter username"
                required
              ></b-form-input>
            </b-form-group>
          </b-col>
          <b-col>
            <b-form-group
              id="input-group-password"
              label="Choose a strong password:"
              label-for="input-password"
            >
              <b-form-input
                id="input-password"
                v-model="form.password"
                placeholder="Password"
                type="password"
                required
              ></b-form-input>
            </b-form-group>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <b-button type="submit" variant="primary">Sign up!</b-button>
          </b-col>
        </b-row>
      </b-form>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
    data () {
        return {
            form: {
                email: '',
                name: '',
                surname: '',
                pnr: '',
                username: '',
                password: ''
            },
            showDismissibleAlert: false,
            dismissibleAlertData: [''],
            mapping: {
                pnr: 'Person number',
                username: 'Username',
                name: 'Name',
                surname: 'Surname',
                email: 'Email',
                password: 'Password'
            },
            createdAccount: false
        };
    },
    methods: {
        rerouteToHome () {
            this.$router.push({ name: 'Home' });
        },
        onSubmit (event) {
            event.preventDefault();
            axios({
                method: 'POST',
                url: 'http://localhost:8080/users/applicants',
                data: {
                    email: this.form.email,
                    name: this.form.name,
                    surname: this.form.surname,
                    pnr: this.form.pnr,
                    username: this.form.username,
                    password: this.form.password
                },
                withCredentials: true
            })
                .then((_res) => {
                    this.createdAccount = true;
                    setTimeout(() => this.rerouteToHome(), 3000);
                })
                .catch((err) => {
                    if (err.response.status === 400) {
                        this.dismissibleAlertData = [];
                        const errors = err.response.data.errors.map((error) => {
                            return this.mapping[error.field] + ': ' + error.defaultMessage;
                        });
                        this.dismissibleAlertData = errors;
                        this.showDismissibleAlert = true;
                    } else if (err.response.status === 409) {
                        this.dismissibleAlertData = [];
                        let errorMsg = '';
                        switch (err.response.data.errorCode) {
                        case 100:
                            errorMsg = 'Email already in use';
                            break;
                        case 101:
                            errorMsg = 'Username already in use';
                            break;
                        case 102:
                            errorMsg = 'Personal number already in use';
                            break;
                        default:
                            errorMsg =
                  'An error occured, if it persists please contact the site administrator.';
                            break;
                        }
                        this.dismissibleAlertData.push(errorMsg);
                        this.showDismissibleAlert = true;
                    }
                });
        }
    },
    computed: {
        validatePnr () {
            return false;
        }
    }
};
</script>

<style>
</style>
