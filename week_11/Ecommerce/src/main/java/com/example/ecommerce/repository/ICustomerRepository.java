package com.example.ecommerce.repository;

import com.example.ecommerce.model.Customer;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;

@Primary
public interface ICustomerRepository extends JpaRepository<Customer, Integer> { // JpaRepo is told to create a Customer repository and identify as an integer
    public List<Customer> findAllByName(String name);

    public List<Customer> findAllByLastFourDigitsOfCC(Integer lastFourDigits);

}
