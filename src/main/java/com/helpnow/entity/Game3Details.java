package com.helpnow.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "game3_details")
public class Game3Details {

    @Id
    @Column(name = "game3_db_id")
    private String game3DBId;

    @Column(name = "game3_name")
    private String game3Name;

    @ManyToOne
    @JoinColumn(name = "user_played", nullable = false)
    private UserEntity userEntity;
}
