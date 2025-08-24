package br.com.dio.todo.domain.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "tb_todos")
@Data
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "prioridade")
    private Prioridade prioridade;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;


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
