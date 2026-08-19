package com.festivGo.controller;

import com.festivGo.dto.UserRequest;
import com.festivGo.entity.User;
import com.festivGo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/v1")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setPhone(userRequest.getPhone());
        user.setRole(userRequest.getRole());
        User saveUser = userService.createuser(user);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }
   
    @GetMapping("/{phone}")
    public ResponseEntity<User> getUser(@PathVariable String phone) {
        return  new ResponseEntity<>(userService.getUserByPhone(phone), HttpStatus.OK);
    }

    @PutMapping("/{phone}")
    public ResponseEntity<User> updateUser(@PathVariable String phone, @RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.updateUser(phone, userRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{phone}")
    public ResponseEntity<Void> deleteUser(@PathVariable String phone) {
        userService.deleteUserByPhone(phone);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
