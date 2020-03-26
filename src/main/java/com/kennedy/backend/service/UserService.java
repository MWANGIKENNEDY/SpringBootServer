package com.kennedy.backend.service;

import com.kennedy.backend.model.UserModel;
import com.kennedy.backend.repository.UserRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserRepo userRepo;
    
    //get all users
    public List getAllUsers(){
        return userRepo.findAll();    
    }
    //create a new user
    public void register(UserModel userModel){
        userRepo.save(userModel);
        
    }
    
}
