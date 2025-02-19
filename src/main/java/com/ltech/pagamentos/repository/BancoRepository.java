package com.ltech.pagamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltech.pagamentos.model.Banco;

public interface BancoRepository extends JpaRepository<Banco, Long> {

}
