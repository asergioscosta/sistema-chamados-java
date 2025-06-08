package org.example.sistemachamados.chamado;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.example.sistemachamados.enums.StatusChamado;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String tituloChamado;

    @NotNull
    private String descricaoChamado;

    @NotNull
    private String dataAbertura;

    @NotNull
    private String dataAgendamento;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusChamado statusChamado;

}