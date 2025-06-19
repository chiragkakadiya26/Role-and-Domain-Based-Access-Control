package com.accesscontrol.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @GetMapping("/dashboard")
    public Map<String, String> dashboard(@AuthenticationPrincipal UserDetails userDetails) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome Dashboard, " + userDetails.getUsername());
        return response;
    }
}
