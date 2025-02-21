package com.ltech.pagamentos.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ltech.pagamentos.model.Student;
import com.ltech.pagamentos.padrao.ServiceCrud;
import com.ltech.pagamentos.repository.StudentRepository;

@Service
public class StudentService extends ServiceCrud<Student, Long, StudentRepository> {

    public StudentService(StudentRepository repository) {
        super(repository);
    }

    public Page<Student> findByNameContainingIgnoreCase(String name, Pageable pageable) {
        return this.getRepository().findByNameContainingIgnoreCase(name, pageable);
    }

    public boolean jaExisteEmailCadastrado(String email) {
        return !this.getRepository().findByEmailContainingIgnoreCase(email).isEmpty();
    }

}
