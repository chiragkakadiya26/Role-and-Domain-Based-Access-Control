package com.accesscontrol.payload;


import com.accesscontrol.model.Role;

import java.util.List;

public class JwtResponse {
        private String username;
        private String jwtToken;
        private List<Role> role;

    public JwtResponse() {
    }

    public JwtResponse(String username, String jwtToken, List<Role> role) {
        this.username = username;
        this.jwtToken = jwtToken;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
}
