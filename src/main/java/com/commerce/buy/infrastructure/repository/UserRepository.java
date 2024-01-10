package com.commerce.buy.infrastructure.repository;

import com.commerce.buy.domain.user.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
