package org.example.service;

import org.example.model.Book;

public interface LibraryService {
    Book getBook(int id);
    void addBook(Book book);
}
