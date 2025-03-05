package com.scaler.amit.project_ecomservice.repositories;

import com.scaler.amit.project_ecomservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
