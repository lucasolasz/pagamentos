package com.ltech.pagamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltech.pagamentos.model.FormaPagamento;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {

}
