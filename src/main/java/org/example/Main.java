package org.example;

import org.example.model.LibraryManager;
import org.example.proxy.LibraryServiceProxy;
import org.example.service.LibraryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        LibraryService libraryService = context.getBean(LibraryServiceProxy.class);

        libraryService.addBook(new org.example.model.Book(1, "Sen", "Azamat Skakov"));
        libraryService.addBook(new org.example.model.Book(2, "Clean Code", "Robert Martin"));

        System.out.println("Book: " + libraryService.getBook(1).getTitle());
        System.out.println("Book: " + libraryService.getBook(2).getTitle());

        LibraryManager eagerManager = context.getBean("eagerLibraryManager", LibraryManager.class);
        LibraryManager lazyManager = context.getBean("lazyLibraryManager", LibraryManager.class);

    }
}