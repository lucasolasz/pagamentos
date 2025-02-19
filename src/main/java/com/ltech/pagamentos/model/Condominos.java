package com.ltech.pagamentos.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Condominos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String codUnidade;

    private String nomeCondomino;

    @Column(length = 1000)
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

    private String profisao;

    private String enderecoTrabalho;

    private String nomeProprietário;

    private String enderecoProprietario;

}
