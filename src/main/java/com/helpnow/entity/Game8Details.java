package com.helpnow.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "game8_details")
public class Game8Details {

    @Id
    @Column(name = "game8_db_id")
    private String game8DBId;

    @Column(name = "game8_name")
    private String game8Name;

    @ManyToOne
    @JoinColumn(name = "user_played", nullable = false)
    private UserEntity userEntity;
}
