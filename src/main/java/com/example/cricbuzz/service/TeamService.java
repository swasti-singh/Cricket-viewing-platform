package com.example.cricbuzz.service;

import com.example.cricbuzz.model.Player;
import com.example.cricbuzz.model.Team;
import com.example.cricbuzz.repository.PlayerRepository;
import com.example.cricbuzz.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerRepository playerRepository;

    public Team addPlayer(int teamId,String name,String role){
        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        if (optionalTeam.isPresent()) {
            Team team = optionalTeam.get();
            Optional<Player> optionalPlayer = playerRepository.findByName(name);
            if (optionalPlayer.isPresent()) {
                Player player = optionalPlayer.get();

                List<Player> squad = team.getSquad();
                squad.add(player);
                team.setSquad(squad);
                player.setRole(role);
                playerRepository.save(player);
                return teamRepository.save(team);
            } else {
                throw new IllegalArgumentException("Player not found");
            }
        } else {
            throw new IllegalArgumentException("Team with ID " + teamId + " not found");
        }
    }

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }
    public Team getTeam(String name){
        return teamRepository.findByTeamName(name);
    }
}
