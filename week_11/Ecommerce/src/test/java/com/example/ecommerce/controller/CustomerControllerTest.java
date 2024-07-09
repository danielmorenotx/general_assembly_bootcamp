package com.example.ecommerce.controller;

import com.example.ecommerce.model.Customer;
import com.example.ecommerce.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Date;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class) // specifies that this is for the CustomerController class
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc; // creates mock of HTTP service

    @MockBean
    private CustomerService customerService; // every time customerService is called, it is a mock bean

    // ====== create customer =======
    @Test
    public void testAddCustomer() throws Exception {

        Customer customer = new Customer(); // creates a new customer to use as a test
        // sets attributes of that customer
        customer.setId(1);
        customer.setName("John Doe");
        customer.setEmail("john@example.com");
        customer.setLastFourDigitsOfCC(1234);
        customer.setDob(new Date());

        // mock HTTP request
        mockMvc.perform(post("/customers") // starts to perform HTTP request
                .contentType(MediaType.APPLICATION_JSON) // specifies that the content being sent is a JSON
                .content(new ObjectMapper().writeValueAsString(customer))) // converts customer object to JSON string
                .andExpect(status().isOk()); // expects a 200 HTTP request
    }

    // ====== get all customers =======
    @Test
    public void testGetAllCustomers() throws Exception {
        mockMvc.perform(get("/customers")) // specifies get request at the endpoint
                .andExpect(status().isOk()); // expects 200

        verify(customerService, times(1)).getAllCustomers();
    }

    // ====== Get customer by ID =======
    @Test
    public void testGetCustomerById() throws Exception {
        // create mock customer to get by ID
        Customer mockCustomer = new Customer();
        mockCustomer.setId(1);
        mockCustomer.setName("John Doe");
        mockCustomer.setEmail("john@example.com");
        mockCustomer.setLastFourDigitsOfCC(1234);
        mockCustomer.setDob(new Date());

        // mock behavior of customerService
        // when any int is passed into the getCustomerById method, return the mockCustomer
        when(customerService.getCustomerById(anyInt())).thenReturn(mockCustomer);

        // mock GET request with specified id
        mockMvc.perform(get("/customers/{id}", 1)) // Set the 'id' parameter to 1
                .andExpect(status().isOk());

        // Verify that the customerService's getCustomerById method is called once with the correct parameter
        verify(customerService, times(1)).getCustomerById(1);
    }



    // ====== update customers ======
    @Test
    public void testUpdateCustomer() throws Exception {
        // create mock customer to use
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("john doe");
        customer.setEmail("john@example.com");

        // create mock customer with updated info
        Customer updatedCustomer = new Customer();
        updatedCustomer.setId(1);
        updatedCustomer.setName("John Doe");
        updatedCustomer.setEmail("johndoe@example.com");

        // Convert the Customer object to JSON format
        ObjectMapper objectMapper = new ObjectMapper(); // converts to a json string
        String customerJson = objectMapper.writeValueAsString(customer);

        // put when first - this is for "test set up"
        when(customerService.addCustomer(customer)).thenReturn(customer);

        mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON) // Set content type
                        .content(customerJson))  // Pass JSON content
                .andExpect(status().isOk())  // Expecting status code 200
                .andExpect(content().string(customerJson)); // Response should be the same JSON as request

        // in this test method, was customerService's addCustomer method invoked at least once?
        verify(customerService, times(1)).addCustomer(customer);

    }

    // ====== Delete customer =======
    @Test
    public void testDeleteCustomerById() throws Exception {
        // Mock customer ID to be deleted
        int customerIdToDelete = 1;

        // Mock the behavior of customerService.deleteCustomerById() method
        doNothing().when(customerService).deleteCustomer(customerIdToDelete);

        // Perform mock HTTP DELETE request to the endpoint with specified customer ID
        mockMvc.perform(delete("/customers/{id}", customerIdToDelete))
                .andExpect(status().isOk());

        // Verify that the customerService's deleteCustomerById method is called once with the correct parameter
        verify(customerService, times(1)).deleteCustomer(customerIdToDelete);
    }

}
