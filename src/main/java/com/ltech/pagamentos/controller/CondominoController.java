package com.ltech.pagamentos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ltech.pagamentos.model.Condomino;
import com.ltech.pagamentos.padrao.CrudController;
import com.ltech.pagamentos.service.BancoService;
import com.ltech.pagamentos.service.CondominoService;
import com.ltech.pagamentos.service.SituacaoCondominoService;

@Controller
@RequestMapping("/condominos")
public class CondominoController extends CrudController<Condomino, Long, CondominoService> {

    private final BancoService bancoService;
    private final SituacaoCondominoService situacaoCondominoService;

    public CondominoController(CondominoService condominoService, BancoService bancoService,
            SituacaoCondominoService situacaoCondominoService) {
        super("condominos", condominoService, "Condôminos");
        this.bancoService = bancoService;
        this.situacaoCondominoService = situacaoCondominoService;
    }

    @Override
    public void cargaAuxiliarObjetos(Model model) {
        model.addAttribute("listaBancos", bancoService.recuperarTodos());
        model.addAttribute("listaSituacaoCondomino", situacaoCondominoService.recuperarTodos());
    }
}
