package org.example.service;

import org.example.model.Book;
import org.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("alternativeLibraryService")
public class AlternativeLibraryService implements LibraryService {
    private final BookRepository bookRepository;
    @Autowired
    public AlternativeLibraryService(BookRepository bookRepository) {
        this.bookRepository=bookRepository;
    }

    @Override
    public Book getBook(int id) {
        return bookRepository.getBook(id);
    }

    public void addBook(Book book) {
        bookRepository.addBook(new Book(book.getId(), "[Alternative] " + book.getTitle(), book.getAuthor()));
        System.out.println("[AlternativeLibraryService] Added book: " + book.getTitle());

    }
}
