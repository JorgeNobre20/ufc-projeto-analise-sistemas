package models;

import enums.ChampionshipStatusEnum;

import java.time.LocalDateTime;
import java.util.List;

public class ChampionshipModel {
  private Long id;

  private String name;

  private LocalDateTime startDateTime;

  private LocalDateTime endDateTime;

  private ChampionshipStatusEnum status;

  private UserModel manager;

  private List<TeamModel> teams;

  private List<ChampionshipMatchModel> matches;

  private ChampionshipAwardModel award;

  private int maximumNumberOfTeams;

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

  public ChampionshipStatusEnum getStatus() {
    return status;
  }

  public void setStatus(ChampionshipStatusEnum status) {
    this.status = status;
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

  public List<ChampionshipMatchModel> getMatches() {
    return matches;
  }

  public void setMatches(List<ChampionshipMatchModel> matches) {
    this.matches = matches;
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
}
