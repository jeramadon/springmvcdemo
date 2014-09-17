/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.ebf.springmvcdemo.dao;

import de.ebf.springmvcdemo.validation.ValidEmail;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author jerryamadon
 */
public class User {

    @Size(min=2, max=100)
    @Pattern(regexp="^\\w{2,}$")
    private String username;
    @ValidEmail(min=5)
    private String email;
    @Size(min=2, max=100)
    private String password;
    private boolean enabled;
    private String authority;

    public User() {
    }

    public User(String username, String password, String email, boolean enabled, String authority) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.authority = authority;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
    
    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", email=" + email + ", enabled=" + enabled + ", authority=" + authority + '}';
    }
}
