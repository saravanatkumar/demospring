package com.example.demospring.customer;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findAllByFirstName(String name);


}
