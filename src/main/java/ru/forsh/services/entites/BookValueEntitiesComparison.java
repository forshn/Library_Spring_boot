package ru.forsh.services.entites;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;

@Data
@Entity
public class BookValueEntitiesComparison {
    @Id
    @Column(name = "id_book")
    private Long id;

    @Column(name = "book_name")
    private String nameBook;

    @Column(name = "first_name")
    private String firstNameAutor;

    @Column(name = "last_name")
    private String lastNameAutor;

    @Column(name = "creation_date")
    private String yearCreat;


}
