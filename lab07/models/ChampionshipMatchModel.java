package models;

import java.time.LocalDateTime;

public class ChampionshipMatchModel {
  private int order;
  private TeamModel teamOne;
  private TeamModel teamTwo;

  private LocalDateTime dateTime;

  public ChampionshipMatchModel(int order, TeamModel teamOne, TeamModel teamTwo, LocalDateTime dateTime) {
    this.order = order;
    this.teamOne = teamOne;
    this.teamTwo = teamTwo;
    this.dateTime = dateTime;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public TeamModel getTeamOne() {
    return teamOne;
  }

  public void setTeamOne(TeamModel teamOne) {
    this.teamOne = teamOne;
  }

  public TeamModel getTeamTwo() {
    return teamTwo;
  }

  public void setTeamTwo(TeamModel teamTwo) {
    this.teamTwo = teamTwo;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }
}
