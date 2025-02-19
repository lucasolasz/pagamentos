package com.ltech.pagamentos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ltech.pagamentos.model.Condomino;

public interface CondominoRepository extends JpaRepository<Condomino, Long> {

    Page<Condomino> findByUnidadeCodUnidadeContainingIgnoreCase(String codigo, Pageable pageable);
}
