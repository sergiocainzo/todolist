package br.com.dio.todo.dto;

import br.com.dio.todo.domain.model.Estado;
import br.com.dio.todo.domain.model.Prioridade;
import lombok.Data;

@Data
public class TodoDto {

    private String nome;
    private String descricao;
    private Prioridade prioridade;
    private Estado estado;

}
