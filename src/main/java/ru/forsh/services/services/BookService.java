package ru.forsh.services.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.forsh.services.dto.BookDto;
import ru.forsh.services.entites.BookEntity;
import ru.forsh.services.entites.BookValueEntities;
import ru.forsh.services.entites.BookValueEntitiesAnnotation;
import ru.forsh.services.entites.BookValueEntitiesComparison;
import ru.forsh.services.repositories.BookRepository;
import ru.forsh.services.utils.MappingUtils;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookService {
    private final String SQL_COMPARISON = "select BOOKENTITY.id_book, BOOKENTITY.book_name, AUTHORENTITY.first_name, AUTHORENTITY.last_name,BOOKENTITY.creation_date from  " +
            "AUTHORENTITY left join BOOKENTITY on AUTHORENTITY.id_autor = BOOKENTITY.autor_id";

    private final String SQL_ANNOTATION = "select  BOOKENTITY.id_book as id_book_value, BOOKENTITY.book_name, AUTHORENTITY.first_name, AUTHORENTITY.last_name,BOOKENTITY.creation_date from  " +
            "AUTHORENTITY left join BOOKENTITY on AUTHORENTITY.id_author = BOOKENTITY.author_id";

    private final String packaging = "Всё в лучем виде!)";

    private final Integer price = 100_000;

    private final MappingUtils mappingUtils;

    private final EntityManager entityManager;

    private final BookRepository repository;

    public void pack(List<BookDto> bookDtos){
        bookDtos.forEach(book -> book.setPackaging(packaging));
    }

    public void setPrice(List<BookDto> bookDtos){
        bookDtos.forEach(book -> book.setPrice(price));
    }

    public void saveAll(List<BookEntity> bookEntities) {
        repository.saveAll(bookEntities);
    }

    public void save(BookEntity book) {
        repository.save(book);
    }

    /*public List<BookEntity> findAll() {
        return repository.findAll();
    }*/

    public List<String> joinBookString(){
        return repository.joinBookString();
    }

    public List<Object[]> joinBookObj(){
        return repository.joinBookObj();
    }

    public List<BookDto> findAll(){
        return repository
                .findAll()
                .stream()
                .map(MappingUtils::mapToBookDto)
                .collect(Collectors.toList());
    }

    public BookDto findById(Integer id){
        return MappingUtils.mapToBookDto(repository.findById(id).orElse(new BookEntity()));
    }



    public List<BookValueEntitiesAnnotation> bookValueEntitiesAnnotationList() {
        return entityManager//как и в прошлый раз зовем начальника
                .createNativeQuery(//давай нам чистый SQL запрос
                        SQL_ANNOTATION,//вот тебе текст запроса
                        "BookValueMapping")//вот тебе имя нашего маппинга
                .getResultList();//и как обычно заверни нам в лист!!! Ты еще тут?
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
