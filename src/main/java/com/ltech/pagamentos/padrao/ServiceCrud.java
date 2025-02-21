package com.ltech.pagamentos.padrao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class ServiceCrud<T> {

    protected abstract JpaRepository<T, Long> getRepository();

    public List<T> recuperarTodos() {
        return getRepository().findAll();
    }

    public Page<T> recuperarTodos(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    public T gravar(T entity) {
        return getRepository().save(entity);
    }

    public Optional<T> recuperarPorId(Long id) {
        return getRepository().findById(id);
    }

    public void excluirPorId(Long id) {
        getRepository().deleteById(id);
    }

    public void ajusteAntesGravacao(T entity) {
        this.gravar(entity);
    }
}
