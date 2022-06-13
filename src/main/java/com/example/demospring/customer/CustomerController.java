package com.example.demospring.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.example.demospring.customer.CustomerRepository;
import com.example.demospring.customer.Customer;

import static java.util.stream.Collectors.toList;

@CrossOrigin()
@RestController
public class CustomerController {

    private CustomerService customerService;


    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService=customerService;
    }

    @GetMapping("/customers")
    @Operation(summary = "Search and List all customers", description = "Lists all customers in bookshop matching with search criteria", tags = {"Customers Service"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List all customers",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomerResponse.class))})
    })
    List<CustomerResponse> list(@RequestParam String name) {
        List<Customer> customers = customerService.findByCustomerName(name);
        return customers.stream()
                .map(Customer::toResponse)
                .collect(toList());
    }
    




}

