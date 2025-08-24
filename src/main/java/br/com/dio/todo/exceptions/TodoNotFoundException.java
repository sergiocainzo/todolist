package br.com.dio.todo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TodoNotFoundException extends RuntimeException{

    public TodoNotFoundException(Long id){
        super("Tarefa com ID "+id+ " não localizada.");
    }
}
