package com.ltech.pagamentos.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numRecibo;

    @ManyToOne
    @JoinColumn(name = "unidade_id")
    private Unidade unidade;

    private LocalDate dataPagamento;

    @ManyToOne
    private Mes mesReferencia;

    private String anoReferencia;

    @ManyToOne
    private Usuario funcionarioRecebedor;

    private String numParcela;

    private BigDecimal valorDaParcela;

    private BigDecimal valorDaTaxa;

    private BigDecimal valorDaTaxaExtra;

    private BigDecimal valoresDiversos;

    private BigDecimal valorDaMulta;

    private BigDecimal valorDaMora;

    private BigDecimal valorDoDesconto;

    private BigDecimal valorDevido;

    @ManyToOne
    private FormaPagamento formaPagamento;

    private String numCheque;

    @ManyToOne
    private Banco banco;

    private LocalDate dataDepositoChequePreDatado;

    private Boolean reciboImpresso;
}
