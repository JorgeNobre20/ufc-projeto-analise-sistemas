package models;

import java.util.List;

public class TeamModel {
  private Long id;

  private String name;

  private UserModel leader;

  private List<UserModel> members;

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

  public UserModel getLeader() {
    return leader;
  }

  public void setLeader(UserModel leader) {
    this.leader = leader;
  }

  public List<UserModel> getMembers() {
    return members;
  }

  public void setMembers(List<UserModel> members) {
    this.members = members;
  }
}
