package com.challenge.alura.ChallengeAluraFinal.Controller;

import com.challenge.alura.ChallengeAluraFinal.Domain.Topico;
import com.challenge.alura.ChallengeAluraFinal.Domain.TopicoResponseDTO;
import com.challenge.alura.ChallengeAluraFinal.infra.TopicoCreateDTO;
import com.challenge.alura.ChallengeAluraFinal.infra.TopicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
@RequiredArgsConstructor
public class TopicoController {
    private final TopicoService topicoService;

    @PostMapping
    public ResponseEntity<TopicoResponseDTO> crear(@Valid @RequestBody TopicoCreateDTO dto) {
        Topico t = topicoService.crearTopico(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(TopicoResponseDTO.fromEntity(t));
    }

    @GetMapping
    public ResponseEntity<List<TopicoResponseDTO>> listar() {
        List<TopicoResponseDTO> lista = topicoService.listarTodos()
                .stream().map(TopicoResponseDTO::fromEntity).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoResponseDTO> detalle(@PathVariable Long id) {
        Topico t = topicoService.buscarPorId(id);
        return ResponseEntity.ok(TopicoResponseDTO.fromEntity(t));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicoResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody TopicoCreateDTO dto) {
        Topico t = topicoService.actualizar(id, dto);
        return ResponseEntity.ok(TopicoResponseDTO.fromEntity(t));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        topicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
