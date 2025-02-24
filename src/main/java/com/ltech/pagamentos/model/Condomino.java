package com.ltech.pagamentos.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Condomino {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    @JoinColumn(unique = true)
    private Unidade unidade;

    @NotEmpty(message = "{validation.notempty}")
    private String nomeCondomino;

    @Column(length = 5000)
    private String outrosResidentes;

    @NotNull(message = "{validation.notempty}")
    @ManyToOne
    private SituacaoCondomino situacaoCondomino;

    private boolean contratoDeGaveta;

    private String numContrato;

    @NotNull(message = "{validation.notempty}")
    @ManyToOne
    private Banco banco;

    @NotNull(message = "{validation.notempty}")
    private LocalDate dataNascimento;

    @NotEmpty(message = "{validation.notempty}")
    private String numIdentidade;

    @NotEmpty(message = "{validation.notempty}")
    private String cpf;

    private String telefone;

    private String celular;

    private String profissao;

    private String enderecoTrabalho;

    @NotEmpty(message = "{validation.notempty}")
    private String nomeProprietario;

    private String enderecoProprietario;

}
