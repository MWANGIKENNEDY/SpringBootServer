package com.kennedy.backend.service;

import com.kennedy.backend.model.UserModel;
import com.kennedy.backend.repository.UserRepo;
import java.util.List;
import java.util.Optional;
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
    //get one user/post
    public Optional<UserModel> getOneUser(Long id){
        return userRepo.findById(id);
    }
    //update user details
    public void updateUser(UserModel userModel){
        userRepo.save(userModel);
    }
    //delete user
    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }
    
}
