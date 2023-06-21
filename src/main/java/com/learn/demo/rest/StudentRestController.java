package com.learn.demo.rest;

import com.learn.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> theStudents;

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Amit", "kumar"));
        theStudents.add(new Student("Suraj", "kumar"));
        theStudents.add(new Student("Shubham", "kumar"));
    }
    // define endpoint for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudents(@PathVariable int studentId) {

        //check the studentId again list size

        if (((studentId >= theStudents.size() || (studentId < 0)))){
            throw new StudentNotFoundException("Student is not found - " + studentId);
        }
        return theStudents.get(studentId);
    }

}




