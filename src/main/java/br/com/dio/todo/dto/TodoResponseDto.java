package br.com.dio.todo.dto;

import br.com.dio.todo.domain.model.Todo;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoResponseDto {
    private Long id;
    private String nome;
    private String descricao;
    private String prioridade;
    private String estado;
    private LocalDateTime dataCriacao;

    public TodoResponseDto(Todo todo) {
        this.id = todo.getId();
        this.nome = todo.getNome();
        this.descricao = todo.getDescricao();
        this.prioridade = todo.getPrioridade() != null ? todo.getPrioridade().name().toLowerCase() : null;
        this.estado = todo.getEstado() != null ? todo.getEstado().name().toLowerCase() : null;
        this.dataCriacao = todo.getDataCriacao();
    }
}
