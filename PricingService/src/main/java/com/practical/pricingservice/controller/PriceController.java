package com.practical.pricingservice.controller;

import com.practical.pricingservice.model.Price;
import com.practical.pricingservice.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    PriceService priceService;

    @GetMapping("/getPriceForCusipAndDate")
    public Price getPriceForCusipAndDate(
            @RequestParam("cusip")
        String cusip,
        @RequestParam("date")
        String date
    ) {

        // converst string date to sqldate
        Date priceDate = Date.valueOf(date);
        return priceService.getPrice(cusip, priceDate);

    }

    @GetMapping("/getPrice")
    public Price getPrice() {
        return null;
    }
}
