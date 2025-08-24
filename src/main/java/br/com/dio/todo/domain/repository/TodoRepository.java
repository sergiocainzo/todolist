package br.com.dio.todo.domain.repository;

import br.com.dio.todo.domain.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {


}
