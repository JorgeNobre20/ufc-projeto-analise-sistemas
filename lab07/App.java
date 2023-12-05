import dtos.CreateChampionshipDto;
import dtos.CreateTeamDto;
import dtos.CreateUserDto;
import enums.AwardPositionEnum;
import enums.UserProfileEnum;
import models.*;
import services.ChampionshipService;
import services.TeamService;
import services.UserService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) throws Exception {
    UserService userService = new UserService();
    TeamService teamService = new TeamService();
    ChampionshipService championshipService = new ChampionshipService();


    /** Criando usuários **/
    CreateUserDto createUserDto1 = new CreateUserDto("User1", "user1@example.com", UserProfileEnum.PLAYER);
    CreateUserDto createUserDto2 = new CreateUserDto("User2", "user2@example.com", UserProfileEnum.PLAYER);
    CreateUserDto createUserDto3 = new CreateUserDto("User3", "user3@example.com", UserProfileEnum.PLAYER);
    CreateUserDto createUserDto4 = new CreateUserDto("User4", "user4@example.com", UserProfileEnum.PLAYER);
    CreateUserDto createUserDto5 = new CreateUserDto("User5", "user5@example.com", UserProfileEnum.PLAYER);
    CreateUserDto createUserDto6 = new CreateUserDto("User6", "user6@example.com", UserProfileEnum.PLAYER);
    CreateUserDto createUserDto7 = new CreateUserDto("User7", "user7@example.com", UserProfileEnum.PLAYER);
    CreateUserDto createUserDto8 = new CreateUserDto("User8", "user8@example.com", UserProfileEnum.PLAYER);
    CreateUserDto createUserDto9 = new CreateUserDto("User9", "user9@example.com", UserProfileEnum.PLAYER);
    CreateUserDto createUserDto10 = new CreateUserDto("User10", "user10@example.com", UserProfileEnum.MANAGER);

    UserModel user1 = userService.create(createUserDto1);
    UserModel user2 = userService.create(createUserDto2);
    UserModel user3 = userService.create(createUserDto3);
    UserModel user4 = userService.create(createUserDto4);
    UserModel user5 = userService.create(createUserDto5);
    UserModel user6 = userService.create(createUserDto6);
    UserModel user7 = userService.create(createUserDto7);
    UserModel user8 = userService.create(createUserDto8);
    UserModel user9 = userService.create(createUserDto9);
    UserModel user10 = userService.create(createUserDto10);
    /** Finalizando criação de usuários **/



    /** Criando Times **/
    List<UserModel> team1Members = new ArrayList<>();

    team1Members.add(user1);
    team1Members.add(user2);
    team1Members.add(user3);

    CreateTeamDto createTeam1Dto = new CreateTeamDto("Time 1", user1, team1Members);
    teamService.create(createTeam1Dto);


    List<UserModel> team2Members = new ArrayList<>();

    team1Members.add(user4);
    team1Members.add(user5);
    team1Members.add(user6);

    CreateTeamDto createTeam2Dto = new CreateTeamDto("Time 2", user4, team2Members);


    List<UserModel> team3Members = new ArrayList<>();

    team3Members.add(user7);
    team3Members.add(user8);
    team3Members.add(user9);

    CreateTeamDto createTeam3Dto = new CreateTeamDto("Time 3", user7, team3Members);

    TeamModel team1 = teamService.create(createTeam1Dto);
    TeamModel team2 = teamService.create(createTeam2Dto);
    TeamModel team3 = teamService.create(createTeam3Dto);
    /** Finalizando criação de times **/




    /** Criando premiação do campeonato **/
    AwardModel firstPlaceAward = new AwardModel();
    firstPlaceAward.setDescription("Prêmido do 1º Lugar");
    firstPlaceAward.setPosition(AwardPositionEnum.FIRST_PLACE);

    AwardModel secondPlaceAward = new AwardModel();
    secondPlaceAward.setDescription("Prêmido do 2º Lugar");
    secondPlaceAward.setPosition(AwardPositionEnum.SECOND_PLACE);

    AwardModel thirdPlaceAward = new AwardModel();
    thirdPlaceAward.setDescription("Prêmido do 3º Lugar");
    thirdPlaceAward.setPosition(AwardPositionEnum.SECOND_PLACE);

    ChampionshipAwardModel championshipAward = new ChampionshipAwardModel();

    championshipAward.setFirstPlaceAward(firstPlaceAward);
    championshipAward.setSecondPlaceAward(secondPlaceAward);
    championshipAward.setFirstPlaceAward(thirdPlaceAward);
    /** Finalizando criação de premiação do campeonato **/


    /** Criando campeonato **/
    List<TeamModel> championshipTeams = new ArrayList<>();
    championshipTeams.add(team1);
    championshipTeams.add(team2);
    championshipTeams.add(team3);

    CreateChampionshipDto createChampionshipDto = new CreateChampionshipDto();



    createChampionshipDto.setManager(user10);
    createChampionshipDto.setName("Campeonato liga das aventuras");
    createChampionshipDto.setTeams(championshipTeams);
    createChampionshipDto.setMaximumNumberOfTeams(3);
    createChampionshipDto.setStartDateTime(LocalDateTime.of(2023, 12, 1, 0, 0, 0));
    createChampionshipDto.setStartDateTime(LocalDateTime.of(2023, 12, 10, 12, 0, 0));
    createChampionshipDto.setAward(championshipAward);

    ChampionshipModel championship = championshipService.create(createChampionshipDto);
    /** Finalizando do campeonato **/

    /** Sorteando partidas do campeonato **/
    championshipService.sortMatches(championship);
  }
}
