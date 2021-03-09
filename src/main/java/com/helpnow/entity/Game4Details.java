package com.helpnow.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "game4_details")
public class Game4Details {

    @Id
    @Column(name = "game4_db_id")
    private String game4DBId;

    @Column(name = "game4_name")
    private String game4Name;

    @ManyToOne
    @JoinColumn(name = "user_played", nullable = false)
    private UserEntity userEntity;
}
