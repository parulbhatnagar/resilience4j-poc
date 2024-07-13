package com.practical.productapi.controller;

import com.practical.productapi.model.ProductReturnObject;
import com.practical.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/getProduct")
    public ProductReturnObject getProductForCusipAndDate(
        @RequestParam("cusip")
        String cusip,
        @RequestParam("date")
        String date
    ) {

        // converst string date to sqldate
        Date priceDate = Date.valueOf(date);
        return productService.getProduct(cusip, priceDate);
    }
}
