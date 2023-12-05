package dtos;

import enums.UserProfileEnum;
import models.UserModel;


public class CreateUserDto {
  private String name;
  private String email;
  private UserProfileEnum profile;

  public CreateUserDto(String name, String email, UserProfileEnum profile) {
    this.name = name;
    this.email = email;
    this.profile = profile;
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

  public UserModel toModel() {
    UserModel model = new UserModel();
    model.setName(this.getName());
    model.setEmail(this.getEmail());
    model.setProfile(this.getProfile());

    return model;
  }
}
