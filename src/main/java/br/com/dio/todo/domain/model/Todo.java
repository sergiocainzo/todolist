package br.com.dio.todo.domain.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tb_id")
    private Long id;

    @Column(name = "tb_nome", nullable = false)
    private String nome;

    @Column(name = "tb_descricao", nullable = false)
    private String descricao;

    @Column(name = "tb_prioridade")
    private Prioridade prioridade;

    @Column(name = "tb_estado")
    private Estado estado;

    @Column(name = "tb_dataCriacao")
    private Date dataCriacao;

    public Todo(){
        this.estado = Estado.REGISTRADO;
        this.prioridade=Prioridade.MEDIA;
        this.dataCriacao = new Date();
    }
}
