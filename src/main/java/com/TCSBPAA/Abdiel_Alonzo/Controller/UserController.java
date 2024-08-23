package com.TCSBPAA.Abdiel_Alonzo.Controller;

import com.TCSBPAA.Abdiel_Alonzo.Exception.UserNotFoundException;
import com.TCSBPAA.Abdiel_Alonzo.Interface.UserRepository;
import com.TCSBPAA.Abdiel_Alonzo.Users.User;
import com.TCSBPAA.Abdiel_Alonzo.Users.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    User createUser(@RequestBody UserDto userDto) {
        User user = new User(userDto);
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    User findById(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent())
            return optionalUser.get();
        else throw new UserNotFoundException();
    }

}