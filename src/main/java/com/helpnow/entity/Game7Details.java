package com.helpnow.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "game7_details")
public class Game7Details {

    @Id
    @Column(name = "game7_db_id")
    private String game7DBId;

    @Column(name = "game7_name")
    private String game7Name;

    @ManyToOne
    @JoinColumn(name = "user_played", nullable = false)
    private UserEntity userEntity;
}
