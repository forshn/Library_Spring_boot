package ru.forsh.services.entites;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

@Accessors(chain = true)
@Entity
@Data
public class BookValueEntities {

    @Id
    Integer id;

    String nameBook;

    String firstNameAutor;

    String lastNameAutor;

    Integer yearCreat;
}
