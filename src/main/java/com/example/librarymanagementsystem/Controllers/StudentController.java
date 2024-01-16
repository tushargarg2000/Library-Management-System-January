package com.example.librarymanagementsystem.Controllers;

import com.example.librarymanagementsystem.Entities.Student;
import com.example.librarymanagementsystem.RequestDtos.ModifyPhnNoRequest;
import com.example.librarymanagementsystem.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody Student student){

        String result = studentService.addStudent(student);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/findById")
    public ResponseEntity findStudentById(@RequestParam("studentId")Integer studentId) {

        try{
            Student student = studentService.findStudentById(studentId);
            return new ResponseEntity(student,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/modifyPhnNo")
    public String modifyPhnNo(@RequestBody ModifyPhnNoRequest modifyPhnNoRequest){

        String result = studentService.modifyPhnNo(modifyPhnNoRequest);

        return result;

    }



}
