package com.java.Native_query;

import java.util.List;
import java.util.Optional;
public interface StuService {
    public Student addData(Student student);
    public List<Student> viewAll();
    public Optional<Student> viewById(Integer id);
   // public Student update(Student student);
   public Student updateById( Student student);

    //    public void deleteById(Integer id);
//    public void deleteAllData();
    public List<Student> getStudent(String name, Integer id);
}
