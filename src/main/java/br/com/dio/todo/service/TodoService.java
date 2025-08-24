package br.com.dio.todo.service;

import br.com.dio.todo.domain.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {

     List<Todo> getAll();
     Todo create(Todo todo);
     Optional<Todo> getOneById(long id);
     Optional<Todo> update(Long id, Todo todo);
     void remove(Long id);
}
