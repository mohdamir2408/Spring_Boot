package com.java.OnetoMany.project.service;

import com.java.OnetoMany.project.entities.Project;
import com.java.OnetoMany.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectService
{

    @Autowired
    private ProjectRepository projectRepository;

    public void saveProject(Project projectObj) {
        projectRepository.save(projectObj);
    }

    public List<com.java.OnetoMany.project.entities.Project> getProjectDetails(Long projectId) {
        if (null != projectId) {
            return projectRepository.findAllByProjectId(projectId);
        } else {
            return projectRepository.findAll();
        }
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}
