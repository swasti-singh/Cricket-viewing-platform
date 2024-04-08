package com.example.cricbuzz.controller;

import com.example.cricbuzz.model.Player;
import com.example.cricbuzz.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    @GetMapping("/{player_id}/stats")
    public Optional<Player> getStatistics(@PathVariable int player_id){
       return playerService.getInformation(player_id);
    }
}
