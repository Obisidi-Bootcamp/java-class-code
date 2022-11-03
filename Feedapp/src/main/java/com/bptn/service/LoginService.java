package com.bptn.service;

import com.bptn.exceptions.InvalidUserCredentialsException;
import com.bptn.models.UserID;
import com.bptn.repository.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class LoginService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoginRepository loginRepository;

    public String verifyUserCredentials(UserID userCred) throws InvalidUserCredentialsException {
        List<UserID> userEntity = loginRepository.getUserByUserId(userCred.getUsername());

        for (UserID u : userEntity) {
//            LOGGER.info("retrieving username from DB");
//            LOGGER.info("userpassword in service : {}", u.getPassword());
//            LOGGER.info("userCred password in service : {}", userCred.getPassword());

            if (u.getUsername().equals(userCred.getUsername())) {
                if (u.getPassword().equals(userCred.getPassword())) {
                    return "Login Successful";
                } else
                    throw new InvalidUserCredentialsException("Password incorrect: Password doesn't exist");
                }
        }
        return "User login issue: " + new InvalidUserCredentialsException("User login issue: Username doesn't exist ");
    }

}
