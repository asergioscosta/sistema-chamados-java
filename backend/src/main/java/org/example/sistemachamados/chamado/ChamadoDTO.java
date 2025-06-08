package org.example.sistemachamados.chamado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.sistemachamados.enums.StatusChamado;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChamadoDTO {

    private Long id;
    private String tituloChamado;
    private String descricaoChamado;
    private String dataAbertura;
    private String dataAgendamento;
    private StatusChamado statusChamado;

    public static ChamadoDTO create(Chamado chamado) {
        ModelMapper modelMapper = new ModelMapper();
        ChamadoDTO dto = modelMapper.map(chamado, ChamadoDTO.class);
        dto.setId(chamado.getId());
        dto.setTituloChamado(chamado.getTituloChamado());
        dto.setDescricaoChamado(chamado.getDescricaoChamado());
        dto.setDataAbertura(chamado.getDataAbertura());
        dto.setDataAgendamento(chamado.getDataAgendamento());
        dto.setStatusChamado(chamado.getStatusChamado());
        return dto;
    }
}