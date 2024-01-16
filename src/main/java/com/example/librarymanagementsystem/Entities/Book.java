package com.example.librarymanagementsystem.Entities;

import com.example.librarymanagementsystem.Enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @Column(unique = true)
    private String bookName;

    @Enumerated(value = EnumType.STRING)
    private Genre bookGenre;

    private int noOfPages;

    private int price;

    private Date publishDate;

    private Boolean isAvailable;

    @JoinColumn
    @ManyToOne
    private Author author;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    public List<Transaction> transactionList = new ArrayList<>();

    public Book(String bookName, Genre bookGenre, int noOfPages, int price, Date publishDate) {
        this.bookName = bookName;
        this.bookGenre = bookGenre;
        this.noOfPages = noOfPages;
        this.price = price;
        this.publishDate = publishDate;
    }
}
