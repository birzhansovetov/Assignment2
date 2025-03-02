package org.example.service;

import org.example.model.Book;
import org.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class DefaultLibraryService implements LibraryService {
    private final BookRepository bookRepository;
    @Autowired
    public DefaultLibraryService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void addBook(Book book) {
        bookRepository.addBook(book);
    }
    public Book getBook(int id) {
        return bookRepository.getBook(id);
    }
}
