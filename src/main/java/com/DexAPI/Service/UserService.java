/**
  * Checks the user repository before creating new users with the same name
**/

package com.DexAPI.Service;

import com.DexAPI.DTO.SignUpRequestDTO;
import com.DexAPI.Entity.User;
import com.DexAPI.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public User registerUser(SignUpRequestDTO signUpDTO) throws Exception {
    User user = userRepository.findByUsername(signUpDTO.getUsername());

    if (user != null) {
      throw new Exception("Username already in use");
    }

    BCryptPasswordEncoder encode = new BCryptPasswordEncoder(); // Strength set as 12

    User newUser = new User();
    newUser.setUserName(signUpDTO.getUsername());
    newUser.setPassword(encode.encode(signUpDTO.getPassword()));

    return userRepository.save(newUser);

  }
}
