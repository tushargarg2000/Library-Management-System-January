package com.example.librarymanagementsystem.Services;

import com.example.librarymanagementsystem.Entities.Student;
import com.example.librarymanagementsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(Student student){

        Student savedStudent = studentRepository.save(student);

        return "The student has been saved to DB with studentId"+savedStudent.getStudentId();
    }

    public Student findStudentById(Integer studentId)throws Exception {

        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        //Validation if the studentId entered is correct or not
        if(optionalStudent.isEmpty()) {
            throw new Exception("Student Id entered is incorrect");
        }
        Student student = optionalStudent.get();

        return student;
    }

}
