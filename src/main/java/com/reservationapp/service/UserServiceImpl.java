package com.reservationapp.service;

import com.reservationapp.entity.User;
import com.reservationapp.paylaod.UserDto;
import com.reservationapp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
//@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(String name, String email, String mobile, String password, MultipartFile profilePicture) throws IOException {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setMobile(mobile);
        user.setPassword(password);
        user.setProfilePicture(profilePicture.getBytes());
        User saveUsers = userRepository.save(user);
        UserDto mapToUserDto = modelMapper.map(saveUsers, UserDto.class);
        return mapToUserDto;
    }

    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }

}
