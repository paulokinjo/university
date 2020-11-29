package com.uni.university.data;

import com.uni.university.model.student.Student;
import org.springframework.data.couchbase.core.query.View;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;

import java.util.List;

@ViewIndexed(designDoc = "student")
public interface StudentRepository extends CouchbasePagingAndSortingRepository<Student, String> {

    @View(viewName = "byFullName")
    List<Student> findByFullName(String fullName);

    @View(viewName = "countByFullName", reduce = true)
    Integer getCountByFullName(String fullName);
}
