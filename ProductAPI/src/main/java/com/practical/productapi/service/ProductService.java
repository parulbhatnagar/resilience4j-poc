package com.practical.productapi.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.practical.productapi.model.Price;
import com.practical.productapi.model.Product;
import com.practical.productapi.model.ProductReturnObject;
import com.practical.productapi.repo.ProductDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.sql.Date;

@Service
@Slf4j
public class ProductService {

    @Autowired
    ProductDao productDao;

    public ProductReturnObject getProduct(String cusip, Date priceDate) {

        // build the Product  object by calling ProductDao for given cusip
        Product product = productDao.findByCusip(cusip);

        // we need to do a service endpoint call to fetch prices for given cusip and date
        // build the Price object by calling PriceService
        Price price =   getPriceForCusipAndDate(cusip, priceDate);
        //TODO: get price from a service endpoint call instead of function

        // Make a http get call to get prices for give cusip and date
        // URL for that is http://localhost:8100/price/getPriceForCusipAndDate?cusip=APPL&date=2024-07-11




        ProductReturnObject productReturnObject = new ProductReturnObject();
        productReturnObject.setProduct(product);
        productReturnObject.setPrice(price);

        return productReturnObject;

    }


    public Price getPriceForCusipAndDate( String cusip, Date priceDate) {
        String url = "http://localhost:8030/price/getPriceForCusipAndDate?cusip="
                + cusip
                +"&date="
        + priceDate.toString();

        log.info("Calling Price Service URL: " + url);

        RestTemplate restTemplate = new RestTemplate();
        String jsonResponse = restTemplate.getForObject(url, String.class);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Price price = objectMapper.readValue(jsonResponse, Price.class);

            log.info("Received Price Object: " + price.toString());

            return price;
        } catch (Exception e) {
            log.error("Error mapping JSON to Price object: " + e.getMessage());
            return null;
        }
    }
}
