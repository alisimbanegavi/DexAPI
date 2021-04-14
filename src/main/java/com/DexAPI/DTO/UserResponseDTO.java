package com.DexAPI.DTO;

import com.DexAPI.Entity.User;

public class UserResponseDTO {
  private User user;

  public void setUser(User user) {
    this.user = user;

  }

  public User getUser() {
    return user;
  }
}
