package br.com.dio.todo.controller;

import br.com.dio.todo.domain.model.Todo;
import br.com.dio.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping("/welcome")
    public String getWelCome(){
        return "Welcome to my API - Todo List in Cloud";
    }


    @GetMapping("/listar")
    public List<Todo> getAll(){
        return service.getAll();
    }


    @PostMapping
    public ResponseEntity<Todo> createdTodo(@RequestBody Todo todo){
        var newTodo = service.creted(todo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newTodo.getId()).toUri();
        return ResponseEntity.ok().body(newTodo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Todo>> getOneById(@PathVariable Long id){
        var findOne = service.getOneById(id);
        return ResponseEntity.ok(findOne);
    }

    @PutMapping
    public ResponseEntity<Todo> updated(@PathVariable Long id,@RequestBody Todo todo){
        var todoEdit = service.updated(id,todo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todoEdit.getId()).toUri();
        return ResponseEntity.ok().body(todoEdit);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> removed(Long id){
        service.removed(id);
        return ResponseEntity.ok().body("Tarefa removida com sucesso!");
    }

}
