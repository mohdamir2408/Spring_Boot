package com.java.OnetoMany.project.repository;

import com.java.OnetoMany.project.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findAllByProjectId(long projectId);
}
