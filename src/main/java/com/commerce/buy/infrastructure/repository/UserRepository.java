package com.commerce.buy.infrastructure.repository;

import com.commerce.buy.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsByUsername(String name);

}
