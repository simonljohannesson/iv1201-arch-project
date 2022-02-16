package se.kth.iv1201.group6.recruitmentApplication.auth;

import javax.persistence.*;

/**
 * This class is fetched from the database when Spring-Security needs to verify a user.
 *
 * The class is not an accurate description of the relation in the database, it holds
 * only what it needs for Spring-Security authentication and authorization to work.
 */
@Entity
@Table(name = "person")
public class ApplicationUser {

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
//    @Column(name = "enabled") // TODO: fix database person to hold isUserEnabled
//    private boolean enabled;
    @Column(name = "role_id")
    private int role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return true;
    }

    public void setEnabled(boolean enabled) {
//        this.enabled = enabled;
    }

    public int getRole() {
        return role;
    }

    public void setRoles(int role) {
        this.role = role;
    }


}
