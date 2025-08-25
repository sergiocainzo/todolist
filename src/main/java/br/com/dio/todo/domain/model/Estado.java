package br.com.dio.todo.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Estado {

    @JsonProperty("concluido")
    CONCLUIDO,
    @JsonProperty("em_atendimento")
    EM_ATENDIMENTO,
    @JsonProperty("em_analise")
    EM_ANALISE,
    @JsonProperty("registrado")
    REGISTRADO


}
