package com.ltech.pagamentos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ltech.pagamentos.model.Student;
import com.ltech.pagamentos.padrao.CrudController;
import com.ltech.pagamentos.service.StudentService;
import com.ltech.pagamentos.util.MensagemUtil;

@Controller
@RequestMapping("/students")
public class StudentController extends CrudController<Student, Long, StudentService> {

    public StudentController(StudentService studentService) {
        super("students", studentService, "Estudantes");
    }

    @Override
    protected boolean validarAntesDeGravar(Student entity, BindingResult result, Model model) {
        if (!super.validarAntesDeGravar(entity, result, model)) {
            return false;
        }

        if (this.getService().jaExisteEmailCadastrado(entity.getEmail())) {
            MensagemUtil.adicionarMensagem(model, "Já existe cadastro para este email", MensagemUtil.COR_ALERTA);
            return false;
        }

        return true;
    }

}
