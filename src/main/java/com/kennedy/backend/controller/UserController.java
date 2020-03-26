package com.kennedy.backend.controller;

import com.kennedy.backend.model.UserModel;
import com.kennedy.backend.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    UserService userService;
    
    @GetMapping(value="/users")
    public List<UserModel> users(){
        return userService.getAllUsers();
    }
    
    @PostMapping(value="/users/register")
    public void registerUser(@RequestBody UserModel userModel){
        userService.register(userModel);    
    }
}
