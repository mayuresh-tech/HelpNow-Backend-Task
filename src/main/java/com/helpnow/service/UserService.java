package com.helpnow.service;

import com.helpnow.dto.UserDTO;

public interface UserService {

    String createUser(UserDTO userDTO, String password);

    UserDTO signInUser(String email, String password);

}
