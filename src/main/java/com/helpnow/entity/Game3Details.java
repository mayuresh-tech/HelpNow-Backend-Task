package com.helpnow.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "game3_details")
public class Game3Details {

    @Id
    @GeneratedValue
    @Column(name = "game3_db_id")
    private UUID game3DBId;

    @ManyToOne
    @JoinColumn(name = "user_played", nullable = false)
    private UserEntity userEntity;
}
