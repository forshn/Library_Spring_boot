package ru.forsh.services.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.forsh.services.entites.BookEntity;
import ru.forsh.services.entites.BookValueEntities;
import ru.forsh.services.entites.BookValueEntitiesComparison;
import ru.forsh.services.repositories.BookRepository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {
    private final String SQL_COMPARISON = "select BOOKENTITY.id_book, BOOKENTITY.book_name, AUTHORENTITY.first_name, AUTHORENTITY.last_name,BOOKENTITY.creation_date from  " +
            "AUTHORENTITY left join BOOKENTITY on AUTHORENTITY.id_autor = BOOKENTITY.autor_id";

    private final EntityManager entityManager;

    private final BookRepository repository;

    public void saveAll(List<BookEntity> bookEntities) {
        repository.saveAll(bookEntities);
    }

    public void save(BookEntity book) {
        repository.save(book);
    }

    public List<BookEntity> findAll() {
        return repository.findAll();
    }

    public List<String> joinBookString(){
        return repository.joinBookString();
    }

    public List<Object[]> joinBookObj(){
        return repository.joinBookObj();
    }

    public List<BookValueEntitiesComparison> bookValueEntitiesComparisonList() {
        return entityManager //зовем менеджера и начинаем ему указывать
                .createNativeQuery(//для начала создай пожалуйста "чистый"(native) SQL запрос
                        SQL_COMPARISON,//из этой строковой переменной возьми запрос
                        BookValueEntitiesComparison.class)// ответ замаппить в этот класс
                .getResultList();//а результат мне заверни в лист!!! И побыстрее!!!Шнеля, шнеля!!!
    }

    public List<BookValueEntities> bookValueEntitiesList(){
        List<Object[]> objects = repository.joinBookObj();

        List<BookValueEntities> bookValueEntities = new ArrayList<>();//создадим лист конечных объектов

        objects//берем переменную типа List<Object[]> (Лист массивов Object-ов), с ответом БД
                .stream()//превращаем Лист, состоящий из массивов Object-ов в стрим
                .forEach(//фор ич - терминальный оператор, выполняет указанное действие для каждого элемента стрима
                        //дальше идет лямбда, она говорит фор ичу - что делать для каждого элемента стрима
                        (obj) ->//объявляем(называем) переменную "obj" ей будут присваиваться объекты стрима (массивы Object-ов)
                        {//так как запись в лямбде у нас в несколько строк, ставим {}
                            bookValueEntities.add(//фор ич возмет "obj" и добавит в List<BookValue>, предварительно сделав маппинг
                                    new BookValueEntities()//создаем объект BookValueEntities
                                            //ниже происходит собственно маппинг
                                            //поля(элементы) "obj" записываются в соответсвующие поля созданного BookValueEntities
                                            //так как поле "obj" имеет тип Object  необходимо его привести к типу поля объекта BookValueEntities т.е. String
                                            .setNameBook((String) obj[0])//записываем данные из одного поля в другое, [0] - значит первый элемент в массиве Object-ов
                                            //так как поле "obj" имеет тип Object  необходимо его привести к типу поля объекта BookValue т.е. String
                                            .setFirstNameAutor((String) obj[1])//записываем данные из одного поля в другое, [1] - значит второй элемент в массиве Object-ов
                                            //так как поле "obj" имеет тип Object  необходимо его привести к типу поля объекта BookValue т.е. String
                                            .setLastNameAutor((String) obj[2])//записываем данные из одного поля в другое, [2] - значит третий элемент в массиве Object-ов
                                            //так как поле "obj" имеет тип Object  необходимо его привести к типу поля объекта BookValue т.е. Integer
                                            .setYearCreat((Integer) obj[3])//записываем данные из одного поля в другое, [3] - значит четвертый элемент в массиве Object-ов
                            );
                        }
                );
        return bookValueEntities;
    }

}
