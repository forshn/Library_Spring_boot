package ru.forsh.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.forsh.services.entites.AutorEntity;

@Repository
public interface AutorRepository extends JpaRepository<AutorEntity, Integer> {
}
