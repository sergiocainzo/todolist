package br.com.dio.todo.controller;

import br.com.dio.todo.domain.model.Todo;
import br.com.dio.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping()
    public String getWelCome(){
        return "Welcome to my API - Todo List in Cloud";
    }


    @GetMapping("/listagem")
    public List<Todo> getAll(){
        return service.getAll();
    }




}
