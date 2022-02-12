package ru.forsh.services.entites;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Accessors(chain = true)
@Entity
@Data
@Table(name = "book_table")
public class BookEntity {

    @Id
    @Column(name = "id_book")
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Integer id;

    @Column(name = "book_name")
    private String nameBook;

    @Column(name = "creation_date")
    private Integer yearCreat;

    @Column(name = "autor_id")
    private Integer autorId;


}
