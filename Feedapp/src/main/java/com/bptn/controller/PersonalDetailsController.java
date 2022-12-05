package com.bptn.controller;

import com.bptn.models.AuthenticationUser;
import com.bptn.models.Profile;
import com.bptn.models.UserID;
import com.bptn.request.AddressRequest;
import com.bptn.service.PersonalDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PersonalDetailsController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonalDetailsService personalDetailsService;

   /*
   {
    "id": "amit5",
    "securityQuestion1": "<QUESTION1>",
    "securityAnswer1": "<ANSWER1>",
    "securityQuestion2": "<QUESTION2>",
    "securityAnswer2": "<ANSWER2>",
    "securityQuestion3": "<QUESTION3>",
    "securityAnswer3": "<ANSWER3>",
    "phoneNumber": "8888888888",
    "userPassword": "amit"
}
    */
    @PutMapping("/user/personal/security")
    public ResponseEntity<?> securityUpdate(@RequestBody AuthenticationUser authenticationUser)  {
        LOGGER.debug("securityUpdate request received = {}", authenticationUser);
        authenticationUser = personalDetailsService.securityUpdate(authenticationUser);
        return new ResponseEntity<>(authenticationUser, HttpStatus.OK);
    }

    /*
        {
        "position" : "developer1",
        "company": "hurix1",
        "username" : "amit5",
        "skills": "skills1",
        "certification": "certification1",
        "companyAddress":"companyAddress1",
        "interests":"interests1",
        "experience": "experience1",
        "education": "education1",
        "languages":"languages1"
        }
     */
    @PutMapping("/user/personal/profile")
    public ResponseEntity<?> profileUpdate(@RequestBody Profile profile)  {
        LOGGER.debug("profileUpdate request received = {}", profile);
        profile = personalDetailsService.profileUpdate(profile);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    /*
        {
        "city": "Delhi",
        "state": "Delhi",
        "country": "India",
        "address": "North Delhi",
        "pincode": "23321",
        "username": "jDoe3280"
        }
     */
    @PutMapping("/user/personal/address")
    public ResponseEntity<?> addressUpdate(@RequestBody AddressRequest addressRequest)  {
        LOGGER.debug("addressUpdate request received = {}", addressRequest);
        UserID userID = personalDetailsService.addressUpdate(addressRequest);
        return new ResponseEntity<>(userID, HttpStatus.OK);
    }
}
