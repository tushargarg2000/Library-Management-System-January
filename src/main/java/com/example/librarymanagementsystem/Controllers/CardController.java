package com.example.librarymanagementsystem.Controllers;


import com.example.librarymanagementsystem.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("generateACard")
    public String addCard(){

        String result = cardService.getFreshCard();
        return result;

    }
}

