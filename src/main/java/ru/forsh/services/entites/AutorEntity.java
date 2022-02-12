package ru.forsh.services.entites;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Accessors(chain = true)
@Entity
@Data
@Table(name = "autor_table")
public class AutorEntity {

    @Id
    @Column(name = "id_autor")
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "increment")
    private Integer id;

    @Column(name = "first_name")
    private String firstNameAutor;

    @Column(name = "last_name")
    private String lastNameAutor;
}
