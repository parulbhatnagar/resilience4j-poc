package com.practical.productapi.repo;


import com.practical.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product,Long> {

    Product findByCusip(String cusip);

}
