package com.helpnow.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "game4_details")
public class Game4Details {

    @Id
    @GeneratedValue
    @Column(name = "game4_db_id")
    private UUID game4DBId;

    @ManyToOne
    @JoinColumn(name = "user_played", nullable = false)
    private UserEntity userEntity;
}
