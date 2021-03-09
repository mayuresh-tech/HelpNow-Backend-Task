package com.helpnow.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "card_details")
public class CardEntity {

    @Id
    @Column(name = "card_db_id")
    private String cardDBId;

    @Column(name = "card_holder_name")
    private String cardHolderName;

    @Column(name = "card_expire_day")
    private LocalDate cardExpireDay;

    @Column(name = "card_expire_month")
    private LocalDate cardExpireMonth;

    @Column(name = "card_expire_year")
    private LocalDate cardExpireYear;

    @Column(name = "card_balance")
    private Long cardBalance;
}
