package com.example.librarymanagementsystem.Services;

import com.example.librarymanagementsystem.Entities.Author;
import com.example.librarymanagementsystem.Entities.Book;
import com.example.librarymanagementsystem.Repository.AuthorRepository;
import com.example.librarymanagementsystem.RequestDtos.AddBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private AuthorRepository authorRepository;

    public String addBook(AddBookRequest bookRequest){


        //Logical steps : Tell

        //1 Get the author Entity from the authorId
        Author author = authorRepository.findById(bookRequest.getAuthorId()).get();


        //2. Create the Book Entity from bookRequest
        Book newBook = new Book(bookRequest.getBookName(),bookRequest.getBookGenre(),
                bookRequest.getNoOfPages(), bookRequest.getPrice(), bookRequest.getPublishDate());

        author.setNoOfBooksWritten(author.getNoOfBooksWritten()+1);

        //3. Set the foreign key variable/ mapping variables

            //3.1 Adding for the book the Author Entity
            newBook.setAuthor(author); //unidirectional mapping


            //3.2 for the Author add the book in the bookList
            author.getBookList().add(newBook); //bidirectional mapping


        //4. Save the parent class
        authorRepository.save(author);

        return "Book has been saved to the DB";
    }

}
