/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.ebf.springmvcdemo.controller;

import de.ebf.springmvcdemo.dao.Offer;
import de.ebf.springmvcdemo.service.OffersService;
import de.ebf.springmvcdemo.utilities.Utilities;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
//        offerService.throwTestException();
        model.addAttribute("offers", offersService.getCurrentOffers());
        return "offers";
    }
    
    @RequestMapping("/createoffer")
    public String createOffer(Model model) {
        model.addAttribute("offer", new Offer());
        return "createoffer";
    }
    
    @RequestMapping(value = "/test", method=RequestMethod.GET)
    public String showTest(Model model, @RequestParam("id")String id) {
        Utilities.writeToConsole("id=" + id);
        return "createoffer";
    }
    
    @RequestMapping(value = "/docreateoffer", method=RequestMethod.POST)
    public String doCreateOffer(Model model, @Valid Offer offer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "createoffer";
        }
        offersService.createOffer(offer);
        Utilities.writeToConsole("Created offer: " + offer.toString());
        return "offercreated";
    }
    
    @Autowired
    public void setOffersService(OffersService offersService) {
        this.offersService = offersService;
    }    
}
