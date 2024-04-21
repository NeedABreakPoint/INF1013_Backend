package controllers;

import DTO.UserRegistrationDto;
import model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserInfo> registerUser(@RequestBody UserRegistrationDto registrationDto) {
        UserInfo user = userService.createUser(registrationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
