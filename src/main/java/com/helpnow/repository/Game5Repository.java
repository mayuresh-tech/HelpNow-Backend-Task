package com.helpnow.repository;

import com.helpnow.entity.Game5Details;
import com.helpnow.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Game5Repository extends JpaRepository<Game5Details, String> {

    Game5Details findByUserEntity(UserEntity userEntity);
}
