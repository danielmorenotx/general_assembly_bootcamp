package com.example.ecommerce.service;

import com.example.ecommerce.model.Customer;
import com.example.ecommerce.repository.ICustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private ICustomerRepository customerRepository;

    // ====== create customer =======
    @Test
    public void testAddCustomer() {
        Customer customer = new Customer(); // creates a new customer to use as a test
        // sets attributes of that customer
        customer.setId(1);
        customer.setName("John Doe");
        customer.setEmail("john@example.com");
        customer.setLastFourDigitsOfCC(1234);
        customer.setDob(new Date());

        // mock behavior of the repository saving
        when(customerRepository.save(any(Customer.class))).thenReturn(customer); // this does not invoke the .save method
        // this just sets up the expectation that the .save method is going to be called

        // Add the customer
        customerService.addCustomer(customer); // this is where the .save method is actually called
        // without this line, the verify() will fail because the .save would never actually be called

        // verify that in the customerRepository, the save method is called at least once
        verify(customerRepository, times(1)).save(customer); // the .save(customer) is called int eh CustomerService addCustomer() method

    }

    // ====== get all customers =======
    @Test
    public void testGetAllCustomers() {
        // Create a list of mock customers
        List<Customer> mockCustomers = new ArrayList<>();
        mockCustomers.add(new Customer());
        mockCustomers.add(new Customer());
        mockCustomers.add(new Customer());

        // mock behavior of findAll method
        // when findAll is called in the customer repo, return the list of mock Customers
        when(customerRepository.findAll()).thenReturn(mockCustomers);

        // get all the customers
        List<Customer> allCustomers = customerService.getAllCustomers();

        // verify the findAll method is called
        verify(customerRepository, times(1)).findAll();

        // verify that it's the correct size
        assertEquals(3, allCustomers.size());

    }

    // ====== get customer by ID =======
    @Test
    public void testGetCustomerById() {
        // Create a mock customer
        Customer mockCustomer = new Customer();
        mockCustomer.setId(1);
        mockCustomer.setName("John Doe");
        mockCustomer.setEmail("john@example.com");
        mockCustomer.setLastFourDigitsOfCC(1234);
        mockCustomer.setDob(new Date());

        // mock behavior of findById
        when(customerRepository.findById(1)).thenReturn(Optional.of(mockCustomer));

        // Get customer by ID
        Customer customerOptional = customerService.getCustomerById(1);

        // verify that it has the correct ID
        verify(customerRepository, times(1)).findById(1);

        assertEquals(mockCustomer, customerOptional);
    }

    // ====== update customer =======
    @Test
    public void testUpdateCustomer() throws Exception {
        // Create a mock customer
        Customer existingCustomer = new Customer();
        existingCustomer.setId(1);
        existingCustomer.setName("John Doe");
        existingCustomer.setEmail("john@example.com");
        existingCustomer.setLastFourDigitsOfCC(1234);
        existingCustomer.setDob(new Date());

        // Create a mock updated customer
        Customer updatedCustomer = new Customer();
        updatedCustomer.setId(1);
        updatedCustomer.setName("Updated Name");
        updatedCustomer.setEmail("updated@example.com");
        updatedCustomer.setLastFourDigitsOfCC(5678); // Set updated values

        // Mock behavior of customerRepository.findById()
        when(customerRepository.findById(1)).thenReturn(Optional.of(existingCustomer));

        // Mock behavior of customerRepository.save()
        when(customerRepository.save(any(Customer.class))).thenReturn(updatedCustomer);

        // Call the updateCustomer method
        Customer result = customerService.updateCustomer(1, updatedCustomer);

        // Verify that the save method is called with the updated customer object
        Mockito.verify(customerRepository, Mockito.times(1)).save(updatedCustomer);

        // Verify that the returned customer matches the updated customer
        assertEquals(updatedCustomer, result);

    }

    // ====== delete customer =======
    @Test
    public void testDeleteCustomer() {
        // Create a mock customer
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("John Doe");
        customer.setEmail("john@example.com");
        customer.setLastFourDigitsOfCC(1234);
        customer.setDob(new Date());

        // Delete the customer
        customerService.deleteCustomer(customer.getId());

        // Verify that the deleteById method is called with the correct ID
        Mockito.verify(customerRepository, Mockito.times(1)).deleteById(customer.getId());
    }


}
