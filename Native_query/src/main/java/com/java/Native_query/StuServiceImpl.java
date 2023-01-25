package com.java.Native_query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StuServiceImpl implements StuService {
    @Autowired
    private stuRepo stuRepo ;

    @Override
    public Student addData(Student student)
    {
        return stuRepo.save(student);
    }

    @Override
    public List<Student> viewAll()
    {
        return stuRepo.findAll();
    }

    @Override
    public Optional<Student> viewById(Integer id)
    {
        return stuRepo.findById(id);
    }

    @Override
    public Student updateById( Student student) {
        return (Student) stuRepo.updateById( student);
    }
    @Override
    public List<Student> getStudent(String name, Integer id)
    {
        return stuRepo.getStudent(name, id);
    }

//
}
