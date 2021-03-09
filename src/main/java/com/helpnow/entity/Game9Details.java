package com.helpnow.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "game9_details")
public class Game9Details {

    @Id
    @Column(name = "game9_db_id")
    private String game9DBId;

    @Column(name = "game9_name")
    private String game9Name;

    @ManyToOne
    @JoinColumn(name = "user_played", nullable = false)
    private UserEntity userEntity;
}
