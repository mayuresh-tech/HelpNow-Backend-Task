package com.helpnow.controller;

import com.helpnow.dto.ResponseDTO;
import com.helpnow.service.GameService;
import com.helpnow.util.ErrorMessages;
import com.helpnow.util.SuccessMessages;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/games")
public class GamesController {

    @Autowired
    GameService gameService;

    @ApiOperation(value = "Play Game 1")
    @GetMapping(path = "/playGame1", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Object playGame1(@RequestParam String userId) {
        int res = gameService.swipeInForGame(userId, 1, LocalDate.now());

        if (res == -1) {
            return new ResponseDTO(412, HttpStatus.PRECONDITION_FAILED, ErrorMessages.INSUFFICIENT_CARD_BALANCE);
        } else if (res == 0) {
            return new ResponseDTO(412, HttpStatus.PRECONDITION_FAILED, ErrorMessages.LINEAR_GAME_PLAY);
        } else if (res == 1) {
            return new ResponseDTO(201, HttpStatus.OK, SuccessMessages.SAVED);
        } else {
            return new ResponseDTO(500, HttpStatus.INTERNAL_SERVER_ERROR, ErrorMessages.CONTACT_ADMIN);
        }
    }

    @ApiOperation(value = "Play Game 2")
    @GetMapping(path = "/playGame2", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Object playGame2(@RequestParam String userId) {
        int res = gameService.swipeInForGame(userId, 2, LocalDate.now());

        if (res == -1) {
            return new ResponseDTO(412, HttpStatus.PRECONDITION_FAILED, ErrorMessages.INSUFFICIENT_CARD_BALANCE);
        } else if (res == 0) {
            return new ResponseDTO(412, HttpStatus.PRECONDITION_FAILED, ErrorMessages.LINEAR_GAME_PLAY);
        } else if (res == 1) {
            return new ResponseDTO(201, HttpStatus.OK, SuccessMessages.SAVED);
        } else {
            return new ResponseDTO(500, HttpStatus.INTERNAL_SERVER_ERROR, ErrorMessages.CONTACT_ADMIN);
        }
    }

    @ApiOperation(value = "Play Game 3")
    @GetMapping(path = "/playGame3", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Object playGame3(@RequestParam String userId) {
        int res = gameService.swipeInForGame(userId, 3, LocalDate.now());

        if (res == -1) {
            return new ResponseDTO(412, HttpStatus.PRECONDITION_FAILED, ErrorMessages.INSUFFICIENT_CARD_BALANCE);
        } else if (res == 0) {
            return new ResponseDTO(412, HttpStatus.PRECONDITION_FAILED, ErrorMessages.LINEAR_GAME_PLAY);
        } else if (res == 1) {
            return new ResponseDTO(201, HttpStatus.OK, SuccessMessages.SAVED);
        } else {
            return new ResponseDTO(500, HttpStatus.INTERNAL_SERVER_ERROR, ErrorMessages.CONTACT_ADMIN);
        }
    }

    @ApiOperation(value = "Play Game 4")
    @GetMapping(path = "/playGame4", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Object playGame4(@RequestParam String userId) {
        int res = gameService.swipeInForGame(userId, 4, LocalDate.now());

        if (res == -1) {
            return new ResponseDTO(412, HttpStatus.PRECONDITION_FAILED, ErrorMessages.INSUFFICIENT_CARD_BALANCE);
        } else if (res == 0) {
            return new ResponseDTO(412, HttpStatus.PRECONDITION_FAILED, ErrorMessages.LINEAR_GAME_PLAY);
        } else if (res == 1) {
            return new ResponseDTO(201, HttpStatus.OK, SuccessMessages.SAVED);
        } else {
            return new ResponseDTO(500, HttpStatus.INTERNAL_SERVER_ERROR, ErrorMessages.CONTACT_ADMIN);
        }
    }

    @ApiOperation(value = "Play Game 5")
    @GetMapping(path = "/playGame5", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Object playGame5(@RequestParam String userId) {
        int res = gameService.swipeInForGame(userId, 5, LocalDate.now());

        if (res == -1) {
            return new ResponseDTO(412, HttpStatus.PRECONDITION_FAILED, ErrorMessages.INSUFFICIENT_CARD_BALANCE);
        } else if (res == 0) {
            return new ResponseDTO(412, HttpStatus.PRECONDITION_FAILED, ErrorMessages.LINEAR_GAME_PLAY);
        } else if (res == 1) {
            return new ResponseDTO(201, HttpStatus.OK, SuccessMessages.SAVED);
        } else {
            return new ResponseDTO(500, HttpStatus.INTERNAL_SERVER_ERROR, ErrorMessages.CONTACT_ADMIN);
        }
    }

    @ApiOperation(value = "Play Game 6")
    @GetMapping(path = "/playGame6", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Object playGame6(@RequestParam String userId) {
        int res = gameService.swipeInForGame(userId, 6, LocalDate.now());

        if (res == -1) {
            return new ResponseDTO(412, HttpStatus.PRECONDITION_FAILED, ErrorMessages.INSUFFICIENT_CARD_BALANCE);
        } else if (res == 0) {
            return new ResponseDTO(412, HttpStatus.PRECONDITION_FAILED, ErrorMessages.LINEAR_GAME_PLAY);
        } else if (res == 1) {
            return new ResponseDTO(201, HttpStatus.OK, SuccessMessages.SAVED);
        } else {
            return new ResponseDTO(500, HttpStatus.INTERNAL_SERVER_ERROR, ErrorMessages.CONTACT_ADMIN);
        }
    }

    @ApiOperation(value = "Play Game 7")
    @GetMapping(path = "/playGame7", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Object playGame7(@RequestParam String userId) {
        int res = gameService.swipeInForGame(userId, 7, LocalDate.now());

        if (res == -1) {
            return new ResponseDTO(412, HttpStatus.PRECONDITION_FAILED, ErrorMessages.INSUFFICIENT_CARD_BALANCE);
        } else if (res == 0) {
            return new ResponseDTO(412, HttpStatus.PRECONDITION_FAILED, ErrorMessages.LINEAR_GAME_PLAY);
        } else if (res == 1) {
            return new ResponseDTO(201, HttpStatus.OK, SuccessMessages.SAVED);
        } else {
            return new ResponseDTO(500, HttpStatus.INTERNAL_SERVER_ERROR, ErrorMessages.CONTACT_ADMIN);
        }
    }

    @ApiOperation(value = "Play Game 8")
    @GetMapping(path = "/playGame8", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Object playGame8(@RequestParam String userId) {
        int res = gameService.swipeInForGame(userId, 8, LocalDate.now());

        if (res == -1) {
            return new ResponseDTO(412, HttpStatus.PRECONDITION_FAILED, ErrorMessages.INSUFFICIENT_CARD_BALANCE);
        } else if (res == 0) {
            return new ResponseDTO(412, HttpStatus.PRECONDITION_FAILED, ErrorMessages.LINEAR_GAME_PLAY);
        } else if (res == 1) {
            return new ResponseDTO(201, HttpStatus.OK, SuccessMessages.SAVED);
        } else {
            return new ResponseDTO(500, HttpStatus.INTERNAL_SERVER_ERROR, ErrorMessages.CONTACT_ADMIN);
        }
    }

    @ApiOperation(value = "Play Game 9")
    @GetMapping(path = "/playGame9", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Object playGame9(@RequestParam String userId) {
        int res = gameService.swipeInForGame(userId, 9, LocalDate.now());

        if (res == -1) {
            return new ResponseDTO(412, HttpStatus.PRECONDITION_FAILED, ErrorMessages.INSUFFICIENT_CARD_BALANCE);
        } else if (res == 0) {
            return new ResponseDTO(412, HttpStatus.PRECONDITION_FAILED, ErrorMessages.LINEAR_GAME_PLAY);
        } else if (res == 1) {
            return new ResponseDTO(201, HttpStatus.OK, SuccessMessages.SAVED);
        } else {
            return new ResponseDTO(500, HttpStatus.INTERNAL_SERVER_ERROR, ErrorMessages.CONTACT_ADMIN);
        }
    }

    @ApiOperation(value = "Play Game 10")
    @GetMapping(path = "/playGame10", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Object playGame10(@RequestParam String userId) {
        int res = gameService.swipeInForGame(userId, 10, LocalDate.now());

        if (res == -1) {
            return new ResponseDTO(412, HttpStatus.PRECONDITION_FAILED, ErrorMessages.INSUFFICIENT_CARD_BALANCE);
        } else if (res == 0) {
            return new ResponseDTO(412, HttpStatus.PRECONDITION_FAILED, ErrorMessages.LINEAR_GAME_PLAY);
        } else if (res == 1) {
            return new ResponseDTO(201, HttpStatus.OK, SuccessMessages.SAVED);
        } else {
            return new ResponseDTO(500, HttpStatus.INTERNAL_SERVER_ERROR, ErrorMessages.CONTACT_ADMIN);
        }
    }

}
