package com.kennedy.backend.controller;

import com.kennedy.backend.model.UserModel;
import com.kennedy.backend.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    UserService userService;
    
    @RequestMapping(value="/users",method=RequestMethod.GET)
    public ResponseEntity<Object> users(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }
    
    @RequestMapping(value="/users/register",method=RequestMethod.POST)
    public ResponseEntity<Object> registerUser(@RequestBody UserModel userModel){
        userService.register(userModel); 
        return new ResponseEntity<>("User registered",HttpStatus.CREATED);
    }
}
