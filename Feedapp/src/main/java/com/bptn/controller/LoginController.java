package com.bptn.controller;

import com.bptn.exceptions.InvalidUserCredentialsException;
import com.bptn.models.UserID;
import com.bptn.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class LoginController {


    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/user/login")
    public ResponseEntity<?> verifyUserCredentials(@RequestBody UserID userCred) throws InvalidUserCredentialsException {

        String loginDetails = loginService.verifyUserCredentials(userCred);
        return new ResponseEntity<>(loginDetails, HttpStatus.OK);
    }
}
