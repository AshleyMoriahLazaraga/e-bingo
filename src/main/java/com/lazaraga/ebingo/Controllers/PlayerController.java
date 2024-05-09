package com.lazaraga.ebingo.Controllers;

import com.lazaraga.ebingo.Models.Player;
import com.lazaraga.ebingo.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    @Autowired
    public PlayerService playerService;

    @PostMapping("/join/{gameCode}")
    public ResponseEntity<Player> joinGame(@RequestParam String gameCode) {
        Player player = playerService.joinGame(gameCode);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.findAllPlayers();
    }
}
