package com.practical.pricingservice.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Data
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String cusip;
    private Date priceDate;
    private BigDecimal price;
}
