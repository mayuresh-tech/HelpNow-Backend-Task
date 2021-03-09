package com.helpnow.repository;

import com.helpnow.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByUserEmail(String userEmail);

    UserEntity findByUserEmailAndUserPassword(String userEmail, String userPassword);

}
