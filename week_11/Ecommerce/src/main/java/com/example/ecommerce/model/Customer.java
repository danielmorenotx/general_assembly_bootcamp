package com.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@NoArgsConstructor // creates a default constructor with no arguments
@AllArgsConstructor // creates constructor with all parameters
@Data // creates getters and setters behind the scenes, no need to create them
@Entity // indicates that a class is an entity and should be mapped to a database table
public class Customer {
    @Id // treats the id as a primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // strategy tells postgres how to auto increment the id
    private Integer id;
    private String name;
    private String email;
    private Integer lastFourDigitsOfCC;
    private Date dob;

    @OneToOne(cascade = CascadeType.ALL) // all actions (save, update, delete) taken on customer will happen in address
    @JoinColumn(name = "address_id", nullable = false, unique = true) // specifies foreign key
    // creates an address_id column on the Customer column, will always be unique when created
    private Address address;

    @OneToMany(mappedBy = "customer") // value in mapped by must be the same as the many-to-one value in other class
    private List<Order> orders;

}
