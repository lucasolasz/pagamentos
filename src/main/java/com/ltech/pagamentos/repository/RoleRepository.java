package com.ltech.pagamentos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltech.pagamentos.model.Roles;

public interface RoleRepository extends JpaRepository<Roles, Long> {

    List<Roles> findByName(String name);
}
