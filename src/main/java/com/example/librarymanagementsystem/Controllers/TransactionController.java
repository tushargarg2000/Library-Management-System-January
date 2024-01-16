package com.example.librarymanagementsystem.Controllers;


import com.example.librarymanagementsystem.Repository.TransactionRepository;
import com.example.librarymanagementsystem.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("issueBook")
    public ResponseEntity<String> issueBook(@RequestParam("cardId")Integer cardId,
                                    @RequestParam("bookId")Integer bookId){

            try{
                String result = transactionService.issueBook(cardId,bookId);
                return new ResponseEntity<>(result, HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_GATEWAY);
            }
    }

}
