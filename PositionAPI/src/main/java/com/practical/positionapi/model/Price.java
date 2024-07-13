package com.practical.positionapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    private Long id;
    private String cusip;
    private Date priceDate;
    private BigDecimal price;
}