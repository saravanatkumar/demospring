package com.example.demospring.book;

import com.example.demospring.money.Money;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class BookResponse {
    private Long id;
    private String name;
    private String authorName;
    private Money price;
    private Long countAvailable;
    private String isbn;
    private Long isbn13;
    private String image;
    private Double avgRating;
    private Integer publicationYear;
}
