package com.bnt.example.service.serviceimpl;

import org.springframework.stereotype.Service;

import com.bnt.example.entities.Project;
import com.bnt.example.exception.UnknownException;
import com.bnt.example.repository.ProjectRepository;
import com.bnt.example.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
    
    private ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository=projectRepository;
    }

    @Override
    public Project addProject(Project project) {
        try{
            if(project==null || project.getName()==null || project.getLocation()==null){
                throw new UnknownException("Project object or field cannot be null.");
            }
            return projectRepository.save(project);
        }catch(Exception e){
            throw new UnknownException(e.getMessage());
        }
    }
}
