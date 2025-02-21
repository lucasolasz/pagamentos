package com.ltech.pagamentos.padrao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

public abstract class CrudController<T, S extends ServiceCrud<T>> {

    /**
     * Caminho base das views (ex: "students")
     */
    private final String viewPath;
    private final String nomeTela;
    private final Class<T> entityClass;
    private S service;

    /**
     * Operação em curso. Valores possíveis na classe OperacaoCrud
     */
    private int operacaoAtual;

    public CrudController(String viewPath, S service, String nomeTela) {
        this.viewPath = viewPath;
        this.entityClass = getEntityClass();
        this.service = service;
        this.nomeTela = nomeTela;
    }

    // Método para capturar a classe da entidade (T) usando reflexão
    @SuppressWarnings("unchecked")
    private Class<T> getEntityClass() {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) type;
        return (Class<T>) paramType.getActualTypeArguments()[0]; // Retorna a classe T
    }

    /*
     * Método para acessar o serviço a partir das classes filhas
     */
    protected S getService() {
        return service;
    }

    public String getNomeTela() {
        return this.nomeTela;
    }

    public String getViewPath() {
        return "/" + this.viewPath;
    }

    /**
     * Redireciona para o path origem
     * 
     * @return "/"
     */
    public String getRedirectPathOrigem() {
        return "redirect:/" + this.viewPath;
    }

    /**
     * Carrega a view de inclusão
     * 
     * @return path + /incluir
     */
    public String getViewPathOperacaoInclusao() {
        return this.viewPath + "/incluir";
    }

    /**
     * Carrega a view de visualização
     * 
     * @return path + /visualizar
     */
    public String getViewPathOperacaoVisualizar() {
        return this.viewPath + "/visualizar";
    }

    /**
     * Método que controla se a página deve ser exibida no modo de somente
     * leitura.
     */
    public Boolean getSomenteLeitura() {
        if (operacaoAtual == OperacaoCrud.OPE_EDICAO)
            return false;
        if (operacaoAtual == OperacaoCrud.OPE_INCLUSAO)
            return false;
        return true;
    }

    /**
     * Método que retorna a operação em curso na forma textual.
     * 
     * @return
     */
    public String getTextoOperacaoAtual() {
        return OperacaoCrud.getTextoOperacao(operacaoAtual);
    }

    public void cargaAuxiliarObjetos(Model model) {
    }

    private void carregarAtributosTela(Model model) {
        model.addAttribute("textoOperacaoAtual", this.getTextoOperacaoAtual());
        model.addAttribute("somenteLeitura", this.getSomenteLeitura());
        model.addAttribute("nomeTela", this.getNomeTela());
        model.addAttribute("viewPath", this.getViewPath());
    }

    @GetMapping
    public String index(Model model) {
        this.operacaoAtual = OperacaoCrud.OPE_PESQUISA;
        this.carregarAtributosTela(model);
        return this.getViewPathOperacaoVisualizar();
    }

    @GetMapping("/incluir")
    public String incluir(Model model) {
        try {
            T entity = entityClass.getDeclaredConstructor().newInstance(); // Cria uma nova instância da entidade
            model.addAttribute("objeto", entity);
            this.cargaAuxiliarObjetos(model);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao criar instância da entidade", e);
        }
        return this.getViewPathOperacaoInclusao();
    }

    @PostMapping("/gravar")
    public String gravar(@Valid @ModelAttribute("objeto") T entity, BindingResult result, Model model) {
        service.ajusteAntesGravacao(entity);
        service.gravar(entity);
        return this.getRedirectPathOrigem();
    }

    @GetMapping("/consultar/{id}")
    public String consultar(@PathVariable("id") Long id, Model model) {
        this.operacaoAtual = OperacaoCrud.OPE_CONSULTA;
        Optional<T> entity = service.recuperarPorId(id);

        if (entity.isPresent()) {
            model.addAttribute("objeto", entity.get());
            this.carregarAtributosTela(model);
            this.cargaAuxiliarObjetos(model);
            return this.getViewPathOperacaoInclusao();
        }

        return this.getRedirectPathOrigem();
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable("id") Long id, Model model) {
        this.operacaoAtual = OperacaoCrud.OPE_EDICAO;
        Optional<T> entity = service.recuperarPorId(id);

        if (entity.isPresent()) {
            model.addAttribute("objeto", entity.get());
            this.carregarAtributosTela(model);
            this.cargaAuxiliarObjetos(model);
            return this.getViewPathOperacaoInclusao();
        }

        return this.getRedirectPathOrigem();
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, Model model) {
        service.excluirPorId(id);
        return this.getRedirectPathOrigem();
    }
}
