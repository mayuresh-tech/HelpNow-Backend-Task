package com.helpnow.repository;

import com.helpnow.entity.Game10Details;
import com.helpnow.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface Game10Repository extends JpaRepository<Game10Details, UUID> {

    Game10Details findByUserEntity(UserEntity userEntity);
}
