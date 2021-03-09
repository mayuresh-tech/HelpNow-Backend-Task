package com.helpnow.repository;

import com.helpnow.entity.Game7Details;
import com.helpnow.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Game7Repository extends JpaRepository<Game7Details, String> {

    Game7Details findByUserEntity(UserEntity userEntity);
}
