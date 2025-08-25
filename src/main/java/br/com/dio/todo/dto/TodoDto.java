package br.com.dio.todo.dto;

import br.com.dio.todo.domain.model.Estado;
import br.com.dio.todo.domain.model.Prioridade;
import br.com.dio.todo.domain.model.Todo;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {


    private String nome;

    private String descricao;

    private Prioridade prioridade;
    private Estado estado;

    public TodoDto(Todo todo) {
        this.nome = todo.getNome();
        this.descricao = todo.getDescricao();
        this.prioridade = todo.getPrioridade();
        this.estado = todo.getEstado();
    }

}
