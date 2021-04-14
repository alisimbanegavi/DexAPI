/**
  * Once registered, returns user information for a given user upon login
**/

package com.DexAPI.Service;

import com.DexAPI.Config.MyUserDetails;
import com.DexAPI.Entity.User;
import com.DexAPI.Repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JWTUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @SneakyThrows
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);

    try {
      if (user == null) {
        throw new Exception("Could not find user");
      }
    } catch (Exception ex) {

    }

    return new MyUserDetails(user);
  }
}
