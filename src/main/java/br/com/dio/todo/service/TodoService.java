package br.com.dio.todo.service;

import br.com.dio.todo.domain.model.Todo;

import java.util.List;

public interface TodoService {

    public List<Todo> getAll();
    public Todo creted(Todo todo);
}
