package com.example.restfulwebservice.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;


@Data
@AllArgsConstructor
public class User {
    private Integer id;

    @Size(min = 2, message = "2글자 이상이어야 합니다.")
    private String name;
    @Past
    private Date date;
}
