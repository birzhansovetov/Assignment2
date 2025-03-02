package org.example;

import org.example.model.LibraryManager;
import org.example.repository.BookRepository;
import org.example.service.AlternativeLibraryService;
import org.example.service.DefaultLibraryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.example.service.LibraryService;

@Component
@ComponentScan(basePackages = "org.example")
public class ProjectConfig {

    @Bean
    public LibraryManager eagerLibraryManager() {
        System.out.println("Eager LibraryManager Initialized");
        return new LibraryManager("Eager Library");
    }
    @Bean
    @Lazy
    public LibraryManager lazyLibraryManager() {
        System.out.println("Lazy LibraryManager Initialized");
        return new LibraryManager("Lazy Library");
    }

}
