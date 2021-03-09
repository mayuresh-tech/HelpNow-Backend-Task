package com.helpnow.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "game2_details")
public class Game2Details {

    @Id
    @Column(name = "game2_db_id")
    private String game2DBId;

    @Column(name = "game2_name")
    private String game2Name;

    @ManyToOne
    @JoinColumn(name = "user_played", nullable = false)
    private UserEntity userEntity;
}
