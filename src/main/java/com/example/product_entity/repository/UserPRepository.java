package com.example.product_entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product_entity.model.User;
@Repository
public interface UserPRepository extends JpaRepository<User, Integer> {

}
