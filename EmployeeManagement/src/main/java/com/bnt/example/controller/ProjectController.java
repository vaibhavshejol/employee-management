package com.bnt.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnt.example.entities.Project;
import com.bnt.example.response.SuccessResponse;
import com.bnt.example.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService=projectService;
    }

    @PostMapping
    public ResponseEntity<SuccessResponse> createProject(@RequestBody Project project){
        Project createdProject = projectService.addProject(project);
        SuccessResponse response = new SuccessResponse("Project added successfully.....", createdProject, HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<SuccessResponse> getProjects(){
        List<Project> existedProjects = projectService.getProjects();
        SuccessResponse response = new SuccessResponse("Project list:", existedProjects, HttpStatus.FOUND);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse> getProject(@PathVariable Long id){
        Project existedProject = projectService.getProject(id);
        SuccessResponse response = new SuccessResponse("Project with given id "+id, existedProject, HttpStatus.FOUND);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse> updateProject(@PathVariable Long id, @RequestBody Project project){
        Project updatedProject = projectService.updatedProject(id, project);
        SuccessResponse response = new SuccessResponse("Project updated.", updatedProject, HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> deleteProject(@PathVariable Long id){
        Project deletedProject = projectService.deleteProject(id);
        SuccessResponse response = new SuccessResponse("Project with given id "+id+" deleted.", deletedProject, HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
