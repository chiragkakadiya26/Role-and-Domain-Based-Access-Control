package com.accesscontrol.service;

import com.accesscontrol.payload.JwtRequest;
import com.accesscontrol.payload.JwtResponse;

public interface AuthService {
    public JwtResponse login(JwtRequest jwtRequest) throws Exception;
}
