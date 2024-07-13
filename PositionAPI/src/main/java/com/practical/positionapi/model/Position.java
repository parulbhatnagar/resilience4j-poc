package com.practical.positionapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Data
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String accountId;
    private String cusip;
    private Date positionDate;
    private BigDecimal quantity;

}
