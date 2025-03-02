package org.example;

import org.example.model.LibraryManager;
import org.example.service.LibraryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        LibraryService libraryService = context.getBean(LibraryService.class);
        libraryService.addBook(new org.example.model.Book(1, "Sen", "Azamat Skakov"));
        System.out.println("Book: " + libraryService.getBook(1));
        LibraryManager eagerManager = context.getBean("eagerLibraryManager", LibraryManager.class);
        LibraryManager lazyManager = context.getBean("lazyLibraryManager", LibraryManager.class);

    }
}