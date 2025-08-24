package br.com.dio.todo.service;

import br.com.dio.todo.domain.model.Todo;
import br.com.dio.todo.dto.TodoDto;
import br.com.dio.todo.dto.TodoResponseDto;

import java.util.List;
import java.util.Optional;

public interface TodoService {

     List<TodoResponseDto> getAllTodos();
     Todo create(TodoDto dto);
     TodoResponseDto getOneById(long id);
     Todo update(Long id, TodoDto dto);
     void remove(Long id);
}
