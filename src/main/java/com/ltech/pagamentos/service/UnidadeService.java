package com.ltech.pagamentos.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ltech.pagamentos.model.Unidade;
import com.ltech.pagamentos.padrao.ServiceCrud;
import com.ltech.pagamentos.repository.UnidadeRepository;

@Service
public class UnidadeService extends ServiceCrud<Unidade> {

    private final UnidadeRepository unidadeRepository;

    public UnidadeService(UnidadeRepository unidadeRepository) {
        this.unidadeRepository = unidadeRepository;
    }

    @Override
    protected JpaRepository<Unidade, Long> getRepository() {
        return unidadeRepository;
    }

}
