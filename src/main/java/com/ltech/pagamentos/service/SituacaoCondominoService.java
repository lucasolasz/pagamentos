package com.ltech.pagamentos.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ltech.pagamentos.model.SituacaoCondomino;
import com.ltech.pagamentos.padrao.ServiceCrud;
import com.ltech.pagamentos.repository.SituacaoCondominoRepository;

@Service
public class SituacaoCondominoService extends ServiceCrud<SituacaoCondomino> {

    private final SituacaoCondominoRepository situacaoCondominoRepository;

    public SituacaoCondominoService(SituacaoCondominoRepository situacaoCondominoRepository) {
        this.situacaoCondominoRepository = situacaoCondominoRepository;
    }

    @Override
    protected JpaRepository<SituacaoCondomino, Long> getRepository() {
        return situacaoCondominoRepository;
    }

}
