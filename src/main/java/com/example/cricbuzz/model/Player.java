package com.example.cricbuzz.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="player_id")
    private int playerId;
    @Column(name="name")
    private String name;
    @Column(name="matches_played")
    private int matchesPlayed;
    @Column(name="runs")
    private long runs;
    @Column(name="average")
    private long average;
    @Column(name="strike_rate")
    private long strikeRate;
    @Column(name="role")
    private String role;

}
