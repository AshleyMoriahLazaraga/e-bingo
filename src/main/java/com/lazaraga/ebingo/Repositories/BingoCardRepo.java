package com.lazaraga.ebingo.Repositories;

import com.lazaraga.ebingo.Models.BingoCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BingoCardRepo extends JpaRepository<BingoCard, Long> {
}
