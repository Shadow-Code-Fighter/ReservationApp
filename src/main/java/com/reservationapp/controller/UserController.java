package com.reservationapp.controller;

import com.reservationapp.entity.User;
import com.reservationapp.paylaod.UserDto;
import com.reservationapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/yatra")
//@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;


//  http://localhost:8080/yatra/users/add
    @PostMapping("/users/add")
    public ResponseEntity<UserDto> createUser(
            @Valid @RequestParam("name") String name,
            @Valid @RequestParam("email") String email,
            @Valid @RequestParam("mobile") String mobile,
            @Valid @RequestParam("password") String password,
            @Valid @RequestParam("profilePicture") MultipartFile profilePicture
    ) throws IOException {
        UserDto users = userService.createUser(name,email,mobile,password,profilePicture);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

//    http://localhost:8080/yatra/users/{id}
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
