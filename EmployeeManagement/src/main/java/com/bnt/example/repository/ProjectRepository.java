package com.bnt.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnt.example.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    
}
