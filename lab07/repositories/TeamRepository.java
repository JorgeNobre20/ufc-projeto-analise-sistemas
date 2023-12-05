package repositories;

import dtos.CreateTeamDto;
import models.TeamModel;

import java.util.ArrayList;
import java.util.List;

public class TeamRepository {
  private Long currentId = 1L;
  private final List<TeamModel> data;

  public TeamRepository(){
    this.data = new ArrayList<>();
  }

  public TeamModel create(CreateTeamDto input){
    TeamModel model = input.toModel();
    model.setId(this.currentId);

    currentId++;

    this.data.add(model);

    return model;
  }

  public List<TeamModel> findAll(){
    return this.data;
  }

  public TeamModel getById(Long id){
    TeamModel record = null;

    for (TeamModel storedRecord: this.data) {
      if(storedRecord.getId().equals(id)){
        record = storedRecord;
        break;
      }
    }

    return record;
  }

  public void update(TeamModel input){
    for (TeamModel storedRecord: this.data) {
      if(storedRecord.getId().equals(input.getId())){
        this.data.remove(storedRecord);
        break;
      }
    }

    this.data.add(input);
  }

  public void delete(TeamModel input){
    this.data.remove(input);
  }
}
