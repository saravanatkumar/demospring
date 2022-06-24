package com.example.demospring.users;

import org.springframework.jdbc.support.incrementer.AbstractDataFieldMaxValueIncrementer;

public enum Role {

  USER, ADMIN;
  String authority() {
        return "ROLE_" + this.name();
    }


}
