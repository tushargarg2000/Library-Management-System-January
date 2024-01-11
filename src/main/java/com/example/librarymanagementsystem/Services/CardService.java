package com.example.librarymanagementsystem.Services;


import com.example.librarymanagementsystem.Entities.LibraryCard;
import com.example.librarymanagementsystem.Enums.CardStatus;
import com.example.librarymanagementsystem.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;


    public String getFreshCard(){

        LibraryCard newCard = new LibraryCard();
        newCard.setCardStatus(CardStatus.NEW);
        newCard.setNoOfBooksIssued(0);

       LibraryCard savedCard =  cardRepository.save(newCard);

       return "New Card with Card No "+savedCard.getCardId()+" has been generated";


    }

}
