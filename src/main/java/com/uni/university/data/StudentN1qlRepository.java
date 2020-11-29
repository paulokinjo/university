package com.uni.university.data;

import com.uni.university.model.student.Student;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;

@N1qlPrimaryIndexed
public interface StudentN1qlRepository extends CouchbasePagingAndSortingRepository<Student, String> {
}
