/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.ebf.springmvcdemo.controller;

import de.ebf.springmvcdemo.utilities.Utilities;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author jerryamadon
 */
@ControllerAdvice
public class DatabaseErrorHandler {
    
    @ExceptionHandler(DataAccessException.class)
    public String handleDatabaseException(DataAccessException exception) {
        Utilities.writeToConsole(exception.getMessage());
        return "dberror";
    }    
}
