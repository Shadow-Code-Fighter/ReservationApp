package com.reservationapp.paylaod;

import lombok.Data;

@Data
public class UserDto {
    private long id;
    private String name;
    private String email;
    private String mobile;
    private String password;
    private byte[] profilePicture;
}
