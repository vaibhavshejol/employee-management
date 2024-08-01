package com.bnt.example.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    Long id;
    @Column(name = "project_name")
    String name;
    @Column(name = "project_location")
    String location;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_project",
                joinColumns = @JoinColumn(name = "project_id"),
                inverseJoinColumns= @JoinColumn(name = "employee_id"))
    List<Employee> employees;
}
