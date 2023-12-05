package models;

public class ChampionshipAwardModel {
  private AwardModel firstPlaceAward;
  private AwardModel secondPlaceAward;
  private AwardModel thirdPlaceAward;

  public AwardModel getFirstPlaceAward() {
    return firstPlaceAward;
  }

  public void setFirstPlaceAward(AwardModel firstPlaceAward) {
    this.firstPlaceAward = firstPlaceAward;
  }

  public AwardModel getSecondPlaceAward() {
    return secondPlaceAward;
  }

  public void setSecondPlaceAward(AwardModel secondPlaceAward) {
    this.secondPlaceAward = secondPlaceAward;
  }

  public AwardModel getThirdPlaceAward() {
    return thirdPlaceAward;
  }

  public void setThirdPlaceAward(AwardModel thirdPlaceAward) {
    this.thirdPlaceAward = thirdPlaceAward;
  }
}
