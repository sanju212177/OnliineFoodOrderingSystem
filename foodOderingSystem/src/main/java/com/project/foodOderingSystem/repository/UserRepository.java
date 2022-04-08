package com.project.foodOderingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.foodOderingSystem.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
