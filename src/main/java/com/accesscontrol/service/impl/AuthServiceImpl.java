package com.accesscontrol.service.impl;

import com.accesscontrol.jwtauth.JwtUtilService;
import com.accesscontrol.model.User;
import com.accesscontrol.payload.JwtRequest;
import com.accesscontrol.payload.JwtResponse;
import com.accesscontrol.repository.UserRepository;
import com.accesscontrol.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private JwtUtilService jwtUtilService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomDetailsService customDetailsService;

    @Override
    public JwtResponse login(JwtRequest jwtRequest) throws Exception {
        String userName = jwtRequest.getUserName();
        String userPassword = jwtRequest.getPassword();
        doAuthenticate(userName, userPassword);

        UserDetails userDetails = customDetailsService.loadUserByUsername(userName);
        System.out.println("UserDetails : " + userDetails.getAuthorities());
        String newGeneratedToken = jwtUtilService.generateToken(userDetails);

        User user = userRepository.findByEmail(userName);
        JwtResponse jwtResponse = new JwtResponse();
        if(user != null){
            jwtResponse.setJwtToken(newGeneratedToken);
            jwtResponse.setUsername(user.getEmail());
            jwtResponse.setRole(user.getRoles());
        }

        return jwtResponse;
    }

    private void doAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            authenticationManager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }
    }
}
