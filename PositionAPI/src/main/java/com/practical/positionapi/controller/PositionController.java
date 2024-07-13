package com.practical.positionapi.controller;

import com.practical.positionapi.model.Position;
import com.practical.positionapi.model.PositionReturnObject;
import com.practical.positionapi.model.Price;
import com.practical.positionapi.model.Product;
import com.practical.positionapi.service.PositionService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/position")
@Slf4j
public class PositionController {

    public static final String POSITION_SERVICE = "PositionAPI";

    @Autowired
    PositionService positionService;

    private int noOfRetries = 0;

    /**
     * Retrieves a list of PositionReturnObject based on the provided accountId and positionDate.
     *
     * @param  accountId    the account ID to retrieve positions for
     * @param  positionDate the date of the positions to retrieve
     * @return               a list of PositionReturnObject representing the positions
     * @throws Exception    if an error occurs during the retrieval process
     */
    @RequestMapping("/getPositions")
    //@CircuitBreaker(name = POSITION_SERVICE, fallbackMethod = "getPositionsFallback")
    //@Retry(name = POSITION_SERVICE, fallbackMethod = "getPositionsFallback")
    @RateLimiter(name = POSITION_SERVICE, fallbackMethod = "getPositionsFallback")
    public List<PositionReturnObject> getPositions(
            @RequestParam("accountId") String accountId,
            @RequestParam("positionDate") Date positionDate) {
        log.info("getPositions called with accountId: " + accountId + " and positionDate: " + positionDate.toString());
        log.info("Retry count: " + noOfRetries++);
        return positionService.getPositions(accountId, positionDate);
    }

    /**
     * Retrieves a fallback list of PositionReturnObject based on the provided accountId and positionDate.
     *
     * @param e an Exception that triggered the fallback
     * @return a fallback list of PositionReturnObject representing the positions, or null if no fallback is available
     */
    public List<PositionReturnObject> getPositionsFallback(Exception e) {
        log.info("getPositionsFallback called with exception: " + e.getMessage());
        // Creating a fallback list of PositionReturnObject
        return Stream.of(
                new PositionReturnObject(
                        new Position(1L,"accountId", "12345", Date.valueOf("2004-01-01"), new BigDecimal(100)),
                        new Product(1L, "12345", "Product 1", "Asset Class 1"),
                        new Price(1L, "12345", Date.valueOf("2004-01-01"), new BigDecimal(100)))
        ).collect(Collectors.toList());
    }

}
