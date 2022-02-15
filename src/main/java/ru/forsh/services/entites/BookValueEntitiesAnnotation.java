package ru.forsh.services.entites;

import lombok.Data;

import javax.persistence.*;

@SqlResultSetMapping(
        name = "BookValueMapping",//даем название нашему маппингу
        entities = @EntityResult(
                entityClass = BookValueEntitiesAnnotation.class,//указываем конечный класс куда будем маппить
                fields = {//в блоке полей указываем соответствие полей(name =) конечного класса и полей(colum =) результата запроса
                        @FieldResult(name = "id", column = "id_book_value"),
                        @FieldResult(name = "nameBook", column = "book_name"),
                        @FieldResult(name = "firstNameAuthor", column = "first_name"),
                        @FieldResult(name = "lastNameAuthor", column = "last_name"),
                        @FieldResult(name = "yearCreat", column = "creation_date")
                }
        )
)

@Data
@Entity
@Table(name = "BookValueEntitiesAnnotation")
public class BookValueEntitiesAnnotation {

    @Id
    @Column
    private Integer id;

    @Column
    String nameBook;

    @Column
    String firstNameAuthor;

    @Column
    String lastNameAuthor;

    @Column
    Integer yearCreat;
}
