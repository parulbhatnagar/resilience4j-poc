package com.practical.pricingservice.repo;


import com.practical.pricingservice.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface PriceDao extends JpaRepository<Price, Long> {

    Price findByCusipAndPriceDate(String cusip, Date priceDate);
}
