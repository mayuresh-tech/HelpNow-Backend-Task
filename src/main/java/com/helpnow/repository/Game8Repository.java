package com.helpnow.repository;

import com.helpnow.entity.Game8Details;
import com.helpnow.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface Game8Repository extends JpaRepository<Game8Details, UUID> {

    Game8Details findByUserEntity(UserEntity userEntity);
}
