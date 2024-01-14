package com.commerce.buy.domain.product.dao;

import com.commerce.buy.domain.EntityDao;
import com.commerce.buy.domain.EntityDto;
import com.commerce.buy.domain.product.model.Product;
import com.commerce.buy.infrastructure.exception.entityException.ConflictException;
import com.commerce.buy.infrastructure.exception.entityException.NoSuchEntityException;
import com.commerce.buy.infrastructure.repository.ProductRepository;
import com.commerce.buy.infrastructure.search.dto.RequestDto;
import com.commerce.buy.infrastructure.search.service.FilterSpecification;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDao implements EntityDao<Product> {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    FilterSpecification<Product> filter;

    @Override
    public Product create(EntityDto<Product> entityDto) {
        Product product = new Product();
        entityDto.setEntity(product);
        entityDto.hydrate();
        product = entityDto.getEntity();

        if (this.productRepository.existsByName(product.getName()))
            throw new ConflictException("Le nom du produit existe deja");

        this.productRepository.save(product);

        return null;
    }

    @Override
    public Product findById(int id) {
        Optional<Product> product = this.productRepository.findById(id);
        if(product.isEmpty())
            throw new NoSuchEntityException("Ce produit n'existe pas");
        return product.get();
    }

    @Override
    public Product delete(int entityId) {
        return null;
    }

    @Override
    public Product update(int entityId) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll().stream().toList();
    }

    @Override
    public List<Product> findByField(List<RequestDto> requestDtos) {
        return this.productRepository.findAll(this.filter.getSearchSpecification(requestDtos.stream().map(RequestDto::getSearchRequestDto).toList(), FilterSpecification.TYPE.OR));
    }
}
