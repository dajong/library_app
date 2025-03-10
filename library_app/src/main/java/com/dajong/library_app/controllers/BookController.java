package com.dajong.library_app.controllers;

import com.dajong.library_app.dto.BookDTO;
import com.dajong.library_app.models.BookResponse;
import com.dajong.library_app.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    // Get all books
    @GetMapping
    public Flux<BookResponse> getAllBooks() {

        return service.getAllBooks();
    }

    // Get a book by ID
    @GetMapping("/{id}")
    public Mono<BookResponse> getBookById(@PathVariable Long id) {
        return service.getBookById(id);
    }

    // Add a new book
    @PostMapping
    public Mono<BookResponse> createBook(@RequestBody BookDTO book) {
        return service.createBook(book);
    }

    // get books by author


    // Update an existing book
//    @PutMapping("/{id}")
//    public Mono<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
//        return repository.findById(id)
//                .flatMap(existingBook -> {
//                    existingBook.setTitle(book.getTitle());
//                    existingBook.setAuthor(book.getAuthor());
//                    return repository.save(existingBook);
//                });
//    }

    // Delete a book
    @DeleteMapping("/{id}")
    public Mono<Void> deleteBook(@PathVariable Long id) {
        return service.deleteBookById(id);
    }
}
