package com.challenge.alura.ChallengeAluraFinal.infra;

import com.challenge.alura.ChallengeAluraFinal.Domain.Topico;
import com.challenge.alura.ChallengeAluraFinal.Domain.TopicoRepository;
import com.challenge.alura.ChallengeAluraFinal.Domain.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TopicoService {
    private final TopicoRepository topicoRepo;
    private final UsuarioRepository usuarioRepo;
    private final CursoRepository cursoRepo;

    public Topico crearTopico(TopicoCreateDTO dto) {
        if(topicoRepo.existsByTituloAndMensaje(dto.titulo(), dto.mensaje()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tópico duplicado");

        Usuario autor = usuarioRepo.findById(dto.autorId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Autor no encontrado"));

        Curso curso = null;
        if(dto.cursoId() != null) {
            curso = cursoRepo.findById(dto.cursoId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Curso no encontrado"));
        }

        Topico topico = new Topico();
        topico.setTitulo(dto.titulo());
        topico.setMensaje(dto.mensaje());
        topico.setAutor(autor);
        topico.setCurso(curso);
        topico.setStatus("NO_RESPONDIDO");
        topico.setFechaCreacion(LocalDateTime.now());

        return topicoRepo.save(topico);
    }

    // Métodos: listarTodos(), buscarPorId(), actualizar(id, dto), eliminar(id) — seguir misma lógica de validaciones
}
