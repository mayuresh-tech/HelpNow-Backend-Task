package com.helpnow.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "game10_details")
public class Game10Details {

    @Id
    @Column(name = "game10_db_id")
    private String game10DBId;

    @Column(name = "game10_name")
    private String game10Name;

    @ManyToOne
    @JoinColumn(name = "user_played", nullable = false)
    private UserEntity userEntity;
}
