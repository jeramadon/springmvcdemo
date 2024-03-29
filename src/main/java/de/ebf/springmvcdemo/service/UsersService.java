/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.ebf.springmvcdemo.service;

import de.ebf.springmvcdemo.dao.User;
import de.ebf.springmvcdemo.dao.UsersDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

/**
 *
 * @author jerryamadon
 */
@Service("usersService")
public class UsersService {

    private UsersDao usersDao;
    
    @Autowired
    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }
    
    public List<User> getCurrentUsers() {
        return usersDao.getCurrentUsers();
    }
    
    @Secured("ROLE_ADMIN")
    public List<User> getAllUsers() {
        return usersDao.getAllUsers();
    }
    
    public void createUser(User user) {
        usersDao.create(user);
    }    

    public boolean exists(String username) {      
        return usersDao.exists(username);
    }
}
