package com.ltech.pagamentos.service;

import org.springframework.stereotype.Service;

import com.ltech.pagamentos.model.Condomino;
import com.ltech.pagamentos.padrao.ServiceCrud;
import com.ltech.pagamentos.repository.CondominoRepository;

@Service
public class CondominoService extends ServiceCrud<Condomino, Long, CondominoRepository> {

    public CondominoService(CondominoRepository repository) {
        super(repository);
    }

}
