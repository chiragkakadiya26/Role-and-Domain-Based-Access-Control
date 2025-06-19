package com.accesscontrol.payload;


public class JwtRequest {

    private String userName;
    private String Password;

    public JwtRequest() {
    }

    public JwtRequest(String userName, String password) {
        this.userName = userName;
        Password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}