package ru.forsh.services.services;

import ru.forsh.services.entites.BookEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.forsh.services.repositories.BookRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository repository;

    public void saveAll(List<BookEntity> bookEntities){
        repository.saveAll(bookEntities);
    }

    public void save(BookEntity book){
        repository.save(book);
    }

    public List<BookEntity> getAll(){
        return repository.findAll();
    }


}
