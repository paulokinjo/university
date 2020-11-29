package com.uni.university.service;

import com.uni.university.model.student.Student;

public interface StudentService {

    void saveStudent(Student student);
    Student findStudent(String id);
    void removeStudent(String id);
    void updateStudent(String id, Student updatedStudent);
}
