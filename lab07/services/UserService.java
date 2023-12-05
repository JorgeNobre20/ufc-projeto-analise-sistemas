package services;

import dtos.CreateUserDto;
import models.UserModel;
import repositories.UserRepository;

import java.util.List;
import java.util.Objects;

public class UserService {
  private UserRepository repository;

  public UserModel create(CreateUserDto input) {
    return this.repository.create(input);
  }

  public List<UserModel> findAll() {
    return this.repository.findAll();
  }

  public UserModel getById(Long id) throws Exception {
    UserModel entity = this.repository.getById(id);

    if (Objects.isNull(entity)) {
      throw new Exception("Usuário não encontrado");
    }

    return entity;
  }

  public void update(UserModel input) throws Exception {
    this.getById(input.getId());
    this.repository.update(input);
  }

  public void delete(UserModel input) {
    this.repository.delete(input);
  }
}
