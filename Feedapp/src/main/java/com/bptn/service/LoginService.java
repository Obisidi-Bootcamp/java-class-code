package com.bptn.service;
//
//import com.bptn.exceptions.InvalidRequestException;
import com.bptn.exceptions.InvalidUserCredentialsException;
//import com.bptn.exceptions.InvalidUserNameException;
import com.bptn.models.AuthenticationUser;
import com.bptn.models.UserID;
import com.bptn.repository.AuthenticationUserRepository;
import com.bptn.request.LoginRequest;
//import com.bptn.request.SignupRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuthenticationUserRepository authenticationUserRepository;


//    @Autowired
//    private UserService userService;


    public UserID verifyUserCredentials(LoginRequest loginRequest) throws InvalidUserCredentialsException {
        LOGGER.debug("Invoking login = {}", "verifyUserCredentials");
        if (StringUtils.isEmpty(loginRequest.getUsername()) || StringUtils.isEmpty(loginRequest.getPassword())){
            LOGGER.debug("Username = {} or Password = {} can't be empty", loginRequest.getUsername(), loginRequest.getPassword());
            throw new InvalidUserCredentialsException("Username or Password can't be empty");
        }
        AuthenticationUser authenticationUser =
                authenticationUserRepository.findAuthenticationUserByIdAndUserPassword(loginRequest.getUsername(), loginRequest.getPassword());
        if (authenticationUser == null) {
            throw new InvalidUserCredentialsException("Invalid Credentials");
        }
        LOGGER.debug("Username = {} or Password = {} validated successfully", loginRequest.getUsername(), loginRequest.getPassword());
        return authenticationUser.getUserID();
    }
//
//    public UserID signup(SignupRequest signupRequest) throws InvalidRequestException {
//        try {
//            userService.validateUserId(signupRequest.getUsername());
//            throw new InvalidRequestException("User already exist");
//        } catch (InvalidUserNameException invalidUserNameException) {
//            LOGGER.info("Expected Error. User doesn't exist");
//        }
//        UserID userID = new UserID();
//        userID.setUsername(signupRequest.getUsername());
//        userID.setEmailID(signupRequest.getEmailId());
//        userID.setPhoneNumber(signupRequest.getPhoneNumber());
//        userID.setName(signupRequest.getName());
//        AuthenticationUser authenticationUser = new AuthenticationUser();
//        authenticationUser.setId(signupRequest.getUsername());
//        authenticationUser.setUserPassword(signupRequest.getPassword());
//        authenticationUser.setUserID(userID);
//        authenticationUser.setPhoneNumber(signupRequest.getPhoneNumber());
//        //Since there are non-null constraints on authentication user table, we're setting them empty.
//        authenticationUser.setSecurityQuestion1(StringUtils.EMPTY);
//        authenticationUser.setSecurityQuestion2(StringUtils.EMPTY);
//        authenticationUser.setSecurityQuestion3(StringUtils.EMPTY);
//        authenticationUser.setSecurityAnswer1(StringUtils.EMPTY);
//        authenticationUser.setSecurityAnswer2(StringUtils.EMPTY);
//        authenticationUser.setSecurityAnswer3(StringUtils.EMPTY);
//        authenticationUser = authenticationUserRepository.save(authenticationUser);
//        return authenticationUser.getUserID();
//    }
//
}