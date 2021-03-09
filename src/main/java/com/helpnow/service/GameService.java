package com.helpnow.service;

import com.helpnow.dto.ResponseDTO;

import java.time.LocalDate;

public interface GameService {

    ResponseDTO swipeInForGame(String userId, int gameCount, LocalDate localDateNow, boolean rev);

}
