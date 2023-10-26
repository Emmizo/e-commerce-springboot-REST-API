package com.ecomerce.ecommercebackend.service;

import org.springframework.stereotype.Service;

import com.ecomerce.ecommercebackend.Model.LocalUser;
import com.ecomerce.ecommercebackend.Model.dao.LocalUserDao;
import com.ecomerce.ecommercebackend.api.model.RegistrationBody;
import com.ecomerce.ecommercebackend.exception.UserAlreadyExistsException;


@Service
public class UserService {
    
 private LocalUserDao localUserDao; 

    public UserService(LocalUserDao localUserDao) {
    this.localUserDao = localUserDao;
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
        user.setPassword(registrationBody.getPassword());
        user= localUserDao.save(user);
        return user;
    }
}
