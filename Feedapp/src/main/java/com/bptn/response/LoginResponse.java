package com.bptn.response;

import com.bptn.models.UserID;

public class LoginResponse {

    private UserID userID;
    private JwtResponse jwtResponse;

    public LoginResponse(UserID userID, JwtResponse jwtResponse) {
        this.userID = userID;
        this.jwtResponse = jwtResponse;
    }

    public UserID getUserID() {
        return userID;
    }

    public void setUserID(UserID userID) {
        this.userID = userID;
    }

    public JwtResponse getJwtResponse() {
        return jwtResponse;
    }

    public void setJwtResponse(JwtResponse jwtResponse) {
        this.jwtResponse = jwtResponse;
    }
}
