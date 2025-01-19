package com.ltech.pagamentos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ltech.pagamentos.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Page<Student> findByNameContains(String name, Pageable pageable);

}
