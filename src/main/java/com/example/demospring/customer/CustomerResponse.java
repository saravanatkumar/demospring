package com.example.demospring.customer;
import jdk.nashorn.internal.runtime.Debug;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
public class CustomerResponse {

    private Long id;
    private String firstName;
    private String lastName;


}
