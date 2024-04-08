package com.example.cricbuzz.repository;

import com.example.cricbuzz.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {
    Optional<Player> findByName(String name);
}
