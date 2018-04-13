package com.opsbin.springconfigsecurity.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@NamedQueries({
    @NamedQuery(
        name = "hqlFindAccountByUsername",
        query = "FROM Account ac WHERE ac.username = :username"
    )
})
@NamedNativeQueries({
    @NamedNativeQuery(
        name = "sqlFindAccountByUsername",
        query = "SELECT * FROM accounts ac INNER JOIN authorities au ON ac.account_id = au.account_id WHERE ac.username = :username",
        resultClass = Account.class
    )
})
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private Set<Authority> authorities = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}
