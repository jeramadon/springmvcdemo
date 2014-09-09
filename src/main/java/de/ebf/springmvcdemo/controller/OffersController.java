/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.ebf.springmvcdemo.controller;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jerryamadon
 */
@Controller
public class OffersController {
  /*    
    @RequestMapping("/")
    public ModelAndView showHome(HttpSession session) {
        session.setAttribute("name", "sam");
        ModelAndView modelAndView = new ModelAndView("home");
        Map<String, Object> modelMap = modelAndView.getModel();
        modelMap.put("name", "frodo");
        return modelAndView;
    }
//  */    
    @RequestMapping("/")
    public String showHome(Model model) {
        model.addAttribute("name", "<b>bilbo</b>");
        return "home";
    }
}
