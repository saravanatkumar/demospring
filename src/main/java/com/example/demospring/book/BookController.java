package com.example.demospring.book;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@CrossOrigin
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService=bookService;
    }

    @GetMapping("/books")
    @Operation(summary = "Search and List all books", description = "Lists all books in bookshop matching with search criteria", tags = {"Books Service"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List all books",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookResponse.class))})
    })
    List<BookResponse> list(@RequestParam String bookOrAuthorName) {
        List<Book> books = bookService.fetchAll(bookOrAuthorName);
        return books.stream()
                .map(Book::toResponse)
                .collect(toList());
    }

    @GetMapping("/books/{id}")
    @Operation(summary = "Get one Book ", description = "Lists the book in bookshop matching with search ID", tags = {"Books Service"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List Single book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookResponse.class))})
    })
    Book list(@PathVariable("id") long id) throws BookNotFoundException {
        Book book = bookService.findById(id);

        //Book book =  assertThrows(BookNotFoundException.class, () -> bookService.findById(id));
        return book;
    }




}
