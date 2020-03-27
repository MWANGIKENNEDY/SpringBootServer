package com.kennedy.backend.controller;

import com.kennedy.backend.model.UserModel;
import com.kennedy.backend.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    UserService userService;
    //GET ALL USERS
    @RequestMapping(value="/api/users",method=RequestMethod.GET)
    public ResponseEntity<Object> users(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }
    //get one record
    @RequestMapping(value="/api/users/{id}",method=RequestMethod.GET)
    public ResponseEntity<Object> getOneUser(@PathVariable("id") Long id){
        return new ResponseEntity<>(userService.getOneUser(id),HttpStatus.OK);
    }
    //CREATE A NEW USER
    @RequestMapping(value="/api/users/",method=RequestMethod.POST)
    public ResponseEntity<Object> registerUser(@RequestBody UserModel userModel){
        userService.register(userModel); 
        return new ResponseEntity<>("User registered",HttpStatus.CREATED);
    }
    //UPDATE USER DETAILS
    @RequestMapping(value="/api/users/{id}",method=RequestMethod.PUT)
    public ResponseEntity<Object> updateUser(@PathVariable("id") Long id, @RequestBody UserModel userModel){
        userModel.setId(id);
        userService.updateUser(userModel);
        return new ResponseEntity<>("User updated !",HttpStatus.OK);
    }
    //delete a user from the system
    @RequestMapping(value="/api/users/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted !",HttpStatus.OK);
    }
    
    
    
}
