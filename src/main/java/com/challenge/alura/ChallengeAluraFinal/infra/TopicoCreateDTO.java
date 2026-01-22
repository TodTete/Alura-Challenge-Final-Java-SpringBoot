package com.challenge.alura.ChallengeAluraFinal.infra;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicoCreateDTO(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull Long autorId,
        Long cursoId
) {}