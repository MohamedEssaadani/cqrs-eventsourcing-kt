package org.essaadani.customerqueryside.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.essaadani.coreapi.query.GetAllCustomersQuery;
import org.essaadani.coreapi.query.GetCustomerByIdQuery;
import org.essaadani.customerqueryside.entities.Customer;
import org.essaadani.customerqueryside.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/customers/query")
public class CustomerQueryController {
    private QueryGateway queryGateway;
    private CustomerRepository customerRepository;

    @GetMapping
    public CompletableFuture<List<Customer>> getAllCustomers(){
        return queryGateway.query(new GetAllCustomersQuery(),
                ResponseTypes.multipleInstancesOf(Customer.class));
    }

    @GetMapping("/{customerId}")
    public CompletableFuture<Customer> getCustomerById(@PathVariable String customerId){
        return queryGateway.query(new GetCustomerByIdQuery(customerId), ResponseTypes.instanceOf(Customer.class));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionHandler(Exception exception){
        ResponseEntity<String> responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        return responseEntity;
    }
}
