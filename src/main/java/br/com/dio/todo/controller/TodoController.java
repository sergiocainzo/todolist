package br.com.dio.todo.controller;

import br.com.dio.todo.domain.model.Todo;
import br.com.dio.todo.dto.TodoDto;
import br.com.dio.todo.dto.TodoResponseDto;
import br.com.dio.todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping("/welcome")
    public String getWelCome(){
        return "Welcome to my API - Todo List in Cloud";
    }

    @GetMapping("/status")
    public String status(){
        return "Running branch: feat-homo";
    }

    @GetMapping
    public List<TodoResponseDto> getAllTodos(){
        return service.getAllTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> getOneById(@PathVariable Long id){
        TodoResponseDto encontrado = service.getOneById(id);
        return ResponseEntity.ok(encontrado);
    }

    @PostMapping
    public ResponseEntity<TodoResponseDto> createdTodo(@RequestBody @Valid TodoDto dto){
        Todo novoTodo = service.create(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoTodo.getId()).toUri();
        return ResponseEntity.created(location).body(new TodoResponseDto(novoTodo));
    }


    @PutMapping("/{id}")
    public ResponseEntity<TodoResponseDto> updated(@PathVariable Long id, @RequestBody @Valid TodoDto dto){
        Todo atualizado = service.update(id,dto);
        return ResponseEntity.ok(new TodoResponseDto(atualizado));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removed(@PathVariable Long id){
        service.remove(id);
        return ResponseEntity.noContent().build();
    }

}
