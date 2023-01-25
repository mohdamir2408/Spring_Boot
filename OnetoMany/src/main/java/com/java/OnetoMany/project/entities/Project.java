package com.java.OnetoMany.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java.OnetoMany.employee.entities.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectId;
    private String projectName;

    private int Employee;
    @JsonIgnore
    @ManyToMany(mappedBy = "assignedProjects")
    private Set<Employee> employeeSet = new HashSet<>(Employee);
}