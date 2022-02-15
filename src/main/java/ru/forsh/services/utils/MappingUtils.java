package ru.forsh.services.utils;

import org.springframework.stereotype.Service;
import ru.forsh.services.dto.BookDto;
import ru.forsh.services.entites.BookEntity;

@Service
public class MappingUtils {

    public static BookDto mapToBookDto(BookEntity book){
        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setNameBook(book.getNameBook());
        return dto;
    }

    public BookEntity mapToBookEntityFromDto(BookDto bookDto){
        BookEntity book = new BookEntity();
        book.setId(bookDto.getId());
        book.setNameBook(bookDto.getNameBook());
        return book;
    }
}
