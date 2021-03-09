package com.helpnow.repository;

import com.helpnow.entity.Game2Details;
import com.helpnow.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface Game2Repository extends JpaRepository<Game2Details, UUID> {

    Game2Details findByUserEntity(UserEntity userEntity);
}
