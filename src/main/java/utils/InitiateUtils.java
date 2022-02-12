package utils;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import services.AutorService;
import services.BookService;

@Service
@RequiredArgsConstructor
public class InitiateUtils implements CommandLineRunner {


    private final AutorService autorService;
    private final BookService bookService;

    @Override
    public void run(String... args) throws Exception {

    }
}
