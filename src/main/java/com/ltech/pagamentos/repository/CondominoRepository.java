package com.ltech.pagamentos.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ltech.pagamentos.model.Condomino;

public interface CondominoRepository extends JpaRepository<Condomino, UUID> {

    Page<Condomino> findByUnidadeCodUnidadeContainingIgnoreCase(String codigo, Pageable pageable);
}
