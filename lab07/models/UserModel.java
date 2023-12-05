package models;

import enums.UserProfileEnum;

public class UserModel {
  private Long id;
  private String name;
  private String email;
  private UserProfileEnum profile;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserProfileEnum getProfile() {
    return profile;
  }

  public void setProfile(UserProfileEnum profile) {
    this.profile = profile;
  }
}
