package com.bnt.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Company {
    @Column(name = "company_name")
    String name;
}
