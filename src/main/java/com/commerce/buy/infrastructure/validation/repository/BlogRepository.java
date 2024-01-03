package com.commerce.buy.infrastructure.validation.repository;

import com.commerce.buy.domain.blog.model.Blog;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BlogRepository extends CrudRepository<Blog, Integer> {
}
