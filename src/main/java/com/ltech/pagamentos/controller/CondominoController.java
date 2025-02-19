package com.ltech.pagamentos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ltech.pagamentos.model.Condomino;
import com.ltech.pagamentos.padrao.CrudController;
import com.ltech.pagamentos.service.CondominoService;

@Controller
@RequestMapping("/condominos")
public class CondominoController extends CrudController<Condomino, CondominoService> {

    public CondominoController(CondominoService condominoService) {
        super("condominos", condominoService);
    }
}
