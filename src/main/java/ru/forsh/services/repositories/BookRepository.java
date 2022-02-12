package ru.forsh.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.forsh.services.entites.BookEntity;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {

    @Query("select b.nameBook, a.firstNameAutor, a.lastNameAutor, b.yearCreat " +
            "from AutorEntity a left join BookEntity b on a.id = b.autorId")
    List<String> joinBookString();

    @Query("select b.nameBook, a.firstNameAutor, a.lastNameAutor, b.yearCreat " +
            "from AutorEntity a left join BookEntity b on a.id = b.autorId")
    List<Object[]> joinBookObj();

}
