package com.lazaraga.ebingo.Repositories;

import com.lazaraga.ebingo.Models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepo extends JpaRepository<Player, Long> {
}
