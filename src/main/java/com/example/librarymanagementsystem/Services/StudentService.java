package com.example.librarymanagementsystem.Services;

import com.example.librarymanagementsystem.Entities.Student;
import com.example.librarymanagementsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(Student student){


        studentRepository.save(student);


        return "The student has been saved to DB";
    }

}
