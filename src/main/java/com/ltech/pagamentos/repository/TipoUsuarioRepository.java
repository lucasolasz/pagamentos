package com.ltech.pagamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltech.pagamentos.model.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {

}
