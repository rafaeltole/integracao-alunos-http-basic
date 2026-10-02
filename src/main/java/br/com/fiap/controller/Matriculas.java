package br.com.fiap.controller;

import br.com.fiap.dto.MatriculaRequest;
import br.com.fiap.dto.MatriculaResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/matriculas")
public class Matriculas {

    private AtomicLong sequence = new AtomicLong();
    private List<MatriculaResponse> matriculas = new ArrayList<>();

    @PostMapping
    public ResponseEntity<MatriculaResponse> cadastrar(@RequestBody @Valid MatriculaRequest request) {
        MatriculaResponse response = new MatriculaResponse(
                sequence.incrementAndGet(),
                request.alunoId(),
                request.turmaId());

        matriculas.add(response);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<MatriculaResponse>> consultar() {
        return ResponseEntity.ok(matriculas);
    }

}
