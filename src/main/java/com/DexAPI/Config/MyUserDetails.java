/**
  * Functions required to get information from users
**/

package com.DexAPI.Config;

import com.DexAPI.Entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {

    private User user; // define a new user

    public MyUserDetails(User user) {
        this.user = user;
    }

    // returns the authorities granted to a user
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ADMIN"));

        return authorities;
    }

    // returns our current user
    public User getUser()
    {
        return user;
    }

    // returns a user's hashed password
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    // returns the username chosen by a particular user
    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}