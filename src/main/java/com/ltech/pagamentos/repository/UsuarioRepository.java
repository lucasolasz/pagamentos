package com.ltech.pagamentos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltech.pagamentos.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);

    boolean existsByUsername(String username);
}
