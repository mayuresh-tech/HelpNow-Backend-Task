package com.helpnow.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "game1_details")
public class Game1Details {

    @Id
    @Column(name = "game1_db_id")
    private String game1DBId;

    @Column(name = "game1_name")
    private String game1Name;

    @ManyToOne
    @JoinColumn(name = "user_played", nullable = false)
    private UserEntity userEntity;
}
