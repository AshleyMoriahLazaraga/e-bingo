package com.lazaraga.ebingo.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bingocard")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "bgCardId")
public class BingoCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long bgCardId;

    @ManyToOne
    @JoinColumn(name = "playerId", nullable = false)
    public Player player;

    @OneToMany(mappedBy = "bingoCard", cascade = CascadeType.ALL)
    public List<Cell> cells;

    //getters and setters

    public Long getBgCardId() {
        return bgCardId;
    }

    public void setBgCardId(Long bgCardId) {
        this.bgCardId = bgCardId;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }
}
