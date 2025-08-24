package br.com.dio.todo.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Estado {

    @JsonProperty("finalizada")
    FINALIZADA,
    @JsonProperty("em_andamento")
    EM_ANDAMENTO,
    @JsonProperty("em_analise")
    EM_ANALISE,
    @JsonProperty("registrada")
    REGISTRADA


}
