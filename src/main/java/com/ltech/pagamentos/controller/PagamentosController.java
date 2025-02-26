package com.ltech.pagamentos.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ltech.pagamentos.model.Pagamento;
import com.ltech.pagamentos.padrao.CrudController;
import com.ltech.pagamentos.service.MesService;
import com.ltech.pagamentos.service.PagamentoService;
import com.ltech.pagamentos.service.UnidadeService;
import com.ltech.pagamentos.service.UsuarioService;
import com.ltech.pagamentos.util.DataUtil;

@Controller
@RequestMapping("/pagamentos")
public class PagamentosController extends CrudController<Pagamento, Long, PagamentoService> {

    private final UnidadeService unidadeService;
    private final MesService mesService;
    private final UsuarioService usuarioService;

    public PagamentosController(PagamentoService pagamentoService, UnidadeService unidadeService,
            MesService mesService, UsuarioService usuarioService) {
        super("pagamentos", pagamentoService, "Pagamentos");
        this.unidadeService = unidadeService;
        this.mesService = mesService;
        this.usuarioService = usuarioService;
    }

    @Override
    public void preCarregarAtributosObjeto(Pagamento entity) {
        entity.setDataPagamento(LocalDate.now());
        entity.setAnoReferencia(DataUtil.getAnoNowString());
        entity.setMesReferencia(mesService.recuperarPorId(Long.valueOf(DataUtil.getMesAtual())).orElse(null));
        // entity.setFuncionarioRecebedor(this.getUsuarioLogin());
    }

    @Override
    public void cargaAuxiliarObjetos(Model model) {
        model.addAttribute("listaUnidades", unidadeService.recuperarTodos());
        model.addAttribute("listaMeses", mesService.recuperarTodos());
        model.addAttribute("listaUsuarios", usuarioService.recuperarTodos());
    }
}
