package com.helpnow.repository;

import com.helpnow.entity.Game4Details;
import com.helpnow.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface Game4Repository extends JpaRepository<Game4Details, UUID> {

    Game4Details findByUserEntity(UserEntity userEntity);
}
