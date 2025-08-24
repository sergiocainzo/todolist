package br.com.dio.todo.service.impl;

import br.com.dio.todo.domain.model.Todo;
import br.com.dio.todo.domain.repository.TodoRepository;
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
    public Todo update(Long id, Todo todo) {
        return repository.findById(id)
                .map(existing -> {
                   existing.setNome(todo.getNome());
                   existing.setDescricao(todo.getDescricao());
                   existing.setPrioridade(todo.getPrioridade());
                   existing.setEstado(todo.getEstado());
                   return repository.save(existing);
        })
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    @Override
    public void remove(Long id) {
        if (!repository.existsById(id)){
            throw new TodoNotFoundException(id);
        }
        repository.deleteById(id);
    }

}
