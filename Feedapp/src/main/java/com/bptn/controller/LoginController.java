package com.bptn.controller;
//
import com.bptn.exceptions.InvalidRequestException;
import com.bptn.exceptions.InvalidUserCredentialsException;
import com.bptn.models.UserID;
import com.bptn.request.LoginRequest;
//import com.bptn.request.SignupRequest;
import com.bptn.response.JwtResponse;
import com.bptn.response.LoginResponse;
import com.bptn.service.JwtService;
import com.bptn.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class LoginController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoginService loginService;

    @Autowired
    private JwtService jwtService;

//    /*
//        {
//        "username": "amit7",
//        "password":"amit7"
//        }
//    */
    @PostMapping("/user/login")
    public ResponseEntity<?> verifyUserCredentials(@RequestBody LoginRequest loginRequest) throws InvalidUserCredentialsException {
        LOGGER.debug("Login request received for username = {} & password = {}", loginRequest.getUsername(), loginRequest.getPassword());
        UserID userID = loginService.verifyUserCredentials(loginRequest);
        if (userID == null) {
            throw new InvalidUserCredentialsException("Invalid User");
        }
        JwtResponse jwtResponse = new JwtResponse(jwtService.generateJwtToken(loginRequest.getUsername()));
        return new ResponseEntity<>(new LoginResponse(userID, jwtResponse), HttpStatus.OK);
    }

//    /*
//    {
//    "username": "amit5",
//    "name": "amit",
//    "emailId": "amit@gmail.com",
//    "phoneNumber": "8888888888",
//    "password": "amit"
//    }
// */
//
//    @PostMapping("/user/signup")
//    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) throws InvalidRequestException {
//        LOGGER.debug("signup request received = {}",signupRequest);
//        UserID userID = loginService.signup(signupRequest);
//        return new ResponseEntity<>(userID, HttpStatus.OK);
//    }
//
//
}
