package com.lazaraga.ebingo.Services;

import com.lazaraga.ebingo.Models.BingoCard;
import com.lazaraga.ebingo.Models.Cell;
import com.lazaraga.ebingo.Models.Player;
import com.lazaraga.ebingo.Repositories.BingoCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BingoCardService {
    @Autowired
    public BingoCardRepo bingoCardRepo;

    @Autowired
    private PlayerService playerService;

    public BingoCard createBingoCard(Long playerId) {
        Player player = playerService.getPlayer(playerId);
        if(player == null) {
            throw new RuntimeException("Player Id: " + playerId + " is not found.");
        }
        BingoCard bingoCard =  new BingoCard();
        bingoCard.setPlayer(player);

        List<Cell> cells = generateCells();
        for(Cell cell: cells) {
            cell.setBingoCard(bingoCard);
            cell.setStatus("Not Drawn");
        }
        bingoCard.setCells(cells);

        return bingoCardRepo.save(bingoCard);
    }

    private List<Cell> generateCells() {
        List<Cell> cells = new ArrayList<>();
        Random rand = new Random();

        int min, max;
        for(int i = 0; i < 5; i++) {
            switch (i) {
                case 0:
                    min = 1;
                    max = 15;
                    break;
                case 1:
                    min =16;
                    max = 30;
                    break;
                case 2:
                    min = 31;
                    max = 45;
                    break;
                case 3:
                    min = 46;
                    max = 60;
                    break;
                case 4:
                    min = 61;
                    max = 75;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value at " + i);
            }

            List<Integer> columnNum = new ArrayList<>();
            while (columnNum.size() < 5) {
                int num = rand.nextInt(max - min + 1) + min;
                if(!columnNum.contains(num)) {
                    columnNum.add(num);
                }
            }

            Collections.shuffle(columnNum);

            for(int a = 0; a < 5; a++) {
                Cell cell = new Cell();
                cell.setNumber(columnNum.get(a));
                cell.setStatus("Not Drawn");
                cells.add(cell);
            }
        }
        return cells;
    }
}
