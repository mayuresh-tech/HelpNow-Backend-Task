package com.helpnow.repository;

import com.helpnow.entity.Game6Details;
import com.helpnow.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface Game6Repository extends JpaRepository<Game6Details, UUID> {

    Game6Details findByUserEntity(UserEntity userEntity);
}
