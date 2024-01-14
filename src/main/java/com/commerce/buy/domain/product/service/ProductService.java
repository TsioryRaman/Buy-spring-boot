package com.commerce.buy.domain.product.service;

import com.commerce.buy.domain.EntityDao;
import com.commerce.buy.domain.EntityDto;
import com.commerce.buy.domain.product.event.ProductCreatedEvent;
import com.commerce.buy.domain.product.event.ProductViewEvent;
import com.commerce.buy.domain.product.model.Product;
import com.commerce.buy.http.service.CrudAdvancedServiceInterface;
import com.commerce.buy.infrastructure.exception.entityException.NoSuchEntityException;
import com.commerce.buy.infrastructure.repository.ProductRepository;
import com.commerce.buy.infrastructure.search.dto.RequestDto;
import com.commerce.buy.infrastructure.search.dto.SearchRequestDto;
import com.commerce.buy.infrastructure.search.service.FilterSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements CrudAdvancedServiceInterface<Product> {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    EntityDao<Product> entityDao;

    @Autowired
    FilterSpecification<Product> filterProduct;
    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Override
    public ResponseEntity<Product> create(EntityDto<Product> productDto) {
        // Creation du produit
        Product product = this.entityDao.create(productDto);
        this.eventPublisher.publishEvent(new ProductCreatedEvent(product));

        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = this.entityDao.findAll();

        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Product> getById(int id) {
        Product product = this.entityDao.findById(id);
        this.eventPublisher.publishEvent(new ProductViewEvent(product));

        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @Override
    public Product findByName(String name) {
        return null;
    }

    @Override
    public List<Product> findByName(SearchRequestDto searchRequestDto) {
        return this.productRepository.findAll(this.filterProduct.getSearchSpecification(searchRequestDto, FilterSpecification.TYPE.OR));
    }

    @Override
    public List<Product> findByMultipleName(List<RequestDto> requestDtos) {
        return this.entityDao.findByField(requestDtos);
    }
}
