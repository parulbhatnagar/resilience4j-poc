package com.practical.positionapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practical.positionapi.model.Position;
import com.practical.positionapi.model.PositionReturnObject;
import com.practical.positionapi.model.ProductReturnObject;
import com.practical.positionapi.repo.PositionDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PositionService {
    @Autowired
    PositionDao positionDao;

    /**
     * Retrieves a list of PositionReturnObject objects based on the provided accountId and positionDate.
     *
     * @param  accountId    the ID of the account to retrieve positions for
     * @param  positionDate the date of the positions to retrieve
     * @return              a list of PositionReturnObject objects containing position information and associated product information
     */
    public List<PositionReturnObject> getPositions(String accountId, Date positionDate) {

        //findByAccountIdAndPositionDate
        List<Position> positions = positionDao.findByAccountIdAndPositionDate(accountId, positionDate);
        log.info("Positions: " + positions.toString());
        List<PositionReturnObject> positionReturnObjects = new ArrayList<>();

        for (Position position : positions) {
            log.info("Position Cusip: " + position.getCusip() + " Quantity: " + position.getQuantity() + " Position Date: " + position.getPositionDate());
            PositionReturnObject positionReturnObject = new PositionReturnObject();
            positionReturnObject.setPosition(position);
            ProductReturnObject productReturnObject = getProduct(position.getCusip(), positionDate);
            if (productReturnObject != null) {
                if (productReturnObject.getPrice() != null) {
                    positionReturnObject.setPrice(productReturnObject.getPrice());
                    log.info("Price: " + productReturnObject.getPrice().toString());
                }
                if(productReturnObject.getProduct() != null){
                    log.info("Product: " + productReturnObject.getProduct().toString());
                    positionReturnObject.setProduct(productReturnObject.getProduct());
                }
            } else {
                positionReturnObject.setProduct(null);
                positionReturnObject.setPrice(null);
            }
            positionReturnObjects.add(positionReturnObject);
        }

        return positionReturnObjects;

    }

    /**
     * Retrieves a ProductReturnObject by querying an external service with the provided cusip and date.
     *
     * @param  cusip The cusip of the product to retrieve
     * @param  date  The date for which the product information is requested
     * @return       The retrieved ProductReturnObject containing product details
     */

    public ProductReturnObject getProduct(String cusip, Date date) {

        // Url will be http://localhost:8020/product/getProduct?cusip=APPL&date=2004-01-01

        String url = "http://localhost:8020/product/getProduct?cusip="
                + cusip
                +"&date="
                + date.toString();

        log.info("Calling Price Service URL: " + url);

        RestTemplate restTemplate = new RestTemplate();
        String jsonResponse = restTemplate.getForObject(url, String.class);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ProductReturnObject product = objectMapper.readValue(jsonResponse, ProductReturnObject.class);

            log.info("Received Price Object: " + product.toString());

            return product;
        } catch (Exception e) {
            log.error("Error mapping JSON to Price object: " + e.getMessage());
            return null;
        }
    }

}
