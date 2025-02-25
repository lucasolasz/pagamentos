package com.ltech.pagamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltech.pagamentos.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}
