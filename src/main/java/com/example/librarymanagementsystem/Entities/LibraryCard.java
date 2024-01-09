package com.example.librarymanagementsystem.Entities;

import com.example.librarymanagementsystem.Enums.CardStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    private CardStatus cardStatus;

    private int noOfBooksIssued;


}
