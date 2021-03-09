package com.helpnow.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "user_details")
public class UserEntity {

    @Id
    @Column(name = "user_db_id")
    private String userDBId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_password")
    private String userPassword;

    @ManyToOne
    @JoinColumn(name = "card_db_id", nullable = false)
    private CardEntity cardEntity;

}
