package com.reservationapp.service;

import com.reservationapp.entity.User;
import com.reservationapp.paylaod.UserDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {
    public UserDto createUser(String name, String email, String mobile, String password, MultipartFile profilePicture) throws IOException;

    User getUserById(long id);
}
