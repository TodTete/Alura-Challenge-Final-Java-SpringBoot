package com.challenge.alura.ChallengeAluraFinal.infra;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
        @NotBlank String username,
        @NotBlank String password
) {}