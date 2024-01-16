package com.commerce.buy.domain.category.service;

import com.commerce.buy.domain.EntityDto;
import com.commerce.buy.domain.category.dao.CategoryDao;
import com.commerce.buy.domain.category.model.Category;
import com.commerce.buy.http.service.CrudServiceInterface;
import com.commerce.buy.infrastructure.search.service.FilterSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CrudServiceInterface<Category> {
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    FilterSpecification<Category> filter;

    @Override
    public ResponseEntity<Category> create(EntityDto<Category> entityDto) {
        Category category = new Category();
        this.categoryDao.setCategory(category);
        return new ResponseEntity<>(this.categoryDao.create(entityDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Category> update(int id,EntityDto<Category> entityDto) {
        return null;
    }

    @Override
    public ResponseEntity<List<Category>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<Category> getById(int id) {
        return null;
    }

    @Override
    public Category findByName(String name) {
        return this.categoryDao.getCategoryRepository().findByName(name);
    }
}
