package com.example.schoolapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor // creates a default constructor with no arguments
@AllArgsConstructor // creates constructor with all parameters
@Data // creates getters and setters behind the scenes, no need to create them
@Entity // indicates that a class is an entity and should be mapped to a database table
// @RequiredArgsConstructor // will read all the values with the @NonNull label on them
public class Student {

    @Id // tells Springboot the next variable is an ID
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // tells Spring how to sequence primary key
    private int id;

    private String name;
    private String email;

    @OneToOne(cascade = CascadeType.ALL) // all actions (save, update, delete) taken on customer will happen in address
    @JoinColumn(name = "address_id", nullable = false, unique = true) // specifies foreign key
    // creates an address_id column on the Customer column, will always be unique when created
    private Address address;

    @JsonIgnore
    @ManyToMany(mappedBy = "courses")
    private List<Course> courses = new ArrayList<>();
}
