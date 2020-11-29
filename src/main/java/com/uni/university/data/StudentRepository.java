package com.uni.university.data;

import com.uni.university.model.student.Student;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;

public interface StudentRepository extends CouchbasePagingAndSortingRepository<Student, String> {
}
