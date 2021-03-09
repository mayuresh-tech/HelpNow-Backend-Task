package com.helpnow.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "game6_details")
public class Game6Details {

    @Id
    @Column(name = "game6_db_id")
    private String game6DBId;

    @Column(name = "game6_name")
    private String game6Name;

    @ManyToOne
    @JoinColumn(name = "user_played", nullable = false)
    private UserEntity userEntity;
}
