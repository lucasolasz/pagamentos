package com.ltech.pagamentos.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ltech.pagamentos.model.Condomino;
import com.ltech.pagamentos.model.Student;
import com.ltech.pagamentos.repository.CondominoRepository;
import com.ltech.pagamentos.repository.StudentRepository;

@RestController
@RequestMapping("/dataTable")
public class DataTablesController {

    private final StudentRepository studentRepository;

    private final CondominoRepository condominoRepository;

    public DataTablesController(StudentRepository studentRepository, CondominoRepository condominoRepository) {
        this.studentRepository = studentRepository;
        this.condominoRepository = condominoRepository;
    }

    @GetMapping("/students")
    public Map<String, Object> getStudents(@RequestParam int draw, @RequestParam int start, @RequestParam int length,
            @RequestParam(value = "search[value]", required = false) String searchValue) {

        int page = start / length;
        Pageable pageable = PageRequest.of(page, length);

        Page<Student> studentPage;
        if (searchValue != null && !searchValue.isEmpty()) {
            studentPage = studentRepository.findByNameContainingIgnoreCase(searchValue, pageable);
        } else {
            studentPage = studentRepository.findAll(pageable);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("draw", draw);
        response.put("recordsTotal", studentRepository.count());
        response.put("recordsFiltered", studentPage.getTotalElements());
        response.put("data", studentPage.getContent());

        return response;
    }

    @GetMapping("/condominos")
    public Map<String, Object> getCondominos(@RequestParam int draw, @RequestParam int start, @RequestParam int length,
            @RequestParam(value = "search[value]", required = false) String searchValue) {

        int page = start / length;
        Pageable pageable = PageRequest.of(page, length);

        Page<Condomino> objPage;
        if (searchValue != null && !searchValue.isEmpty()) {
            objPage = condominoRepository.findByUnidadeCodUnidadeContainingIgnoreCase(searchValue, pageable);
        } else {
            objPage = condominoRepository.findAllOrderByUnidadeCodUnidade(pageable);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("draw", draw);
        response.put("recordsTotal", condominoRepository.count());
        response.put("recordsFiltered", objPage.getTotalElements());
        response.put("data", objPage.getContent());

        return response;
    }
}
