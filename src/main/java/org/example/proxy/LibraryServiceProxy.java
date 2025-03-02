package org.example.proxy;

import org.example.model.Book;
import org.example.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LibraryServiceProxy implements LibraryService {
    private final LibraryService primaryLibraryService;
    private final LibraryService alternativeLibraryService;


    @Autowired
    public LibraryServiceProxy(@Qualifier("defaultLibraryService") LibraryService primaryLibraryService,
                               @Qualifier("alternativeLibraryService") LibraryService alternativeLibraryService) {
        this.primaryLibraryService = primaryLibraryService;
        this.alternativeLibraryService = alternativeLibraryService;
    }

    @Override
    public Book getBook(int id) {
    if (id%2 == 0) {
        return alternativeLibraryService.getBook(id);
    }else {
        return primaryLibraryService.getBook(id);
    }
    }

    @Override
    public void addBook(Book book) {
    if (book.getId()%2==0){
        System.out.println(book.getTitle());
        alternativeLibraryService.addBook(book);
    }else {
        primaryLibraryService.addBook(book);
        System.out.println(book.getTitle());
    }
    }
}
