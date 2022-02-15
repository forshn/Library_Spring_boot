package ru.forsh.services.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/books") // все методы контроллера будут получать запросы с URI,
// который будет начинаться строкой, указанной в скобках аннотации
public class BookController {

    @GetMapping("/simple")
    public String simple(){
        return "Запрос Гет";
    }

}
