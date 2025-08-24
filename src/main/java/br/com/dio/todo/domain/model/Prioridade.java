package br.com.dio.todo.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Prioridade {

    @JsonProperty("alta")
    ALTA,
    @JsonProperty("media")
    MEDIA,
    @JsonProperty("baixa")
    BAIXA

}
