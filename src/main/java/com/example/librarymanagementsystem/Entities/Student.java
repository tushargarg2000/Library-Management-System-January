package com.example.librarymanagementsystem.Entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    private String name;

    private String branch;

    private double cgpa;

    private String phoneNo;

    /*
        mappedBy contains the value of variable Name : foreign key variable name
        in the child table
     */
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private LibraryCard libraryCard;
}
