package com.helpnow.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "game8_details")
public class Game8Details {

    @Id
    @GeneratedValue
    @Column(name = "game8_db_id")
    private UUID game8DBId;

    @ManyToOne
    @JoinColumn(name = "user_played", nullable = false)
    private UserEntity userEntity;
}
