package com.helpnow.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {

    public UserDTO() {

    }

    private String userDBId;

    private String userName;

    private String userEmail;
}
