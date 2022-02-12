package ru.forsh.services.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.forsh.services.entites.AutorEntity;
import ru.forsh.services.entites.BookEntity;
import ru.forsh.services.services.AutorService;
import ru.forsh.services.services.BookService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InitiateUtils implements CommandLineRunner {


    private final AutorService autorService;
    private final BookService bookService;

    @Override
    public void run(String... args) throws Exception {
        List<BookEntity> bookEntityList = new ArrayList<>(
                Arrays.asList(
                        new BookEntity()
                                .setNameBook("Горе от ума")
                                .setYearCreat(1824)
                                .setAutorId(1),
                        new BookEntity()
                                .setNameBook("Война и мир")
                                .setYearCreat(1863)
                                .setAutorId(2),
                        new BookEntity()
                                .setNameBook("Мцыри")
                                .setYearCreat(1838)
                                .setAutorId(3),
                        new BookEntity()
                                .setNameBook("Евгений Онегин")
                                .setYearCreat(1833)
                                .setAutorId(4)
                )
        );

        List<AutorEntity> authorEntityList = new ArrayList<>(
                Arrays.asList(
                        new AutorEntity()
                                .setFirstNameAutor("Александр")
                                .setLastNameAutor("Грибоедов"),
                        new AutorEntity()
                                .setFirstNameAutor("Лев")
                                .setLastNameAutor("Толстой"),
                        new AutorEntity()
                                .setFirstNameAutor("Михаил")
                                .setLastNameAutor("Лермонтов"),
                        new AutorEntity()
                                .setFirstNameAutor("Александр")
                                .setLastNameAutor("Пушкин")
                ));

        bookService.saveAll(bookEntityList);
        autorService.saveAll(authorEntityList);

        System.out.println("\nТаблица книг");
        for (BookEntity book : bookService.findAll()) {
            System.out.println(book);
        }

        System.out.println("\nТаблица авторов");
        for (AutorEntity author : autorService.findAll()) {
            System.out.println(author);
        }
    }
}