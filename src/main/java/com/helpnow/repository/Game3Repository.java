package com.helpnow.repository;

import com.helpnow.entity.Game3Details;
import com.helpnow.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Game3Repository extends JpaRepository<Game3Details, String> {

    Game3Details findByUserEntity(UserEntity userEntity);
}
