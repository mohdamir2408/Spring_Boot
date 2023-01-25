package com.java.Native_query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface stuRepo extends JpaRepository<Student, Integer> {
    @Query(value = "Select * from Student where name = ?1 and id=?2", nativeQuery = true)
    List<Student> getStudent(String name, Integer id);

    @Query(value = "Select * from Student",nativeQuery = true)
    List<Student>findAll();
    @Query(value = "update student set name =:?1 where id=:?2", nativeQuery = true)
    List<Student> updateById(Student student);


}
