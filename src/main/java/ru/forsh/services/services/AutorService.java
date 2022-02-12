package ru.forsh.services.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.forsh.services.entites.AutorEntity;
import ru.forsh.services.entites.BookEntity;
import ru.forsh.services.repositories.AutorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorService {
    private final AutorRepository repository;

    public List<AutorEntity> findAll(){
        return repository.findAll();
    }

    public void saveAll(List<AutorEntity> autorEntities){
        repository.saveAll(autorEntities);
    }
}
