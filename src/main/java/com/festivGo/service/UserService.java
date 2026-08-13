package com.festivGo.service;

import com.festivGo.entity.User;
import com.festivGo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Register a new user (save details in DB).
    public User createuser(User user) {
        // check if user already present
        if(userRepository.existsByPhone(user.getPhone())) {
            throw new IllegalArgumentException("user already present: " + user.getPhone());
        }
      return  userRepository.save(user);
    }

    //Find user by phone/email.
    public User getUserByPhone(String phone) {
        User user = userRepository.findByPhone(phone);
        if(user == null) {
            throw new IllegalArgumentException("in getUser method - No user is found by phone: " + phone);
        }
       return user;
    }

    //Update user profile.
    public User updateUser(String phone, User user) {
        //get the user first
        User updateuser  = userRepository.findByPhone(phone);
        // check
        if(updateuser == null) {
            throw new IllegalArgumentException(" in update method- No user is found with phone: " + phone);
        }
        updateuser.setName(user.getName());
        updateuser.setRole(user.getRole());
        updateuser.setPhone(user.getPhone());
        return userRepository.save(updateuser);
    }
    //Delete user if needed.
    public void deleteUserByPhone(String phone) {
      User existinguser =   userRepository.findByPhone(phone);
      if(existinguser == null) {
          throw new IllegalArgumentException(" in delete method- No user is found with phone: " + phone);
      }
        userRepository.delete(existinguser);
    }
}
