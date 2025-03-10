package com.dajong.library_app.repositories;

import com.dajong.library_app.models.DbBook;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface BookRepository extends ReactiveCrudRepository<DbBook, Long> {
  Mono<Void> deleteDbBookByTitle(String title);

//    Flux<DbBook> findByAuthor(String author);
//
//    Mono<DbBook> findDbBookByTitle(String title);
}
