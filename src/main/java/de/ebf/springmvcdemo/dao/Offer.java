/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.ebf.springmvcdemo.dao;

import de.ebf.springmvcdemo.validation.ValidEmail;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author jerryamadon
 */
public class Offer {

    private int id;
    @Size(min=1, max=100, message="Enter a valid name")
    private String name;
    @NotNull
//    @Pattern(regexp=".*@.*\\..*", message="Enter a valid email address")
    @ValidEmail(min=5, message="Enter a valid Email address")
    private String email;
    @Size(min=1, max=100, message="Enter a valid text description")
    private String text;

    public Offer() {        
    }
    
    public Offer(int id, String name, String email, String text) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.text = text;
    }

    public Offer(String name, String email, String text) {
        this.name = name;
        this.email = email;
        this.text = text;
    }
    
    @Override
    public String toString() {
        return "Offer{" + "id=" + id + ", name=" + name + ", email=" + email + ", text=" + text + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
