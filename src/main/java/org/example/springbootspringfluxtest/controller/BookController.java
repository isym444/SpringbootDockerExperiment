package org.example.springbootspringfluxtest.controller;

import org.example.springbootspringfluxtest.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/books")
public class BookController {
    private ConcurrentHashMap<String, Book> books = new ConcurrentHashMap<>();
    public BookController(){
        // Adding some initial books
        books.put("1", new Book("1", "Book One", "Author One"));
        books.put("2", new Book("2", "Book Two", "Author Two"));
        books.put("3", new Book("3", "Book Three", "Author Three"));
        books.put("4", new Book("4", "Book Four", "Author Four"));
    }
    @GetMapping
    public Flux<Book> getAllBooks() {
        return Flux.fromIterable(books.values());
    }

    @GetMapping("/{id}")
    public Mono<Book> getBookById(@PathVariable String id) {
        return Mono.justOrEmpty(books.get(id));
    }

    @PostMapping
    public Mono<Book> addBook(@RequestBody Book book) {
        books.put(book.getId(), book);
        return Mono.just(book);
    }
}
