package com.example.cricbuzz.controller;

import com.example.cricbuzz.model.Match;
import com.example.cricbuzz.model.Team;
import com.example.cricbuzz.service.MatchService;
import com.example.cricbuzz.service.TeamService;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;
    @Autowired
    private TeamService teamService;
    @GetMapping
    public Map<String,List<Match>> getMatches(){
        Map mp= new HashMap<>();
        mp.put("matches",matchService.allMatches());
        return mp;
    }

    @GetMapping("/{match_id}")
    public Optional<Match> getMatch(@PathVariable int match_id){
        return matchService.oneMatch(match_id);
    }

    @PostMapping
    public ResponseEntity<Object> addMatch(@RequestBody Match payload){
        String team1=payload.getTeam_1();
        String team2=payload.getTeam_2();
        int matchId=payload.getMatchId();
        Team team_1=teamService.getTeam(team1);
        Team team_2=teamService.getTeam(team2);
        String date= payload.getDate();
        String venue=payload.getVenue();
        String status=payload.getStatus();
        Match m=new Match();
        m.setDate(date);
        m.setVenue(venue);
        m.setTeam_1(team1);
        m.setTeam_2(team2);
        m.setStatus(status);
        m.setTeam1(team_1);
        m.setTeam2(team_2);

        Match match= matchService.addMatch(m);
        String jsonResponse="Match added successfully";
        return ResponseEntity.ok(match);

    }
}
