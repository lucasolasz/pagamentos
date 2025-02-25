package com.ltech.pagamentos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ltech.pagamentos.model.Condomino;

public interface CondominoRepository extends JpaRepository<Condomino, Long> {

    Page<Condomino> findByUnidadeCodUnidadeContainingIgnoreCase(String codigo, Pageable pageable);

    @Query("SELECT m FROM Condomino m ORDER BY m.unidade.codUnidade ASC")
    Page<Condomino> findAllOrderByUnidadeCodUnidade(Pageable pageable);
}
