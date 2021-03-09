package com.helpnow.controller;

import com.helpnow.dto.CardDTO;
import com.helpnow.dto.ResponseDTO;
import com.helpnow.service.CardService;
import com.helpnow.util.ErrorMessages;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;

    @ApiOperation(value = "Get Card details")
    @GetMapping(path = "/getCardDetails", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Object getCard(@RequestParam String userEmail, @RequestParam String userPassword) {
        CardDTO cardDTO = cardService.getCardDetails(userEmail, userPassword);
        if (cardDTO == null) {
            return new ResponseDTO(404, HttpStatus.NOT_FOUND, ErrorMessages.INCORRECT_CREDENTIALS);
        } else {
            return cardDTO;
        }
    }

    @ApiOperation(value = "Update Card Balance")
    @GetMapping(path = "/updateBalance", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Object updateCardBalance(@RequestParam String userEmail, @RequestParam String userPassword, @RequestParam Long moneyToAdd) {
        CardDTO cardDTO = cardService.updateBalance("test", userEmail, userPassword, moneyToAdd);
        if (cardDTO == null) {
            return new ResponseDTO(404, HttpStatus.NOT_FOUND, ErrorMessages.INCORRECT_CREDENTIALS);
        } else {
            return cardDTO;
        }
    }

}
