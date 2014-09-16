/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.ebf.springmvcdemo.controller;

import de.ebf.springmvcdemo.dao.Offer;
import de.ebf.springmvcdemo.dao.User;
import de.ebf.springmvcdemo.utilities.Utilities;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jerryamadon
 */
@Controller
public class UserController {
    
    @RequestMapping("/createuser")
    public String showCreateUser(Model model) {
        model.addAttribute("user", new User());
        return "createuser";
    }    
    
    @RequestMapping(value = "/docreateuser", method=RequestMethod.POST)
    public String doCreateUser(Model model, @Valid User user, BindingResult bindingResult) {
        return "usercreated";
    }
}
