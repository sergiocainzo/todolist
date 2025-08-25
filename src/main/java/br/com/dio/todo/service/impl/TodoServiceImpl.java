package br.com.dio.todo.service.impl;

import br.com.dio.todo.domain.model.Todo;
import br.com.dio.todo.domain.repository.TodoRepository;
import br.com.dio.todo.dto.TodoDto;
import br.com.dio.todo.dto.TodoResponseDto;
import br.com.dio.todo.exceptions.TodoNotFoundException;
import br.com.dio.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository repository;

    @Override
    public List<TodoResponseDto> getAllTodos() {
        return repository.findAll().stream().map(TodoResponseDto::new).toList();
    }

    @Override
    public TodoResponseDto getOneById(long id) {
        Todo todo = repository.findById(id).orElseThrow(() -> new TodoNotFoundException(id));
        return new TodoResponseDto(todo);
    }

    @Override
    public Todo create(TodoDto dto) {
        Todo novo = new Todo(dto);
        return repository.save(novo);
    }


    @Override
    public Todo update(Long id, TodoDto dto) {
        Todo existente = repository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
        merge(existente, dto);
        return repository.save(existente);

    }

    @Override
    public void remove(Long id) {
        if (!repository.existsById(id)){
            throw new TodoNotFoundException(id);
        }
        repository.deleteById(id);
    }


    // Merge Todo para TodoDto
    private void merge(Todo existente, TodoDto dto){
        if (dto.getNome() != null) existente.setNome(dto.getNome());
        if (dto.getDescricao() != null) existente.setDescricao(dto.getDescricao());
        if (dto.getPrioridade() != null) existente.setPrioridade(dto.getPrioridade());
        if (dto.getEstado() != null) existente.setEstado(dto.getEstado());
    }
}
