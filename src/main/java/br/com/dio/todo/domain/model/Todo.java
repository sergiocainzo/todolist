package br.com.dio.todo.domain.model;


import br.com.dio.todo.dto.TodoDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "tb_todos_homo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "prioridade")
    private Prioridade prioridade;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;


    public Todo(TodoDto dto){
        this.nome = dto.getNome();
        this.descricao = dto.getDescricao();
        this.prioridade = dto.getPrioridade();
        this.estado = dto.getEstado();
    }


    @PrePersist
    protected void onCreate(){
        if (this.estado == null){
            this.estado = Estado.REGISTRADA;
        }
        if (this.prioridade == null){
            this.prioridade = Prioridade.MEDIA;
        }
        this.dataCriacao=LocalDateTime.now();
    }

}
