package ru.forsh.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.forsh.services.entites.AutorEntity;
import ru.forsh.services.entites.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
}
