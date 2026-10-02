package br.com.fiap.dto;

import jakarta.validation.constraints.NotNull;

public record MatriculaRequest(
        @NotNull(message = "O código do aluno deve ser informado.") Long alunoId,
        @NotNull(message = "O código da turma deve ser informado.") Long turmaId) {
}
