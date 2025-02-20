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

    private final String viewPath; // Caminho base das views (ex: "students")
    private final Class<T> entityClass;
    private S service;
    // private final String viewPathOperacao;

    public CrudController(String viewPath, S service) {
        this.viewPath = viewPath;
        this.entityClass = getEntityClass();
        this.service = service;
    }

    // Método para capturar a classe da entidade (T) usando reflexão
    @SuppressWarnings("unchecked")
    private Class<T> getEntityClass() {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) type;
        return (Class<T>) paramType.getActualTypeArguments()[0]; // Retorna a classe T
    }

    // Método para acessar o serviço a partir das classes filhas
    protected S getService() {
        return service;
    }

    public String getRedirectPathOrigem() {
        return "redirect:/" + this.viewPath;
    }

    public String getViewPathOperacaoInclusao() {
        return this.viewPath + "/incluir";
    }

    public String getViewPathOperacaoVisualizar() {
        return this.viewPath + "/visualizar";
    }

    @GetMapping
    public String index(Model model) {
        return this.getViewPathOperacaoVisualizar();
    }

    public void cargaAuxiliarObjetos(Model model) {
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

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Optional<T> entity = service.recuperarPorId(id);
        model.addAttribute("objeto", entity.orElseThrow(() -> new RuntimeException("Entidade não encontrada")));
        this.cargaAuxiliarObjetos(model);
        return this.getViewPathOperacaoInclusao();
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable("id") Long id, Model model) {
        service.deletarPorId(id);
        return this.getRedirectPathOrigem();
    }
}
