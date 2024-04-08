package com.example.cricbuzz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name="`match`")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="match_id")
    private int matchId;
    @Column(name="team_1")
    private String team_1;

    public String getTeam_1() {
        return team_1;
    }

    public void setTeam_1(String team_1) {
        this.team_1 = team_1;
    }

    public String getTeam_2() {
        return team_2;
    }

    public void setTeam_2(String team_2) {
        this.team_2 = team_2;
    }

    @Column(name="team_2")
    private String team_2;
    @Column(name="date")
    private String date;
    @Column(name="venue")
    private String venue;
    @Column(name="status")
    private String status;

    @ManyToOne
    @JoinColumn(name="team1")
    private Team Team1;

    @ManyToOne
    @JoinColumn(name="team2")
    private Team Team2;


}
