package com.example.librarymanagementsystem.RequestDtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class AssociateCardStudentRequest {

    private Integer studentId;
    private Integer cardId;

}
