package com.example.librarymanagementsystem.Services;

import com.example.librarymanagementsystem.Entities.Book;
import com.example.librarymanagementsystem.Entities.LibraryCard;
import com.example.librarymanagementsystem.Entities.Transaction;
import com.example.librarymanagementsystem.Enums.TransactionStatus;
import com.example.librarymanagementsystem.Enums.TransactionType;
import com.example.librarymanagementsystem.Exceptions.BookNotAvailableException;
import com.example.librarymanagementsystem.Exceptions.BookNotFoundException;
import com.example.librarymanagementsystem.Exceptions.CardNotFoundException;
import com.example.librarymanagementsystem.Exceptions.MaxLimitReachedException;
import com.example.librarymanagementsystem.Repository.BookRepository;
import com.example.librarymanagementsystem.Repository.CardRepository;
import com.example.librarymanagementsystem.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CardRepository cardRepository;

    public String issueBook(Integer cardId,Integer bookId)throws Exception{

        Transaction transaction = new Transaction();
        transaction.setTransactionType(TransactionType.ISSUED);
        transaction.setTransactionStatus(TransactionStatus.ONGOING);

        //1. Get the book and card Entity from DB

        Optional<Book> bookOptional = bookRepository.findById(bookId);

        if(bookOptional.isEmpty()){
            throw new BookNotFoundException("BookId entered is invalid");
        }

        Optional<LibraryCard> optionalLibraryCard = cardRepository.findById(cardId);

        if(optionalLibraryCard.isEmpty()){
            throw new CardNotFoundException("Card Id Entered is Invalid");
        }

        Book book = bookOptional.get();
        LibraryCard card = optionalLibraryCard.get();
        //2. validate book and card Entity variables

        //Check for availability
        if(book.getIsAvailable()==Boolean.FALSE){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transaction = transactionRepository.save(transaction);
            throw new BookNotAvailableException("Book with the bookId is not available. TransactionId "+transaction.getTransactionId());
        }
        //Check for max book issued
        if(card.getNoOfBooksIssued()>=LibraryCard.MAX_NO_OF_ALLOWED_BOOKS){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transaction = transactionRepository.save(transaction);
            throw new MaxLimitReachedException("You have reached the max limit of issed books" +
                    "please return a book in order to issue new " +
                    "Transaction Id"+transaction.getTransactionId());
        }


        //If you have reached that means all validations are OK

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);

        //3. update the card and the book status
        book.setIsAvailable(Boolean.FALSE);
        card.setNoOfBooksIssued(card.getNoOfBooksIssued()+1);

        //Save the child as it will cascade to both of the Parents
        transaction = transactionRepository.save(transaction);

        return "The transaction with Id"+transaction.getTransactionId()+" has been saved to the DB";
    }


    //Try return book API

    //give you some hifi APIs to practice

    //Email Integration + swagger + DB related queries

}
