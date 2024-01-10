package com.example.librarymanagementsystem.Entities;

import com.example.librarymanagementsystem.Enums.CardStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
