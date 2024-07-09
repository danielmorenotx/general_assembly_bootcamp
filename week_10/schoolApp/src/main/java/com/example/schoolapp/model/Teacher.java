package com.example.schoolapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor // creates a default constructor with no arguments
@AllArgsConstructor // creates constructor with all parameters
@Data // creates getters and setters behind the scenes, no need to create them
@Entity // indicates that a class is an entity and should be mapped to a database table
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String email;
    private int courseId;

    // Relationships
    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<Course> courses;
}
