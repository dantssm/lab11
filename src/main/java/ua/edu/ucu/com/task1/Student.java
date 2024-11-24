package ua.edu.ucu.com.task1;

import java.util.List;

import lombok.Builder;
import lombok.Singular;
import lombok.ToString;

@Builder
@ToString
public class Student {
    
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private int age;
    @Singular private List<String> courses; // по одному курсу додавати

}
