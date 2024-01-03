package com.commerce.buy.infrastructure.validation.repository;

import com.commerce.buy.domain.user.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
