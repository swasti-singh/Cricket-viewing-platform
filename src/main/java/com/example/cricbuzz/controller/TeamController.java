package com.example.cricbuzz.controller;

import com.example.cricbuzz.model.Player;
import com.example.cricbuzz.model.Team;
import com.example.cricbuzz.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    @Autowired
    private TeamService teamService;
    @PostMapping("/{team_id}/squad")
    public Team addSquad(@PathVariable int team_id, @RequestBody Player payload){
        String name= payload.getName();
        String role=payload.getRole();
        return teamService.addPlayer(team_id,name,role);
    }

    @GetMapping
    public List<Team> showTeam(){
        return teamService.getTeams();
    }
}
