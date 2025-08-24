package br.com.dio.todo.service;

import br.com.dio.todo.domain.model.Todo;
import br.com.dio.todo.dto.TodoDto;

import java.util.List;
import java.util.Optional;

public interface TodoService {

     List<Todo> getAll();
     Todo create(Todo todo);
     Optional<Todo> getOneById(long id);
     Todo update(Long id, TodoDto dto);
     void remove(Long id);
}
