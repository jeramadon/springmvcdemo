/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.ebf.springmvcdemo.controller;

import de.ebf.springmvcdemo.dao.Offer;
import de.ebf.springmvcdemo.service.OffersService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
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

    private OffersService offersService;
    
    @RequestMapping("/")
    public String showHome(Model model) {
        List<Offer> offers = offersService.getCurrentOffers();
        model.addAttribute("offers", offers);
        return "home";
    }
    
    @Autowired
    public void setOffersService(OffersService offersService) {
        this.offersService = offersService;
    }    
}
