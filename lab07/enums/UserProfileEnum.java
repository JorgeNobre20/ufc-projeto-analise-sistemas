package enums;

public enum UserProfileEnum {
  MANAGER("MANAGER"), PLAYER("PLAYER");

  private final String profile;

  UserProfileEnum(String profile) {
    this.profile = profile;
  }

  public String getProfile() {
    return this.profile;
  }
}
