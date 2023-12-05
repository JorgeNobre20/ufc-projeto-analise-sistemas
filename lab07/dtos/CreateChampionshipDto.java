package dtos;

import models.ChampionshipAwardModel;
import models.ChampionshipModel;
import models.TeamModel;
import models.UserModel;

import java.time.LocalDateTime;
import java.util.List;

public class CreateChampionshipDto {
  private String name;

  private LocalDateTime startDateTime;

  private LocalDateTime endDateTime;

  private UserModel manager;

  private List<TeamModel> teams;

  private int maximumNumberOfTeams;

  private ChampionshipAwardModel award;


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDateTime getStartDateTime() {
    return startDateTime;
  }

  public void setStartDateTime(LocalDateTime startDateTime) {
    this.startDateTime = startDateTime;
  }

  public LocalDateTime getEndDateTime() {
    return endDateTime;
  }

  public void setEndDateTime(LocalDateTime endDateTime) {
    this.endDateTime = endDateTime;
  }

  public UserModel getManager() {
    return manager;
  }

  public void setManager(UserModel manager) {
    this.manager = manager;
  }

  public List<TeamModel> getTeams() {
    return teams;
  }

  public void setTeams(List<TeamModel> teams) {
    this.teams = teams;
  }

  public int getMaximumNumberOfTeams() {
    return maximumNumberOfTeams;
  }

  public void setMaximumNumberOfTeams(int maximumNumberOfTeams) {
    this.maximumNumberOfTeams = maximumNumberOfTeams;
  }

  public ChampionshipAwardModel getAward() {
    return award;
  }

  public void setAward(ChampionshipAwardModel award) {
    this.award = award;
  }

  public ChampionshipModel toChampionshipModel() {
    ChampionshipModel championshipModel = new ChampionshipModel();
    championshipModel.setName(this.getName());
    championshipModel.setStartDateTime(this.getStartDateTime());
    championshipModel.setEndDateTime(this.getEndDateTime());
    championshipModel.setManager(this.getManager());
    championshipModel.setTeams(this.getTeams());
    championshipModel.setMaximumNumberOfTeams(this.getMaximumNumberOfTeams());

    if (championshipModel.getTeams() == null) {
      championshipModel.setTeams(List.of());
    }

    return championshipModel;
  }
}
