package com.helpnow.repository;

import com.helpnow.entity.Game9Details;
import com.helpnow.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface Game9Repository extends JpaRepository<Game9Details, UUID> {

    Game9Details findByUserEntity(UserEntity userEntity);
}
