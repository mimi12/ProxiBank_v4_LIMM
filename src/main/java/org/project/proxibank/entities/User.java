package org.project.proxibank.entities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.project.proxibank.security.entities.Authority;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@Column(name = "email", length = 150,unique = true)
    @NotNull
    @Size(min = 3, max = 150,  message="email should be between 3 and 150 caracters")
    @Email
    private String email;

    @Column(name = "password", length = 200)
    @Size(min = 3, max = 100,  message="password should be between 3 and 100 caracters")
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

    @Column(name = "firstname", length = 50)
    @NotNull
    @Size(min = 1, max = 50, message="firstname should be between 1 and 50 caracters")
    private String firstname;

    @Column(name = "lastname", length = 50)
    @NotNull
    @Size(min = 1, max = 50, message="lastname should be between 1 and 50 caracters")
    private String lastname;

    @Column(name = "enabled", nullable= true)
    private Boolean enabled;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "USER_AUTHORITY",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "ID")})
    private List<Authority> authorities;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
    

}
