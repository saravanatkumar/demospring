package com.example.demospring.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table(name = "users")
public class User {

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String first_name;

    private Long last_name;

    private  String mobile_number;


    public User() {

    }

    public User( String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public static User create(CreateUserRequest userRequest) {
        userRequest.email= email;
        userRequest.getPassword()                                                                                          d dddddddddddddddddd=  email;


        return null;
    }






}
