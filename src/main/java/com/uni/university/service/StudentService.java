package com.uni.university.service;

import com.uni.university.model.student.Student;

import java.util.List;

public interface StudentService {

    void saveStudent(Student student);
    Student findStudent(String id);
    void removeStudent(String id);
    void updateStudent(String id, Student updatedStudent);
    List<Student> findAll();
    List<Student> findByFullName(String fullName);
    Integer getCountByFullName(String fullName);
}
