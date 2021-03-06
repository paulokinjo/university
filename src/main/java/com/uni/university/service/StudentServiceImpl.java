package com.uni.university.service;

import com.uni.university.data.StudentRepositoryN1ql;
import com.uni.university.data.StudentRepository;
import com.uni.university.model.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentRepositoryN1ql studentRepositoryN1ql;

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

    @Override
    public List<Student> findAll() {
        return (List<Student>)studentRepository.findAll();
    }

    @Override
    public List<Student> findByFullName(String fullName) {
        return studentRepository.findByFullName(fullName);
    }

    @Override
    public Integer getCountByFullName(String fullName) {
        return studentRepository.getCountByFullName(fullName);
    }

    @Override
    public List<Student> findByFullNameN1ql(String fullName) {
        return studentRepositoryN1ql.findByFullName(fullName);
    }

    @Override
    public List<Student> findByFullNameLikeN1ql(String fullName) {
        return studentRepositoryN1ql.findByFullNameLike(fullName);
    }
}
