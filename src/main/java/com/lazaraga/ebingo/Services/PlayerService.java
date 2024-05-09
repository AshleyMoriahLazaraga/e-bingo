package com.lazaraga.ebingo.Services;

import com.lazaraga.ebingo.Models.Game;
import com.lazaraga.ebingo.Models.Player;
import com.lazaraga.ebingo.Repositories.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    public PlayerRepo playerRepo;

    @Autowired
    private GameService gameService;

    public Player joinGame(String gameCode) {
        Game game = gameService.getGame(gameCode);

        if(game == null) {
            throw new RuntimeException("Game Code: " + gameCode + " not found.");
        }

        if(!game.getStatus().equals("Waiting") || game.getPlayers().size() >= 8) {
            throw new RuntimeException("Cannot join game: Either max players or game has started");
        }

        Player player = new Player();
        player.setGame(game);
        Player saved = playerRepo.save(player);

        if(game.getPlayers().size() == 8) {
            game.setStatus("Started");
            gameService.updateGame(game);
        }

        return saved;
    }

    public Player getPlayer(Long playerId) {
        return playerRepo.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player " + playerId + " not found!"));
    }

    public List<Player> findAllPlayers() {
        return playerRepo.findAll();
    }
}
