package com.ltech.pagamentos.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ltech.pagamentos.model.Student;
import com.ltech.pagamentos.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> recuperarTodos() {
        return this.studentRepository.findAll();
    }

    public void gravar(Student student) {
        this.studentRepository.save(student);
    }

    public Student recuperarPorId(Long id) {
        return this.studentRepository.findById(id).orElse(null);
    }

    public void deletarPorId(Long id) {
        this.studentRepository.deleteById(id);
    }

    public Page<Student> findByNameContainingIgnoreCase(String name, Pageable pageable) {
        return this.studentRepository.findByNameContainingIgnoreCase(name, pageable);
    }

}
