/**
  * User authentication, a post request gets the username and Password
  * if credentials are validated, we use JWTTokenUtil and create a token
**/

package com.DexAPI.Controller;

import com.DexAPI.Config.JWTTokenUtil;
import com.DexAPI.Config.MyUserDetails;
import com.DexAPI.DTO.SignInRequestDTO;
import com.DexAPI.DTO.SignInResponseDTO;
import com.DexAPI.DTO.SignUpRequestDTO;
import com.DexAPI.DTO.UserResponseDTO;
import com.DexAPI.Entity.User;
import com.DexAPI.Service.JWTUserDetailsService;
import com.DexAPI.Service.UserService;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
public class AuthController {
  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JWTTokenUtil jwtTokenUtil;

  @Autowired
  private UserService userService;

  @Autowired
  private JWTUserDetailsService userDetailsService;

  // links login route to a post request, creates token if valid request
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody SignInRequestDTO authenticationRequest)
      throws Exception {

    System.out.println(authenticationRequest.getUsername());
    System.out.println(authenticationRequest.getPassword());

    // calls authenticate method on new request to log in
    authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

    final MyUserDetails userDetails = (MyUserDetails) userDetailsService
        .loadUserByUsername(authenticationRequest.getUsername());

    final String token = jwtTokenUtil.generateToken(userDetails); // generates a token

    UserResponseDTO userResponseDTO = new UserResponseDTO();
    userResponseDTO.setUser(userDetails.getUser());
    return ResponseEntity.ok(new SignInResponseDTO(token, userResponseDTO));
  }

  // links register route to a post request, if the user doesn't exist, creates a
  // new user
  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequestDTO signUpRequestDTO) throws Exception {

    try {
      User user = userService.registerUser(signUpRequestDTO);

      UserResponseDTO userResponseDTO = new UserResponseDTO();
      userResponseDTO.setUser(user);
      return ResponseEntity.ok(userResponseDTO);
    } catch (Exception err) {
      if (err.getMessage().equals("Username already in use")) {
        return ResponseEntity.ok("Username already in use");
      }
    }
    return ResponseEntity.ok("Internal Server Error");
  }

  private void authenticate(String username, String password) throws Exception { // checks for user status when logging
                                                                                 // in
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    } catch (SignatureException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
      throw new BadCredentialsException("INVALID_CREDENTIALS", ex);
    } catch (DisabledException e) {
      throw new Exception("USER_DISABLED", e);
    } catch (BadCredentialsException e) {
      throw new Exception("INVALID_CREDENTIALS", e);
    }
  }
}
