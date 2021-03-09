package com.helpnow.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "game9_details")
public class Game9Details {

    @Id
    @GeneratedValue
    @Column(name = "game9_db_id")
    private UUID game9DBId;

    @ManyToOne
    @JoinColumn(name = "user_played", nullable = false)
    private UserEntity userEntity;
}
