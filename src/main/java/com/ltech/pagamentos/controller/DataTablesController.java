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

import com.ltech.pagamentos.model.Student;
import com.ltech.pagamentos.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class DataTablesController {

    private final StudentRepository studentRepository;

    public DataTablesController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
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
}
