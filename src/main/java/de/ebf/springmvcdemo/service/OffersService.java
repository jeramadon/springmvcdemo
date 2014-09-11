/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.ebf.springmvcdemo.service;

import de.ebf.springmvcdemo.dao.Offer;
import de.ebf.springmvcdemo.dao.OffersDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jerryamadon
 */
@Service("offersService")
public class OffersService {

    private OffersDao offersDao;
    
    @Autowired
    public void setOffersDao(OffersDao offersDao) {
        this.offersDao = offersDao;
    }
    
    public List<Offer> getCurrentOffers() {
        return offersDao.getOffers();
    }
    
    public void createOffer(Offer offer) {
        offersDao.create(offer);
    }
  /*
    public void throwTestException() {
        offersDao.getOffer(-1);
    }
//  */    
}
