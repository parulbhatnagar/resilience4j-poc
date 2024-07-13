package com.practical.positionapi.model;


import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class Price {
    private Long id;
    private String cusip;
    private Date priceDate;
    private BigDecimal price;
}