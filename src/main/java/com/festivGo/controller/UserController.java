package com.festivGo.controller;

import com.festivGo.entity.User;
import com.festivGo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/user/v1")
public class UserCcontroller {
    @Autowired
    private UserService userService;

    //post method
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User saveUser = userService.createuser(user);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }
   // GET http://localhost:8080/users/{phone}
    @GetMapping("/{phone}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable String phone) {
        return  new ResponseEntity<>(userService.getUserByPhone(phone), HttpStatus.FOUND);
    }

  //  PUT http://localhost:8080/users/{phone}

    @PutMapping("/{phone}")
    public ResponseEntity<User> updateUser(@PathVariable String phone, @RequestBody User user) {
        //get the user
        return new ResponseEntity<>(userService.updateUser(phone, user), HttpStatus.OK);
    }

   // DELETE http://localhost:8080/users/{phone}
    @DeleteMapping("/{phone}")
    public void deleteUser(@PathVariable String phone) {
        userService.deleteUserByPhone(phone);
    }
}
