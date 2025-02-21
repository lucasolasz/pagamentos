package com.ltech.pagamentos.padrao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class ServiceCrud<T, ID, R extends JpaRepository<T, ID>> {

    protected final R repository;

    public ServiceCrud(R repository) {
        this.repository = repository;
    }

    public List<T> recuperarTodos() {
        return repository.findAll();
    }

    public Page<T> recuperarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public T gravar(T entity) {
        return repository.save(entity);
    }

    public Optional<T> recuperarPorId(ID id) {
        return repository.findById(id);
    }

    public void excluirPorId(ID id) {
        repository.deleteById(id);
    }

    public void ajusteAntesGravacao(T entity) {
        this.gravar(entity);
    }

    public R getRepository() {
        return this.repository;
    }
}
