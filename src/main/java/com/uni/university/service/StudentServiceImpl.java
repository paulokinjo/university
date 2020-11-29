package com.uni.university.service;

import com.uni.university.data.StudentRepository;
import com.uni.university.model.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findStudent(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void removeStudent(String id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void updateStudent(String id, Student updatedStudent) {
        Student student = findStudent(id);
        if(student == null) {
            throw new IllegalStateException("Student " + id + " not found.");
        }

        student = updatedStudent;
        studentRepository.save(student);
    }
}
