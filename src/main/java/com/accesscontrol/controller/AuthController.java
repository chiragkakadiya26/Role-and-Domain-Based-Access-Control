package com.accesscontrol.controller;

import com.accesscontrol.model.User;
import com.accesscontrol.payload.JwtRequest;
import com.accesscontrol.payload.JwtResponse;
import com.accesscontrol.service.AuthService;
import com.accesscontrol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest jwtRequest) throws Exception {
        return new ResponseEntity<>(authService.login(jwtRequest), HttpStatus.CREATED);
    }

}
