    package com.festivGo.service;

    import com.festivGo.dto.UserRequest;
    import com.festivGo.entity.User;
    import com.festivGo.exceptions.custom_exception.UserAlreadyExistsException;
    import com.festivGo.exceptions.custom_exception.UserNotFoundException;
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
                throw new UserAlreadyExistsException(user.getPhone());
            }
          return  userRepository.save(user);
        }

        //Find user by phone/email.
        public User getUserByPhone(String phone) {
            User user = userRepository.findByPhone(phone);
            if(user == null) {
                throw new UserNotFoundException(phone);
            }
           return user;
        }

        //Update user profile.
        public User updateUser(String phone, UserRequest userRequest) {
            //get the user first
            User updateuser  = userRepository.findByPhone(phone);
            // check
            if(updateuser == null) {
                throw new UserNotFoundException(phone);
            }
            updateuser.setName(userRequest.getName());
            updateuser.setRole(userRequest.getRole());
            updateuser.setPhone(userRequest.getPhone());
            return userRepository.save(updateuser);
        }
        //Delete user if needed.
        public void deleteUserByPhone(String phone) {
          User existinguser =   userRepository.findByPhone(phone);
          if(existinguser == null) {
              throw new UserNotFoundException(phone);
          }
            userRepository.delete(existinguser);
        }
    }
