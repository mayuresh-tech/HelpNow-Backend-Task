package com.helpnow.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ResponseDTO {

    public ResponseDTO() {

    }

    int status;

    HttpStatus httpStatus;

    String message;
}
