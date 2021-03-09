package com.helpnow.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CardDTO {

    public CardDTO() {

    }

    private String cardHolderName;

    private Long cardBalance;

    private int cardExpireDay;

    private int cardExpireMonth;

    private int cardExpireYear;
}
