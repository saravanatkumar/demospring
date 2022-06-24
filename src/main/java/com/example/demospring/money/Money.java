package com.example.demospring.money;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Money {

    private String currency;
    @Column(columnDefinition = "NUMERIC")
    private double amount;

    public static Money rupees(double amount) {
        return new Money("INR", amount);
    }


}
