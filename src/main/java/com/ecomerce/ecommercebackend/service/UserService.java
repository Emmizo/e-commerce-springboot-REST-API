package com.ecomerce.ecommercebackend.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecomerce.ecommercebackend.Model.LocalUser;
import com.ecomerce.ecommercebackend.Model.dao.LocalUserDao;
import com.ecomerce.ecommercebackend.api.model.LoginBody;
import com.ecomerce.ecommercebackend.api.model.RegistrationBody;
import com.ecomerce.ecommercebackend.exception.UserAlreadyExistsException;


@Service
public class UserService {
    
 private LocalUserDao localUserDao; 
 private EncryptionService encryptionService;
 private JWTService jwtService;



    public UserService(LocalUserDao localUserDao, EncryptionService encryptionService,JWTService jwtService) {
    this.localUserDao = localUserDao;
    this.encryptionService = encryptionService;
     this.jwtService = jwtService;
}

    public LocalUser registerUser( RegistrationBody registrationBody) throws UserAlreadyExistsException{
      
        if(localUserDao.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent() && localUserDao.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent() ){
            throw new UserAlreadyExistsException();
        }
        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setUsername(registrationBody.getUsername());
        user.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));
        user= localUserDao.save(user);
        return user;
    }

    public String loginUser(LoginBody loginBody){
        Optional<LocalUser> opUser = localUserDao.findByUsernameIgnoreCase(loginBody.getUsername());
        if(opUser.isPresent()) {
            LocalUser user = opUser.get();
            if(encryptionService.verifyPassword(loginBody.getPassword(), user.getPassword())) {

                jwtService.generateJWT(user);
                
                
                return  jwtService.generateJWT(user);
            }
        }
    return null;
    }
}
