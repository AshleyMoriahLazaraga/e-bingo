package com.lazaraga.ebingo.Services;

import com.lazaraga.ebingo.Models.BingoCard;
import com.lazaraga.ebingo.Models.Cell;
import com.lazaraga.ebingo.Models.Game;
import com.lazaraga.ebingo.Models.Player;
import com.lazaraga.ebingo.Repositories.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GameService {
    @Autowired
    public GameRepo gameRepo;

    public Game createGame(Game g) {
        g.setStatus("Waiting");
        g.setDrawnNumbers(new ArrayList<>());
        g.generateGameCode();
        return gameRepo.save(g);
    }

    public Game getGame(String gameCode) {
        return gameRepo.findByGameCode(gameCode);
    }

    public int drawNumber(String gameCode) {
        Game game = getGame(gameCode);
        List<Integer> drawnNums = game.getDrawnNumbers();

        Random rand = new Random();
        int num;
        do {
            num = rand.nextInt(75) + 1;
        } while(drawnNums.contains(num));

        drawnNums.add(num);

        for(Player player : game.getPlayers()) {
            for(BingoCard bingoCard: player.getBingoCards()) {
                for(Cell cell: bingoCard.getCells()) {
                    if(cell.getNumber() == num) {
                        cell.setStatus("Drawn");
                    }
                }
            }
        }
        gameRepo.save(game);
        return num;
    }

    public List<Game> findAllGames() {
        return gameRepo.findAll();
    }

    public void updateGame(Game game) {
        gameRepo.save(game);
    }
}

