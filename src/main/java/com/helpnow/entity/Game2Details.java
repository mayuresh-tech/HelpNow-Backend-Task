package com.helpnow.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "game2_details")
public class Game2Details {

    @Id
    @GeneratedValue
    @Column(name = "game2_db_id")
    private UUID game2DBId;

    @ManyToOne
    @JoinColumn(name = "user_played", nullable = false)
    private UserEntity userEntity;
}
