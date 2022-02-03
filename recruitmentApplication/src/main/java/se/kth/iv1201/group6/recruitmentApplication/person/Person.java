package se.kth.iv1201.group6.recruitmentApplication.person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long person_id;
    
    private String name;
    private String surname;
    private String pnr;
    private String email;
    private String password;
    private Long role_id;
    private String username;

    public Long getId() {
        return this.person_id;
    };
    
    public void setId(Long id) {
        this.person_id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSurname() {
        return this.surname;
    }
    
    public void setSurnameame(String surname) {
        this.surname = surname;
    }
    
    public String getPnr() {
        return this.pnr;
    }
    
    public void setPnr(String pnr) {
        this.pnr = pnr;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Long getRole_id() {
        return this.role_id;
    }
    
    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

}    

