package com.ltech.pagamentos.service;

import org.springframework.stereotype.Service;

import com.ltech.pagamentos.model.Unidade;
import com.ltech.pagamentos.padrao.ServiceCrud;
import com.ltech.pagamentos.repository.UnidadeRepository;

@Service
public class UnidadeService extends ServiceCrud<Unidade, Long, UnidadeRepository> {

    public UnidadeService(UnidadeRepository repository) {
        super(repository);

    }

}
