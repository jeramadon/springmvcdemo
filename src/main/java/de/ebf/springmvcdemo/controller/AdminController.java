/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.ebf.springmvcdemo.controller;

import de.ebf.springmvcdemo.dao.User;
import de.ebf.springmvcdemo.service.UsersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jerryamadon
 */
@Controller
public class AdminController {
    
    private UsersService usersService;
    
    @RequestMapping("/admin")
    public String showAdmin(Model model) {
        List<User> users = usersService.getAllUsers();
        model.addAttribute("users", users);
        return "admin";
    }    
    
    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }    
}
