package enums;

public enum ChampionshipStatusEnum {
  WAITING_SUBSCRIPTIONS("WAITING_SUBSCRIPTIONS"), STARTED("STARTED"), FINISHED("FINISHED");

  private final String status;

  ChampionshipStatusEnum(String status) {
    this.status = status;
  }

  public String getStatus() {
    return this.status;
  }
}
