package com.ltech.pagamentos.padrao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class ServiceCrud<T, ID> {

    protected abstract JpaRepository<T, ID> getRepository();

    public List<T> recuperarTodos() {
        return getRepository().findAll();
    }

    public Page<T> recuperarTodos(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    public T gravar(T entity) {
        return getRepository().save(entity);
    }

    public Optional<T> recuperarPorId(ID id) {
        return getRepository().findById(id);
    }

    public void deletarPorId(ID id) {
        getRepository().deleteById(id);
    }
}
