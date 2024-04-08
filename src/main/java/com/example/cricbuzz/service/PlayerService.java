package com.example.cricbuzz.service;

import com.example.cricbuzz.model.Player;
import com.example.cricbuzz.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public Optional<Player> getInformation(int id){
        return playerRepository.findById(id);
    }

}
