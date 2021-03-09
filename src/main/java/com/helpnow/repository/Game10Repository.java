package com.helpnow.repository;

import com.helpnow.entity.Game10Details;
import com.helpnow.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Game10Repository extends JpaRepository<Game10Details, String> {

    Game10Details findByUserEntity(UserEntity userEntity);
}
