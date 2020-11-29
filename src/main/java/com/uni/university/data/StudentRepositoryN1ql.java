package com.uni.university.data;

import com.uni.university.model.student.Student;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;

import java.util.List;

@N1qlPrimaryIndexed
public interface StudentRepositoryN1ql extends CouchbasePagingAndSortingRepository<Student, String> {

    @Query("#{#n1ql.selectEntity} WHERE #{#n1ql.filter} AND fullName = $1 ORDER BY fullName DESC")
    List<Student> findByFullName(String fullName);

    @Query("#{#n1ql.selectEntity} WHERE #{#n1ql.filter} AND fullName LIKE '%#{[0]}%'")
    List<Student> findByFullNameLike(String fullName);
}
