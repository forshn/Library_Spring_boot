package ru.forsh.services.utils;

import ru.forsh.services.entites.AutorEntity;
import ru.forsh.services.entites.BookEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.forsh.services.services.AutorService;
import ru.forsh.services.services.BookService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class InitiateUtils implements CommandLineRunner {


    private final AutorService autorService;
    private final BookService bookService;

    @Override
    public void run(String... args) throws Exception {
        List<BookEntity> bookEntities = new ArrayList<>(Arrays.asList(
                new BookEntity()
                        .setNameBook("Война и Мир")
                        .setAutorId(Math.abs(new Random().nextInt() % 10)),
                new BookEntity()
                        .setNameBook("Преступление и наказание")
                        .setAutorId(Math.abs(new Random().nextInt() % 10)),
                new BookEntity()
                        .setNameBook("Аэропорт")
                        .setAutorId(Math.abs(new Random().nextInt() % 10))
        ));

        List<AutorEntity> autorEntities = new ArrayList<>(Arrays.asList(
                new AutorEntity().setFirstNameAutor("Александр")
                        .setLastNameAutor("Блок"),
                new AutorEntity().setFirstNameAutor("Федор")
                        .setLastNameAutor("Достоевский"),
                new AutorEntity().setFirstNameAutor("Артур")
                        .setLastNameAutor("Хейли")
        ));

        bookService.saveAll(bookEntities);

        bookService.getAll().forEach(System.out::println);
    }
}
