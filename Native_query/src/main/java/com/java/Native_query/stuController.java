package com.java.Native_query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class stuController {
    @Autowired
    private StuService stuService;

    @PostMapping("/insert")
    public Student addData(@RequestBody Student student)
    {
        return stuService.addData(student);
    }
    @GetMapping("/viewAll")
    public List<Student> viewAllData()
    {
        return stuService.viewAll();
    }
    @GetMapping("/viewById/{id}")
    public Optional<Student> viewById(@PathVariable Integer id)
    {
        return stuService.viewById(id);
    }
//    @PostMapping("/update")
//    public Student update(@RequestBody Student student)
//    {
//        return stuService.update(student);
//    }
    //Method for Native
    @GetMapping("/stu/{name}/{id}")
    public List<Student> getStudent(@RequestParam String name, Integer id)
    {
        return stuService.getStudent(name,id);
    }
    @PutMapping("/updateById/{id}/{name}")
    public List<Student>updateById(@RequestBody Student student)
    {
        return (List<Student>) stuService.updateById(student);
    }
}
