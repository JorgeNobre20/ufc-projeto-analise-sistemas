package repositories;

import dtos.CreateChampionshipDto;
import enums.ChampionshipStatusEnum;
import models.ChampionshipModel;

import java.util.ArrayList;
import java.util.List;

public class ChampionshipRepository {
  private Long currentId = 1L;

  private final List<ChampionshipModel> data;

  public ChampionshipRepository(){
    this.data = new ArrayList<>();
  }

  public ChampionshipModel create(CreateChampionshipDto input){
    ChampionshipModel model = input.toChampionshipModel();
    model.setId(this.currentId);
    model.setStatus(ChampionshipStatusEnum.WAITING_SUBSCRIPTIONS);

    this.currentId++;

    this.data.add(model);

    return model;
  }

  public List<ChampionshipModel> findAll(){
    return this.data;
  }

  public ChampionshipModel getById(Long id){
    ChampionshipModel record = null;

    for (ChampionshipModel storedRecord: this.data) {
      if(storedRecord.getId().equals(id)){
        record = storedRecord;
        break;
      }
    }

    return record;
  }

  public void update(ChampionshipModel input){
    for (ChampionshipModel storedRecord: this.data) {
      if(storedRecord.getId().equals(input.getId())){
        this.data.remove(storedRecord);
        break;
      }
    }

    this.data.add(input);
  }

  public void delete(ChampionshipModel input){
    this.data.remove(input);
  }
}
