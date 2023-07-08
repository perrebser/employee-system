package com.perrebser.employeesystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME",nullable = false)
    private String name;

    @Column(name = "SURNAME",nullable = false)
    private String surname;

    @Column(name = "EMAIL",nullable = false)
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "CONTRACT DATE",nullable = false)
    private Date contractDate;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "CITY")
    private String city;

    @Column(name = "JOB_TITLE",nullable = false)
    private String jobTitle;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID",nullable = false)
    private Department department;
}
