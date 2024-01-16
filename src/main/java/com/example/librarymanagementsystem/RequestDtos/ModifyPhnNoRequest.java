package com.example.librarymanagementsystem.RequestDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModifyPhnNoRequest {

    private Integer studentId;
    private String newPhnNo;
}
