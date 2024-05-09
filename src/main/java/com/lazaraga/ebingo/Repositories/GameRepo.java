package com.lazaraga.ebingo.Repositories;

import com.lazaraga.ebingo.Models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepo extends JpaRepository<Game, Long> {
    Game findByGameCode(String gameCode);
}
