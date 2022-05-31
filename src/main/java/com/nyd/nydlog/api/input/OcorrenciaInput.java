package com.nyd.nydlog.api.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OcorrenciaInput {

    @NotBlank
    private String descricao;
}
