package com.helpnow.service;

import java.time.LocalDate;

public interface GameService {

    int swipeInForGame(String userId, int gameCount, LocalDate localDateNow);

}
