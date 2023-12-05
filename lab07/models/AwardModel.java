package models;

import enums.AwardPositionEnum;

public class AwardModel {
  private AwardPositionEnum position;
  private String description;

  public AwardPositionEnum getPosition() {
    return position;
  }

  public void setPosition(AwardPositionEnum position) {
    this.position = position;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
