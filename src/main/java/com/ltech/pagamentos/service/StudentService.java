package com.ltech.pagamentos.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ltech.pagamentos.model.Student;
import com.ltech.pagamentos.padrao.ServiceCrud;
import com.ltech.pagamentos.repository.StudentRepository;

@Service
public class StudentService extends ServiceCrud<Student> {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    protected JpaRepository<Student, Long> getRepository() {
        return studentRepository;
    }

    public Page<Student> findByNameContainingIgnoreCase(String name, Pageable pageable) {
        return this.studentRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    public boolean jaExisteEmailCadastrado(String email) {
        return !this.studentRepository.findByEmailContainingIgnoreCase(email).isEmpty();
    }

}
