package com.no_country.yow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private String username;
    private String password;
    private String rol;

}
