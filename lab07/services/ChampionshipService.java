package services;

import dtos.CreateChampionshipDto;
import enums.UserProfileEnum;
import models.ChampionshipMatchModel;
import models.ChampionshipModel;
import models.TeamModel;
import repositories.ChampionshipRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ChampionshipService {
  private ChampionshipRepository repository;

  public ChampionshipModel create(CreateChampionshipDto input) throws Exception {
    if(!input.getManager().getProfile().equals(UserProfileEnum.MANAGER)){
      throw new Exception("O Organizador do campeonato precisa ter um perfil de organizador de campeonato");
    }

    if(input.getStartDateTime().isAfter(input.getEndDateTime())){
      throw new Exception("Período do campeonato inválido");
    }

    if(input.getMaximumNumberOfTeams() < input.getTeams().size()){
      throw new Exception("O número de times superou o máximo permitido");
    }

    if (input.getTeams().size() < 0.75 * input.getMaximumNumberOfTeams()) {
      throw new Exception("O número de times inscritos é menor que 75% do máximo permitido.");
    }

    return this.repository.create(input);
  }

  public List<ChampionshipModel> findAll() {
    return this.repository.findAll();
  }

  public ChampionshipModel getById(Long id) throws Exception {
    ChampionshipModel entity = this.repository.getById(id);

    if (Objects.isNull(entity)) {
      throw new Exception("Campeonato não encontrado");
    }

    return entity;
  }

  public void update(ChampionshipModel input) throws Exception {
    this.getById(input.getId());
    this.repository.update(input);
  }

  public void delete(ChampionshipModel input) {
    this.repository.delete(input);
  }

  public void sortMatches(ChampionshipModel input){
      if (input.getTeams() == null || input.getTeams().size() < 2) {
        throw new IllegalStateException("Não há times suficientes para formar partidas.");
      }

      if (input.getStartDateTime() == null || input.getEndDateTime() == null || input.getStartDateTime().isAfter(input.getEndDateTime())) {
        throw new IllegalStateException("Datas de início e/ou fim do campeonato inválidas.");
      }

      Duration duration = Duration.between(input.getStartDateTime(), input.getEndDateTime());

      List<TeamModel> shuffledTeams = new ArrayList<>(input.getTeams());
      Collections.shuffle(shuffledTeams);

      if (shuffledTeams.size() % 2 != 0) {
        shuffledTeams.remove(0);
      }

      List<ChampionshipMatchModel> generatedMatches = new ArrayList<>();
      LocalDateTime currentDateTime = input.getStartDateTime();

      int matchOrder = 1;

      for (int i = 0; i < shuffledTeams.size(); i += 2) {
        TeamModel team1 = shuffledTeams.get(i);
        TeamModel team2 = shuffledTeams.get(i + 1);

        matchOrder++;

        ChampionshipMatchModel match = new ChampionshipMatchModel(matchOrder, team1, team2, currentDateTime);
        generatedMatches.add(match);

        currentDateTime = currentDateTime.plus(duration.dividedBy(shuffledTeams.size() / 2));
      }

      input.setMatches(generatedMatches);
  }
}
