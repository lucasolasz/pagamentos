package com.ltech.pagamentos.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ltech.pagamentos.model.Student;
import com.ltech.pagamentos.padrao.CrudController;
import com.ltech.pagamentos.service.StudentService;
import com.ltech.pagamentos.util.MensagemUtil;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController extends CrudController<Student, StudentService> {

    public StudentController(StudentService studentService) {
        super("students", studentService);
    }

    @Override
    public String gravar(@Valid Student entity, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return this.getViewPathOperacaoInclusao();
        } else if (this.getService().jaExisteEmailCadastrado(entity.getEmail())) {
            MensagemUtil.adicionarMensagem(model, "Já existe cadastro para este email", MensagemUtil.COR_ALERTA);
            return this.getViewPathOperacaoInclusao();
        }
        return super.gravar(entity, result, model);
    }

}
