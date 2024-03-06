package com.reservationapp.controller;

import com.reservationapp.entity.UserRegistration;
import com.reservationapp.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/user")
//@RequiredArgsConstructor
public class UserRegistrationController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<?> createUser(
        @RequestParam("name") String name,
        @RequestParam("email") String email,
        @RequestParam("password") String password,
        @RequestParam("profilePicture") MultipartFile profilePicture
    ){
      try {
          UserRegistration user = new UserRegistration();
          user.setName(name);
          user.setEmail(email);
          user.setPassword(password);
          user.setProfilePicture(profilePicture.getBytes());
          userService.createUser(user);
      }catch (Exception e){
          e.printStackTrace();
      }
      return new ResponseEntity<>("done...", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRegistration> getUserById(@PathVariable long id){
        UserRegistration user = userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
