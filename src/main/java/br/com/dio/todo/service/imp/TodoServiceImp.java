package br.com.dio.todo.service.imp;

import br.com.dio.todo.domain.model.Todo;
import br.com.dio.todo.domain.repository.TodoRepository;
import br.com.dio.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImp implements TodoService {

    @Autowired
    private TodoRepository repository;

    @Override
    public List<Todo> getAll() {
        return repository.findAll();
    }

    @Override
    public Todo creted(Todo todo) {
        return repository.save(todo);
    }

    @Override
    public Optional<Todo> getOneById(long id) {
        return repository.findById(id);
    }

}
