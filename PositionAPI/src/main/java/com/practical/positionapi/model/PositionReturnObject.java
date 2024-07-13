package com.practical.positionapi.model;

import lombok.Data;

@Data
public class PositionReturnObject {

    Position position;
    Product product;
    Price price;
}
