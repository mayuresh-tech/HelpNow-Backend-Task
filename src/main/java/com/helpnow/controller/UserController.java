package com.helpnow.controller;

import com.helpnow.dto.ResponseDTO;
import com.helpnow.dto.UserDTO;
import com.helpnow.service.UserService;
import com.helpnow.util.ErrorMessages;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "Sign up new User")
    @GetMapping(path = "/signUpUser", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Object createNewUser(@RequestHeader("X-AUTH-TOKEN") @RequestParam(required = false) String token, @RequestParam String userName, @RequestParam String userEmail, @RequestParam String userPassword) {
        UserDTO userDTO = new UserDTO(null, userName, userEmail);

        String res = userService.createUser(userDTO, userPassword);
        if (res.equals("Duplicate")) {
            return new ResponseDTO(412, HttpStatus.PRECONDITION_FAILED, ErrorMessages.DUPLICATE_EMAIL);
        } else {
            return new ResponseDTO(201, HttpStatus.CREATED, res);
        }
    }

    @ApiOperation(value = "Sign in existing User")
    @GetMapping(path = "/signInUser", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Object createNewUser(@RequestHeader("X-AUTH-TOKEN") @RequestParam(required = false) String token, @RequestParam String userEmail, @RequestParam String userPassword) {

        UserDTO userDTO = userService.signInUser(userEmail, userPassword);
        if (userDTO == null) {
            return new ResponseDTO(401, HttpStatus.UNAUTHORIZED, ErrorMessages.INCORRECT_CREDENTIALS);
        } else {
            return userDTO;
        }
    }

}
