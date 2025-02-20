package com.ltech.pagamentos.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Condomino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(unique = true)
    private Unidade unidade;

    private String nomeCondomino;

    @Column(length = 5000)
    private String outrosResidentes;

    @ManyToOne
    private SituacaoCondomino situacaoCondomino;

    private boolean contratoDeGaveta;

    private String numContrato;

    @ManyToOne
    private Banco banco;

    private LocalDate dataNascimento;

    private String numIdentidade;

    private String cpf;

    private String telefone;

    private String celular;

    private String profissao;

    private String enderecoTrabalho;

    private String nomeProprietario;

    private String enderecoProprietario;

}
