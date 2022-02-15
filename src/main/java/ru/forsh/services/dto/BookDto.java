package ru.forsh.services.dto;

import lombok.Data;

@Data
public class BookDto {
    private Integer id;
    private String nameBook;
    private String packaging;
    private Integer price;
}
