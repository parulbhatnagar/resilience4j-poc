package com.practical.positionapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionReturnObject {

    Position position;
    Product product;
    Price price;
}
