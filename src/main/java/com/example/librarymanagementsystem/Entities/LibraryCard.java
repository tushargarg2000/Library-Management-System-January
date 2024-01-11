package com.example.librarymanagementsystem.Entities;

import com.example.librarymanagementsystem.Enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "library_card")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardId;


    //This is an annotation for mysql to understand custom datatype
    // and store it as a string format inside the DB.
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    private int noOfBooksIssued;

    //Library card should have the foreign key column
    //bcz this is the child class
    @JoinColumn
    @OneToOne
    private Student student;

}
