package repositories;

import dtos.CreateUserDto;
import models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
  private Long currentId = 1L;
  private final List<UserModel> data;

  public UserRepository(){
    this.data = new ArrayList<>();
  }

  public UserModel create(CreateUserDto input){
    UserModel model = input.toModel();
    model.setId(this.currentId);

    currentId++;

    this.data.add(model);

    return model;
  }

  public List<UserModel> findAll(){
    return this.data;
  }

  public UserModel getById(Long id){
    UserModel record = null;

    for (UserModel user: this.data) {
      if(user.getId().equals(id)){
        record = user;
        break;
      }
    }

    return record;
  }

  public void update(UserModel input){
    for (UserModel user: this.data) {
      if(user.getId().equals(input.getId())){
        this.data.remove(user);
        break;
      }
    }

    this.data.add(input);
  }

  public void delete(UserModel input){
    this.data.remove(input);
  }
}
