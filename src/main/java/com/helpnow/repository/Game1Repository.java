package com.helpnow.repository;

import com.helpnow.entity.Game1Details;
import com.helpnow.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface Game1Repository extends JpaRepository<Game1Details, UUID> {

    Game1Details findByUserEntity(UserEntity userEntity);
}
