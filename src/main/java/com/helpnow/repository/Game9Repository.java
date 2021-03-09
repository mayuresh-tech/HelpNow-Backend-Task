package com.helpnow.repository;

import com.helpnow.entity.Game9Details;
import com.helpnow.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Game9Repository extends JpaRepository<Game9Details, String> {

    Game9Details findByUserEntity(UserEntity userEntity);
}
