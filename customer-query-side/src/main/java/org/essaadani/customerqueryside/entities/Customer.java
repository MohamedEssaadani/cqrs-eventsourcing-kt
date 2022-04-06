package org.essaadani.customerqueryside.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class Customer {
    @Id
    private String customerId;
    private String name;
    private String email;
}
