package com.bnt.example.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Company {
    String name;
}
