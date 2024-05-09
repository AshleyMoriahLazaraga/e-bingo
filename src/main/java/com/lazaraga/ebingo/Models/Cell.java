package com.lazaraga.ebingo.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cell")
public class Cell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long cellId;

    public int number;
    public String status;

    @ManyToOne
    @JoinColumn(name = "bingo_card_id", nullable = false)
    public BingoCard bingoCard;


    //getters and setters
    public Long getCellId() {
        return cellId;
    }

    public void setCellId(Long cellId) {
        this.cellId = cellId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BingoCard getBgCardId() {
        return bingoCard;
    }

    public void setBgCardId(BingoCard bingoCard) {
        this.bingoCard = bingoCard;
    }
}
