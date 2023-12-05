package services;

import dtos.CreateTeamDto;
import models.TeamModel;
import repositories.TeamRepository;

import java.util.List;
import java.util.Objects;

public class TeamService {
  private TeamRepository repository;

  public TeamModel create(CreateTeamDto input) {
    return this.repository.create(input);
  }

  public List<TeamModel> findAll() {
    return this.repository.findAll();
  }

  public TeamModel getById(Long id) throws Exception {
    TeamModel entity = this.repository.getById(id);

    if (Objects.isNull(entity)) {
      throw new Exception("Campeonato não encontrado");
    }

    return entity;
  }

  public void update(TeamModel input) throws Exception {
    this.getById(input.getId());
    this.repository.update(input);
  }

  public void delete(TeamModel input) {
    this.repository.delete(input);
  }
}
