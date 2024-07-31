package com.bnt.example.service;

import java.util.List;

import com.bnt.example.entities.Project;

public interface ProjectService {

    Project addProject(Project project);

    List<Project> getProjects();

    Project getProject(Long id);
    
}
