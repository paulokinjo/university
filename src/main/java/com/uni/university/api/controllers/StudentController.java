package com.uni.university.api.controllers;

import com.uni.university.model.student.Student;
import com.uni.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public void post(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @GetMapping
    public Object get(@RequestParam Optional<String> byName, @RequestParam Optional<String> countByName) {
        if(byName.isPresent()) {
            if(countByName.isPresent()) {
                return studentService.getCountByFullName(byName.get());
            }

            return studentService.findByFullName(byName.get());
        }
        return studentService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Student get(@PathVariable("id") String id) {
        return studentService.findStudent(id);
    }

    @PutMapping(path = "/{id}")
    public void put(@PathVariable("id") String id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") String id) {
        studentService.removeStudent(id);
    }
}
