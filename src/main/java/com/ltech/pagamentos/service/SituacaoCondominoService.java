package com.ltech.pagamentos.service;

import org.springframework.stereotype.Service;

import com.ltech.pagamentos.model.SituacaoCondomino;
import com.ltech.pagamentos.padrao.ServiceCrud;
import com.ltech.pagamentos.repository.SituacaoCondominoRepository;

@Service
public class SituacaoCondominoService extends ServiceCrud<SituacaoCondomino, Long, SituacaoCondominoRepository> {

    public SituacaoCondominoService(SituacaoCondominoRepository situacaoCondominoRepository) {
        super(situacaoCondominoRepository);
    }

}
