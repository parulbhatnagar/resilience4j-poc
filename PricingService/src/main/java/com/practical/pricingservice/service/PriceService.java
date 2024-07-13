package com.practical.pricingservice.service;

import com.practical.pricingservice.model.Price;
import com.practical.pricingservice.repo.PriceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;

@Service
public class PriceService {

    @Autowired
    PriceDao priceDao;

    public Price getPrice(String cusip, Date priceDate) {
        return priceDao.findByCusipAndPriceDate(cusip, priceDate);
    }
}
