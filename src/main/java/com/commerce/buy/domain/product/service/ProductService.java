package com.commerce.buy.domain.product.service;

import com.commerce.buy.http.service.CrudAdvancedServiceInterface;
import com.commerce.buy.http.service.CrudFindServiceInterface;
import com.commerce.buy.http.service.CrudServiceInterface;
import com.commerce.buy.domain.EntityDto;
import com.commerce.buy.domain.product.event.ProductCreatedEvent;
import com.commerce.buy.domain.product.event.ProductViewEvent;
import com.commerce.buy.domain.product.model.Product;
import com.commerce.buy.infrastructure.search.dto.RequestDto;
import com.commerce.buy.infrastructure.search.dto.SearchRequestDto;
import com.commerce.buy.infrastructure.search.service.FilterSpecification;
import com.commerce.buy.infrastructure.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService implements CrudAdvancedServiceInterface<Product> {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    FilterSpecification<Product> filterProduct;
    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Override
    public ResponseEntity<Product> create(EntityDto<Product> productDto) throws Exception {
        try {
            Product product = new Product();
            productDto.setEntity(product);
            productDto.hydrate();
            product = (Product) productDto.getEntity();
            this.productRepository.save(product);
            this.eventPublisher.publishEvent(new ProductCreatedEvent(product));

            return new ResponseEntity<Product>(product, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = new ArrayList<>(this.productRepository.findAll());

        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Product> getById(int id) {

        Product product = this.productRepository.findById(id).get();
        this.eventPublisher.publishEvent(new ProductViewEvent(product));

        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @Override
    public Product findByName(String name) {
        Product product = this.productRepository.findByName(name);
        System.out.println("name = " + product.getName());
        return product;
    }

    @Override
    public List<Product> findByName(SearchRequestDto searchRequestDto) {
        return this.productRepository.findAll(this.filterProduct.getSearchSpecification(searchRequestDto, FilterSpecification.TYPE.OR));
    }

    @Override
    public List<Product> findByMultipleName(List<RequestDto> requestDtos) {
        return this.productRepository.findAll(this.filterProduct.getSearchSpecification(requestDtos.stream().map(RequestDto::getSearchRequestDto).toList(), FilterSpecification.TYPE.OR));
    }
}
