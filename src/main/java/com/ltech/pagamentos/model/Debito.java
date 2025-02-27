package com.ltech.pagamentos.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Debito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataCalculoDebito;

    private String observacoes;

    private BigDecimal valorDoDebitoInicial;

    private BigDecimal valorPago;

    private BigDecimal valorDoDebitoRestante;

    private int numParcelas;

    private int numParcelasPagas;

    private BigDecimal valorDaParcela;

    private Boolean acordo;

    private Boolean justiça;
}
