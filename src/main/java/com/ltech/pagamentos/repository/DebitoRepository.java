package com.ltech.pagamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltech.pagamentos.model.Debito;

public interface DebitoRepository extends JpaRepository<Debito, Long> {

}
