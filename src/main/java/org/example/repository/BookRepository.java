package org.example.repository;

import org.example.model.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class BookRepository {
       private Map<Integer, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }
    public Book getBook(int id) {
        return books.get(id);
    }


}
