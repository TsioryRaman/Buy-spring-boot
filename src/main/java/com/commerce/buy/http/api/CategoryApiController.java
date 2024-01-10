package com.commerce.buy.http.api;

import com.commerce.buy.http.service.CrudServiceInterface;
import com.commerce.buy.domain.category.dto.CategoryDto;
import com.commerce.buy.domain.category.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryApiController {
    @Autowired
    CrudServiceInterface<Category> categoryCrudService;

    @PostMapping()
    public ResponseEntity<Category> create(@RequestBody CategoryDto categoryDto) throws Exception {
        return this.categoryCrudService.create(categoryDto);
    }
}
