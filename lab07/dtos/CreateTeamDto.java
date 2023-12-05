package dtos;

import models.TeamModel;
import models.UserModel;

import java.util.List;

public class CreateTeamDto {

  private String name;

  private UserModel leader;

  private List<UserModel> members;

  public CreateTeamDto(String name, UserModel leader, List<UserModel> members) {
    this.name = name;
    this.leader = leader;
    this.members = members;
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

  public TeamModel toModel() {
    TeamModel model = new TeamModel();

    model.setName(this.getName());
    model.setLeader(this.getLeader());
    model.setMembers(this.getMembers());

    return model;
  }
}
