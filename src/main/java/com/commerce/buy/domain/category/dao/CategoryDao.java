package com.commerce.buy.domain.category.dao;

import com.commerce.buy.domain.EntityDao;
import com.commerce.buy.domain.EntityDto;
import com.commerce.buy.domain.category.dto.CategoryDto;
import com.commerce.buy.domain.category.model.Category;
import com.commerce.buy.infrastructure.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryDao implements EntityDao<Category> {
    @Autowired
    CategoryRepository categoryRepository;

    private Category category;
    public Category create(CategoryDto categoryDto)
    {
        this.category = new Category();
        this.category.setName(categoryDto.getName());
        this.category.setCreated_at(new Date());
        this.category.setUpdated_at(new Date());

        return this.categoryRepository.save(category);
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public CategoryRepository getCategoryRepository(){return this.categoryRepository;}

    @Override
    public Category create(EntityDto<Category> entityDto) {
        entityDto.hydrate();
        return this.categoryRepository.save(entityDto.getEntity());
    }

    @Override
    public Category delete(int entityId) {
        return null;
    }

    @Override
    public Category update(int entityId) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        return null;
    }
}
