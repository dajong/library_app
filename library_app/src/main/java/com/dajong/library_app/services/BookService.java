package com.dajong.library_app.services;

import com.dajong.library_app.dto.BookDTO;
import com.dajong.library_app.repositories.BookRepository;
import com.dajong.library_app.models.BookResponse;
import com.dajong.library_app.models.DbBook;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    // Retrieve all books
    public Flux<BookResponse> getAllBooks() {
        return bookRepository
            .findAll()
            .map(this::convertBookResponse);
    }

    // Retrieve a book by its ID
    public Mono<BookResponse> getBookById(Long id) {
        return bookRepository.findById(id).map(this::convertBookResponse);
    }

    // Create a new book
    public Mono<BookResponse> createBook(BookDTO book) {
        final DbBook dbBook = DbBook.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .createdAt(LocalDateTime.now())
                .lastModified(LocalDateTime.now())
                .build();
        return bookRepository.save(dbBook).map(this::convertBookResponse);
    }

    // Update an existing book
//    public Mono<BookDTO> updateBook(BookDTO updatedBook) {
//        return bookRepository.findById(id)
//                .flatMap(existingBook -> {
//                    existingBook.setTitle(updatedBook.getTitle());
//                    existingBook.setAuthor(updatedBook.getAuthor());
//                    return bookRepository.save(existingBook);
//                });
//    }

    // Delete a book by its ID
    public Mono<Void> deleteBookById(Long id) {
        return bookRepository.deleteById(id);
    }

    private BookResponse convertBookResponse(DbBook dbBook) {
        return BookResponse
                .builder()
                .bookId(dbBook.getId())
                .title(dbBook.getTitle())
                .author(dbBook.getAuthor())
                .build();

    }
}
