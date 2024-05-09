package com.lazaraga.ebingo.Controllers;

import com.lazaraga.ebingo.Models.BingoCard;
import com.lazaraga.ebingo.Services.BingoCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bingocards")
public class BingoCardController {
    @Autowired
    public BingoCardService bingoCardService;

    @PostMapping("/create")
    public ResponseEntity<BingoCard> createBgCard(@RequestParam Long playerId) {
        BingoCard bingoCard = bingoCardService.createBingoCard(playerId);
        return new ResponseEntity<>(bingoCard, HttpStatus.CREATED);
    }
}
