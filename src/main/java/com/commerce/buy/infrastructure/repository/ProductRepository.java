package com.commerce.buy.infrastructure.repository;

import com.commerce.buy.domain.EntityDto;
import com.commerce.buy.domain.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.http.ResponseEntity;

public interface ProductRepository extends JpaRepository<Product,Integer>, JpaSpecificationExecutor<Product> {
    Product findByName(String name);

    Boolean existsByName(String name);
}
