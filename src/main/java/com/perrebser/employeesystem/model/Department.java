package com.perrebser.employeesystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME",nullable = false)
    private String name;

    @Column(name = "DESCRIPTION",nullable = false)
    private String description;

}
