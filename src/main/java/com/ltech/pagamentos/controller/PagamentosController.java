package com.ltech.pagamentos.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ltech.pagamentos.model.Pagamento;
import com.ltech.pagamentos.padrao.CrudController;
import com.ltech.pagamentos.security.UsuarioAutenticadoProvider;
import com.ltech.pagamentos.service.BancoService;
import com.ltech.pagamentos.service.CondominoService;
import com.ltech.pagamentos.service.FormaPagamentoService;
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
    private final UsuarioAutenticadoProvider usuarioAutenticadoProvider;
    private final FormaPagamentoService formaPagamentoService;
    private final BancoService bancoService;
    private final CondominoService condominoService;

    public PagamentosController(PagamentoService pagamentoService, UnidadeService unidadeService,
            MesService mesService, UsuarioService usuarioService,
            UsuarioAutenticadoProvider usuarioAutenticadoProvider, FormaPagamentoService formaPagamentoService,
            BancoService bancoService, CondominoService condominoService) {
        super("pagamentos", pagamentoService, "Pagamentos");
        this.unidadeService = unidadeService;
        this.mesService = mesService;
        this.usuarioService = usuarioService;
        this.usuarioAutenticadoProvider = usuarioAutenticadoProvider;
        this.formaPagamentoService = formaPagamentoService;
        this.bancoService = bancoService;
        this.condominoService = condominoService;
    }

    @PostMapping("/incluir")
    public String incluirComUnidade(@RequestParam("unidadeId") Long idUnidade, Model model) {
        model.addAttribute("idUnidade", idUnidade);
        return this.incluir(model);
    }

    @Override
    public void preCarregarAtributosObjeto(Pagamento entity, Model model) {
        Long idUnidade = (Long) model.getAttribute("idUnidade");
        if (idUnidade != null) {
            entity.setUnidade(unidadeService.recuperarPorId(idUnidade).orElse(null));
        }
        entity.setDataPagamento(LocalDate.now());
        entity.setAnoReferencia(DataUtil.getAnoNowString());
        entity.setMesReferencia(mesService.recuperarPorId(Long.valueOf(DataUtil.getMesAtual())).orElse(null));
        entity.setFuncionarioRecebedor(usuarioAutenticadoProvider.getUsuarioLogado());
    }

    @Override
    public void cargaAuxiliarObjetos(Model model) {
        model.addAttribute("listaUnidades", unidadeService.recuperarTodos());
        model.addAttribute("listaMeses", mesService.recuperarTodos());
        model.addAttribute("listaUsuarios", usuarioService.recuperarTodos());
        model.addAttribute("listaBancos", bancoService.recuperarTodos());
        model.addAttribute("listaFormaPagamentos",
                formaPagamentoService.recuperarTodos());
        model.addAttribute("listaCondominos", condominoService.recuperarTodos());
    }
}
