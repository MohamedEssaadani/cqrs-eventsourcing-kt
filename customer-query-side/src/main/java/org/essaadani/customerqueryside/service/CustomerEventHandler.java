package org.essaadani.customerqueryside.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.essaadani.coreapi.events.CustomerCreatedEvent;
import org.essaadani.customerqueryside.entities.Customer;
import org.essaadani.customerqueryside.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerEventHandler {
    private CustomerRepository customerRepository;

    @EventHandler
    public void on(CustomerCreatedEvent event){
        Customer customer = new Customer(
                event.getId(),
                event.getName(),
                event.getEmail()
        );

        customerRepository.save(customer);
    }

}
