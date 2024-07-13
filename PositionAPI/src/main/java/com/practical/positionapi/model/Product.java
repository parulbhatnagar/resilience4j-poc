package com.practical.positionapi.model;

import lombok.Data;

@Data
public class Product {

    private Long id;
    private String cusip;
    private String description;
    private String assetClass;
}
