package com.bptn.service;

import com.bptn.models.*;
import com.bptn.repository.AuthenticationUserRepository;
import com.bptn.repository.UserRepository;
import com.bptn.request.AddressRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PersonalDetailsService {


    @Autowired
    private AuthenticationUserRepository authenticationUserRepository;

    @Autowired
    private UserRepository userRepository;


    public AuthenticationUser securityUpdate(AuthenticationUser authenticationUser) {
        AuthenticationUser authenticationUserFromDB =
                authenticationUserRepository.findAuthenticationUserById(authenticationUser.getId());

        if (authenticationUser.getSecurityQuestion1() != null) {
            authenticationUserFromDB.setSecurityQuestion1(authenticationUser.getSecurityQuestion1());
        }
        if (authenticationUser.getSecurityQuestion2() != null) {
            authenticationUserFromDB.setSecurityQuestion2(authenticationUser.getSecurityQuestion2());
        }
        if (authenticationUser.getSecurityQuestion3() != null) {
            authenticationUserFromDB.setSecurityQuestion3(authenticationUser.getSecurityQuestion3());
        }
        if (authenticationUser.getSecurityAnswer1() != null) {
            authenticationUserFromDB.setSecurityAnswer1(authenticationUser.getSecurityAnswer1());
        }
        if (authenticationUser.getSecurityAnswer2() != null) {
            authenticationUserFromDB.setSecurityAnswer2(authenticationUser.getSecurityAnswer2());
        }
        if (authenticationUser.getSecurityAnswer3() != null) {
            authenticationUserFromDB.setSecurityAnswer3(authenticationUser.getSecurityAnswer3());
        }
        if (authenticationUser.getUserPassword() != null) {
            authenticationUserFromDB.setUserPassword(authenticationUser.getUserPassword());
        }
        if (authenticationUser.getPhoneNumber() != null) {
            authenticationUserFromDB.setPhoneNumber(authenticationUser.getPhoneNumber());
            authenticationUserFromDB.getUserID().setPhoneNumber(authenticationUser.getPhoneNumber());
        }
        return authenticationUserRepository.save(authenticationUserFromDB);
    }

    public Profile profileUpdate(Profile profile) {
        UserID userID = userRepository.findByUsername(profile.getUsername());
        Profile profileFromDB = userID.getProfile();
        if (profileFromDB == null){
            profileFromDB = new Profile();
            profileFromDB.setUsername(profile.getUsername());
            userID.setProfile(profileFromDB);
        }
        if (profile.getCertification() != null) {
            profileFromDB.setCertification(profile.getCertification());
        }
        if (profile.getCompany() != null){
            profileFromDB.setCompany(profile.getCompany());
        }
        if (profile.getEducation() != null){
            profileFromDB.setEducation(profile.getEducation());
        }
        if (profile.getCompanyAddress() != null) {
            profileFromDB.setCompanyAddress(profile.getCompanyAddress());
        }
        if (profile.getExperience() != null) {
            profileFromDB.setExperience(profile.getExperience());
        }
        if (profile.getLanguages() != null){
            profileFromDB.setLanguages(profile.getLanguages());
        }
        if (profile.getInterests() != null) {
            profileFromDB.setInterests(profile.getInterests());
        }
        if (profile.getSkills() != null) {
            profileFromDB.setSkills(profile.getSkills());
        }
        if (profile.getPosition() != null){
            profileFromDB.setPosition(profile.getPosition());
        }
        Set<Role> roles = userID.getRoles();
        Role roleToBeUpdated = null;
        for (Role role : roles){
            if (role.getId().getRole().equals(profile.getPosition())){
                roleToBeUpdated = role;
                break;
            }
        }
        if (roleToBeUpdated == null){
            if (profile.getPosition() != null){
                roleToBeUpdated = new Role();
            }
        }
        if (roleToBeUpdated != null) {
            if (profile.getCompany() != null) {
                roleToBeUpdated.setCompany(profile.getCompany());
            }
            if (profile.getSkills() != null) {
                roleToBeUpdated.setSkills(profile.getSkills());
            }
            if (profile.getPosition() != null) {
                RoleId roleId = roleToBeUpdated.getId();
                if (roleId == null) {
                    roleId = new RoleId();
                }
                roleId.setRole(profile.getPosition());
                if (roleId.getUsernameKey() == null) {
                    roleId.setUsernameKey(profile.getUsername());
                }
                roleToBeUpdated.setId(roleId);
                roleToBeUpdated.setUsernameKey(userID);
            }
            roles.add(roleToBeUpdated);
        }
        profileFromDB.setUserID(userID);
        userID.setRoles(roles);
        userID.setProfile(profileFromDB);
        userID = userRepository.save(userID);
        return userID.getProfile();
    }

    public UserID addressUpdate(AddressRequest addressRequest) {
        UserID userID = userRepository.findByUsername(addressRequest.getUsername());
        Set<Address> addresses = userID.getAddresses();
        String requestKey = addressRequest.getAddress().replaceAll("\\s", "") + addressRequest.getPincode();
        Address addressToBeUpdated = null;
        for (Address address : addresses){
            String key = address.getId().getAddress().replaceAll("\\s", "") + address.getId().getPincode();
            if (requestKey.equals(key)){
                addressToBeUpdated = address;
                break;
            }
        }
        if (addressToBeUpdated == null) {
            addressToBeUpdated = new Address();
            addressToBeUpdated.setId(new AddressId());
            addressToBeUpdated.setUsernameKey(userID);
            userID.getAddresses().add(addressToBeUpdated);
            AddressId addressId = addressToBeUpdated.getId();
            if (addressRequest.getAddress() != null) {
                addressId.setAddress(addressRequest.getAddress());
            }
            if (addressRequest.getPincode() != null) {
                addressId.setPincode(addressRequest.getPincode());
            }
        }
        addressToBeUpdated.setCity(addressRequest.getCity());
        addressToBeUpdated.setCountry(addressRequest.getCountry());
        addressToBeUpdated.setState(addressRequest.getState());
        return userRepository.save(userID);
    }
}
