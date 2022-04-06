package org.essaadani.customerqueryside.repository;

import org.essaadani.customerqueryside.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
