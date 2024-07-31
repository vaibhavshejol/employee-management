package com.bnt.example.service.serviceimpl;

import java.util.List;

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

    @Override
    public List<Project> getProjects() {
        try{
            List<Project> existedProjects = projectRepository.findAll();
            if (existedProjects==null || existedProjects.size()<1) {
                throw new UnknownException("There is no projects present in database.");
            }
            return existedProjects;
        }catch(Exception e){
            throw new UnknownException(e.getMessage());
        }
    }

    @Override
    public Project getProject(Long id) {
        try{
            if (id==null) {
                throw new UnknownException("Id cannot be null");
            }
            Project existedProject = projectRepository.findById(id).get();
            if(existedProject==null){
                throw new UnknownException("Project with given id "+id+" not present.");
            }
            return existedProject;
        }catch(Exception e){
            throw new UnknownException(e.getMessage());
        }
    }

    @Override
    public Project updatedProject(Long id, Project project) {
        try{
            if (id==null || project==null || project.getName()==null || project.getLocation()==null) {
                throw new UnknownException("Id or project object or field of project cannot be null");
            }
            Project existedProject = projectRepository.findById(id).get();
            if(existedProject==null){
                throw new UnknownException("Project with given id = "+id+" not present, please check you are giving correct id.");
            }
            project.setId(id);
            return projectRepository.save(project);
        }catch(Exception e){
            throw new UnknownException(e.getMessage());
        }
    }
}
