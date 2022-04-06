package org.essaadani.customerqueryside.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.essaadani.coreapi.query.GetAllCustomersQuery;
import org.essaadani.coreapi.query.GetCustomerByIdQuery;
import org.essaadani.customerqueryside.entities.Customer;
import org.essaadani.customerqueryside.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerQueryHandler {
    public CustomerRepository customerRepository;

    @QueryHandler
    public List<Customer> getAllCustomers(GetAllCustomersQuery query){
        log.info("*************************************************");
        log.info("Get All Customers ");
        return customerRepository.findAll();
    }

    @QueryHandler
    public Customer getCustomerById(GetCustomerByIdQuery query) {
        return customerRepository.findById(query.getId())
                .orElseThrow(()->new RuntimeException("Customer not found!"));

    }
}
