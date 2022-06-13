package com.example.demospring.customer;

import lombok.*;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "Customer")
@EqualsAndHashCode
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;
    private String lastName;


   // protected Customer() {}

    public Customer( String firstName, String lastName) {
        this.firstName=firstName;
        this.lastName=lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }


    public CustomerResponse toResponse() {
        return CustomerResponse.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }



}
