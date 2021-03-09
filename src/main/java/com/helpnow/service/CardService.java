package com.helpnow.service;

import com.helpnow.dto.CardDTO;

public interface CardService {

    CardDTO getCardDetails(String userEmail, String userPassword);

    CardDTO updateBalance(String paymentGatewayAuth, String userEmail, String userPassword, Long addMoney);

}
