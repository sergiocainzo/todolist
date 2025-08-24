package br.com.dio.todo.service.impl;

import br.com.dio.todo.domain.model.Todo;
import br.com.dio.todo.domain.repository.TodoRepository;
import br.com.dio.todo.dto.TodoDto;
import br.com.dio.todo.exceptions.GlobalExceptionHandler;
import br.com.dio.todo.exceptions.TodoNotFoundException;
import br.com.dio.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository repository;

    @Override
    public List<Todo> getAll() {
        return repository.findAll();
    }

    @Override
    public Todo create(Todo todo) {
        return repository.save(todo);
    }

    @Override
    public Optional<Todo> getOneById(long id) {
        return repository.findById(id);
    }

    @Override
    public Todo update(Long id, TodoDto dto) {
        Todo existente = repository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
        if (dto.getNome() != null) existente.setNome(dto.getNome());
        if (dto.getDescricao() != null) existente.setDescricao(dto.getDescricao());
        if (dto.getPrioridade() != null) existente.setPrioridade(dto.getPrioridade());
        if (dto.getEstado() != null) existente.setEstado(dto.getEstado());

        return repository.save(existente);

    }

    @Override
    public void remove(Long id) {
        if (!repository.existsById(id)){
            throw new TodoNotFoundException(id);
        }
        repository.deleteById(id);
    }

}
