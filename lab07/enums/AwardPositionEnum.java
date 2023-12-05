package enums;

public enum AwardPositionEnum {
  FIRST_PLACE(1), SECOND_PLACE(2), THIRD_PLACE(3);

  private final int placePosition;

  AwardPositionEnum(int place) {
    this.placePosition = place;
  }

  public int getPlacePosition() {
    return this.placePosition;
  }
}
