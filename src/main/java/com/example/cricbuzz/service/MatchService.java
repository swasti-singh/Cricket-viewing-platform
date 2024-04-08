package com.example.cricbuzz.service;

import com.example.cricbuzz.model.Match;
import com.example.cricbuzz.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;

    public List<Match> allMatches(){
        return matchRepository.findAll();
    }
    public Optional<Match> oneMatch(int id){
        return matchRepository.findById(id);
    }

    public Match addMatch(Match match){
        return matchRepository.save(match);
    }

}
