package com.commerce.buy.infrastructure.repository;

import com.commerce.buy.domain.blog.model.Blog;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<Blog, Integer> {

}
