package com.practical.positionapi.controller;

import com.practical.positionapi.model.PositionReturnObject;
import com.practical.positionapi.service.PositionService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    PositionService positionService;

    /**
     * Retrieves a list of PositionReturnObject based on the provided accountId and positionDate.
     *
     * @param  accountId    the account ID to retrieve positions for
     * @param  positionDate the date of the positions to retrieve
     * @return               a list of PositionReturnObject representing the positions
     * @throws Exception    if an error occurs during the retrieval process
     */
    @RequestMapping("/getPositions")
    @CircuitBreaker(name = "positionService", fallbackMethod = "getPositionsFallback")
    public List<PositionReturnObject> getPositions(
            @RequestParam("accountId") String accountId,
            @RequestParam("positionDate") Date positionDate) {
        return positionService.getPositions(accountId, positionDate);
    }

    /**
     * Retrieves a fallback list of PositionReturnObject based on the provided accountId and positionDate.
     *
     * @param  accountId    the account ID to retrieve positions for
     * @param  positionDate the date of the positions to retrieve
     * @return               a fallback list of PositionReturnObject representing the positions, or null if no fallback is available
     */
    public List<PositionReturnObject> getPositionsFallback(String accountId, Date positionDate) {
        return null;
    }

}
