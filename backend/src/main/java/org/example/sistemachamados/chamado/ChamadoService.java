package org.example.sistemachamados.chamado;

import jakarta.transaction.Transactional;
import org.example.sistemachamados.exception.RegraNegocioException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ChamadoService {

    private ChamadoRepository chamadoRepository;

    public ChamadoService(ChamadoRepository chamadoRepository) {
        this.chamadoRepository = chamadoRepository;
    }

    public List<Chamado> getChamados() {
        return chamadoRepository.findAll();
    }

    public Optional<Chamado> getChamadoById(Long id) {
        return chamadoRepository.findById(id);
    }

    public List<Chamado> getChamadosByIds(List<Long> ids) {
        return chamadoRepository.findAllById(ids);
    }

    @Transactional
    public Chamado save(Chamado chamado) {
        validar(chamado);
        return chamadoRepository.save(chamado);
    }

    @Transactional
    public void delete(Chamado oficina) {
        Objects.requireNonNull(oficina.getId());
        chamadoRepository.delete(oficina);
    }

    public void validar(Chamado chamado) {
        Objects.requireNonNull(chamado, "Oficina não pode ser nula");

        if (chamado.getTituloChamado() == null || chamado.getTituloChamado().trim().isEmpty()) {
            throw new RegraNegocioException("Nome do chamado é obrigatório.");
        }

        if (chamado.getDescricaoChamado() == null || chamado.getDescricaoChamado().trim().isEmpty()) {
            throw new RegraNegocioException("Descrição do chamado é obrigatória.");
        }

        if (chamado.getDataAbertura() == null || chamado.getDataAbertura().trim().isEmpty()) {
            throw new RegraNegocioException("Data de abertura do chamado é obrigatória.");
        }

        if (chamado.getDataAgendamento() == null || chamado.getDataAgendamento().trim().isEmpty()) {
            throw new RegraNegocioException("Data de agendamento do chamado é obrigatória.");
        }

        if (chamado.getStatusChamado() == null) {
            throw new RegraNegocioException("Status do Chamado é inválido");
        }
    }
}