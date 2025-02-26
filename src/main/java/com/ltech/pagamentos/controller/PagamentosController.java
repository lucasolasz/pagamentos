package com.ltech.pagamentos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ltech.pagamentos.model.Pagamento;
import com.ltech.pagamentos.padrao.CrudController;
import com.ltech.pagamentos.service.PagamentoService;
import com.ltech.pagamentos.service.UnidadeService;

@Controller
@RequestMapping("/pagamentos")
public class PagamentosController extends CrudController<Pagamento, Long, PagamentoService> {

    private final UnidadeService unidadeService;
    // private final SituacaoCondominoService situacaoCondominoService;

    public PagamentosController(PagamentoService pagamentoService, UnidadeService unidadeService) {
        super("pagamentos", pagamentoService, "Pagamentos");
        this.unidadeService = unidadeService;
    }

    @Override
    public void cargaAuxiliarObjetos(Model model) {
        model.addAttribute("listaUnidades", unidadeService.recuperarTodos());
    }
}
