package com.lazaraga.ebingo.Controllers;

import com.lazaraga.ebingo.Models.Game;
import com.lazaraga.ebingo.Services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {
    @Autowired
    public GameService gameService;

    @PostMapping("/create")
    public Game createGame(@RequestBody Game g) {
        return gameService.createGame(g);
    }

    @GetMapping("/{gameCode}")
    public ResponseEntity<Game> getGame(@PathVariable String gameCode) {
        Game game = gameService.getGame(gameCode);
        return ResponseEntity.ok(game);
    }

    @PostMapping("/{gameCode}/draw")
    public ResponseEntity<String> drawNumber(@PathVariable String gameCode) {
        int drawn = gameService.drawNumber(gameCode);
        return ResponseEntity.ok("Number " + drawn + " drawn successfully for game " + gameCode);
    }

    @GetMapping
    public List<Game> getAllGames() {
        return gameService.findAllGames();
    }
}
