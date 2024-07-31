package com.bnt.example.service.serviceimpl;

import org.springframework.stereotype.Service;

import com.bnt.example.repository.ProjectRepository;
import com.bnt.example.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
    
    private ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository=projectRepository;
    }
}
