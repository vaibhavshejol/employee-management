package com.bnt.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

}
