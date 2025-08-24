package br.com.dio.todo.service;

import br.com.dio.todo.domain.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    public List<Todo> getAll();
    public Todo creted(Todo todo);
    public Optional<Todo> getOneById(long id);
    public Todo updated(Long id, Todo todo);
    public void removed(Long id);
}
