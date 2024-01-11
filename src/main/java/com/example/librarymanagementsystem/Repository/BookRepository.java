package com.example.librarymanagementsystem.Repository;

import com.example.librarymanagementsystem.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
