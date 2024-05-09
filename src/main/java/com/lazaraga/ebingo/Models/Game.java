package com.lazaraga.ebingo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long gameId;

    @Column(unique = true)
    private String gameCode;

    private String status;

    @OneToMany(mappedBy = "game")
    private List<Player> players;

    @ElementCollection
    private List<Integer> drawnNumbers;

//    public List<Long> getPlayerIds() {
//        List<Long> playerIds = new ArrayList<>();
//        for (Player player : players) {
//            playerIds.add(player.getPlayerId());
//        }
//        return playerIds;
   // }

    //getters and setters


    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getGameCode() {
        return gameCode;
    }
    public void generateGameCode() {
        this.gameCode = UUID.randomUUID().toString().substring(0, 8);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Integer> getDrawnNumbers() {
        return drawnNumbers;
    }

    public void setDrawnNumbers(List<Integer> drawnNumbers) {
        this.drawnNumbers = drawnNumbers;
    }
}
