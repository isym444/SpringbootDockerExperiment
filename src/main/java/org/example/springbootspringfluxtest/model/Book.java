package org.example.springbootspringfluxtest.model;

public class Book {
    private String id;
    private String title;
    private String author;

    public Book() {
    }

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    public String getId() {
        return id;
    }
}
