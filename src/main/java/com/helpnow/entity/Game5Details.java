package com.helpnow.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "game5_details")
public class Game5Details {

    @Id
    @Column(name = "game5_db_id")
    private String game5DBId;

    @Column(name = "game5_name")
    private String game5Name;

    @ManyToOne
    @JoinColumn(name = "user_played", nullable = false)
    private UserEntity userEntity;
}
