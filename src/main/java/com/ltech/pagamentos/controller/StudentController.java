package com.ltech.pagamentos.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ltech.pagamentos.model.Student;
import com.ltech.pagamentos.service.StudentService;

import jakarta.validation.Valid;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String index(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "") String search,
            Model model) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Student> studentsPage = this.studentService.findByNameContainingIgnoreCase(search, pageable);

        model.addAttribute("students", studentsPage.getContent());
        model.addAttribute("totalPages", studentsPage.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("search", search);

        return "students/visualizar";

    }

    @GetMapping("/novo")
    public String novoEstudante(Model model) {
        model.addAttribute("student", new Student());
        return "students/cadastrar";
    }

    @PostMapping("/gravar")
    public String salvarEstudante(@Valid @ModelAttribute Student student, BindingResult result) {

        if (result.hasErrors()) {
            return "students/cadastrar";
        }

        this.studentService.gravar(student);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editarEstudante(@PathVariable("id") Long id, Model model) {
        Student student = this.studentService.recuperarPorId(id);
        model.addAttribute("student", student);
        return "students/cadastrar";
    }

    @GetMapping("/deletar/{id}")
    public String editarEstudante(@PathVariable("id") Long id) {
        this.studentService.deletarPorId(id);
        return "redirect:/";
    }

}
