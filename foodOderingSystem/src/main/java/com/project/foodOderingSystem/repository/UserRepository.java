package com.project.foodOderingSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.project.foodOderingSystem.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "SELECT * FROM users WHERE user_name = :userName",nativeQuery = true)
    User loadUserByUsername(@Param("userName") String userName);
}
