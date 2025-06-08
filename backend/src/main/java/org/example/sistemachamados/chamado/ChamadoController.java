package org.example.sistemachamados.chamado;

import lombok.RequiredArgsConstructor;
import org.example.sistemachamados.exception.RegraNegocioException;
import org.example.sistemachamados.usuario.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/chamados")
@RequiredArgsConstructor
@CrossOrigin
public class ChamadoController {

    private final ChamadoService chamadoService;

    @GetMapping()
    public ResponseEntity get() {
        List<Chamado> chamados = chamadoService.getChamados();
        return ResponseEntity.ok(chamados.stream().map(ChamadoDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<Chamado> chamado = chamadoService.getChamadoById(id);
        if (!chamado.isPresent()) {
            return new ResponseEntity("Chamado não encontrado", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(chamado.map(ChamadoDTO::create));
    }

    @PostMapping()
    public ResponseEntity post(@RequestBody ChamadoDTO dto) {
        try {
            Chamado chamado = converter(dto);
            chamado = chamadoService.save(chamado);
            return new ResponseEntity(chamado, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity atualizar(@PathVariable("id") Long id, @RequestBody ChamadoDTO dto) {
        Optional<Chamado> ChamadoExistente = chamadoService.getChamadoById(id);
        if (!ChamadoExistente.isPresent()) {
            return new ResponseEntity("Chamado não encontrado", HttpStatus.NOT_FOUND);
        }
        try {
            Chamado chamado = ChamadoExistente.get();
            if (dto.getTituloChamado() != null) {
                chamado.setTituloChamado(dto.getTituloChamado());
            }
            if (dto.getDescricaoChamado() != null) {
                chamado.setDescricaoChamado(dto.getDescricaoChamado());
            }
            if (dto.getDataAbertura() != null) {
                chamado.setDataAbertura(dto.getDataAbertura());
            }
            if (dto.getDataAgendamento() != null) {
                chamado.setDataAgendamento(dto.getDataAgendamento());
            }
            if (dto.getStatusChamado() != null) {
                chamado.setStatusChamado(dto.getStatusChamado());
            }
            Chamado chamadoAtualizada = chamadoService.save(chamado);
            return ResponseEntity.ok(chamadoAtualizada);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity excluir(@PathVariable("id") Long id) {
        Optional<Chamado> chamado = chamadoService.getChamadoById(id);
        if (!chamado.isPresent()) {
            return new ResponseEntity("Chamado não encontrada", HttpStatus.NOT_FOUND);
        }
        try {
            chamadoService.delete(chamado.get());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private Chamado converter(ChamadoDTO dto) {
        Chamado chamado = new Chamado();
        chamado.setId(dto.getId());
        chamado.setTituloChamado(dto.getTituloChamado());
        chamado.setDescricaoChamado(dto.getDescricaoChamado());
        chamado.setDataAbertura(dto.getDataAbertura());
        chamado.setDataAgendamento(dto.getDataAgendamento());
        chamado.setStatusChamado(dto.getStatusChamado());

        if(dto.getCliente() != null) {
            Usuario cliente = new Usuario();
            cliente.setId(dto.getCliente().getId());
            chamado.setCliente(cliente);
        }
        if(dto.getTecnico() != null) {
            Usuario tecnico = new Usuario();
            tecnico.setId(dto.getTecnico().getId());
            chamado.setTecnico(tecnico);
        }
        return chamado;
    }
}