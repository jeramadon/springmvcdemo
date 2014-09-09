/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.ebf.springmvcdemo.controller;

import de.ebf.springmvcdemo.dao.Offer;
import de.ebf.springmvcdemo.service.OffersService;
import de.ebf.springmvcdemo.utilities.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jerryamadon
 */
@Controller
public class OffersController {

    private OffersService offersService;
    
    @RequestMapping("/offers")
    public String showOffers(Model model) {
        model.addAttribute("offers", offersService.getCurrentOffers());
        return "offers";
    }
    
    @RequestMapping("/createoffer")
    public String createOffer() {
        return "createoffer";
    }
    
    @RequestMapping(value = "/test", method=RequestMethod.GET)
    public String showTest(Model model, @RequestParam("id")String id) {
        Utilities.writeToConsole("id=" + id);
        return "createoffer";
    }
    
    @RequestMapping(value = "/docreate", method=RequestMethod.POST)
    public String doCreate(Model model, Offer offer) {
        Utilities.writeToConsole(offer.toString());
        return "offercreated";
    }
    
    @Autowired
    public void setOffersService(OffersService offersService) {
        this.offersService = offersService;
    }    
}
