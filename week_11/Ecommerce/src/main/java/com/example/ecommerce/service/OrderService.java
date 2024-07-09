package com.example.ecommerce.service;

import com.example.ecommerce.model.Customer;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.IOrderRepository;
import com.example.ecommerce.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    IOrderRepository orderRepository; // injects the order repository
    @Autowired
    IProductRepository productRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order addProductToOrder(Integer id, Product product) throws Exception {
        Order existingOrder = orderRepository.findById(id).orElseThrow(() -> new Exception("Error: No order")); // pulls list of existing products in order

        productRepository.save(product); // saves product to DB, which gives it an ID

        List<Product> products = existingOrder.getProducts(); // if order exists, it gets the products in that order and saves it to a list
        products.add(product); // adds the new product to the list of products

        return orderRepository.save(existingOrder); // saves it to the DB but will only save if it has an ID
    }
}
