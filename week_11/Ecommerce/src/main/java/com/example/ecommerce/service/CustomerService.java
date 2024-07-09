package com.example.ecommerce.service;

import com.example.ecommerce.model.Customer;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.repository.ICustomerRepository;
import com.example.ecommerce.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    ICustomerRepository customerRepository;
    @Autowired
    IOrderRepository orderRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Customer> getAllCustomersByName(String name) {
        return customerRepository.findAllByName(name);
    }

    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id)
                .orElse(null);
    }

    public List<Customer> getAllCustomersByLastFourDigits(Integer lastFourDigits) {
        return customerRepository.findAllByLastFourDigitsOfCC(lastFourDigits);
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id) {
        //Customer customerToBeDeleted = customerRepository.findById(id).get();
        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(int id, Customer customer) throws Exception {
        // first get customer with the id
        Customer oldCustomer = customerRepository.findById(id).orElse(null);

        if (oldCustomer == null) {
            throw new Exception("Customer with id " + id + " not found");
        }

        oldCustomer.setName(customer.getName());
        oldCustomer.setEmail(customer.getEmail());
        oldCustomer.setDob(customer.getDob());
        oldCustomer.setLastFourDigitsOfCC(customer.getLastFourDigitsOfCC());

        //Model Mapper - auto map properties for us
        return customerRepository.save(oldCustomer);
    }


    public Customer addOrderToCustomer(Integer id, Order order) throws Exception {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new Exception("Customer not found"));

        order.setCustomer(customer);
        orderRepository.save(order);

        return customer;
    }

}
