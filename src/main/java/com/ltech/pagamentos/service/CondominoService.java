package com.ltech.pagamentos.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ltech.pagamentos.model.Condomino;
import com.ltech.pagamentos.padrao.ServiceCrud;
import com.ltech.pagamentos.repository.CondominoRepository;

@Service
public class CondominoService extends ServiceCrud<Condomino> {

    private final CondominoRepository condominoRepository;

    public CondominoService(CondominoRepository condominoRepository) {
        this.condominoRepository = condominoRepository;
    }

    @Override
    protected JpaRepository<Condomino, Long> getRepository() {
        return condominoRepository;
    }

}
