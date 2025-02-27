package com.ltech.pagamentos.service;

import org.springframework.stereotype.Service;

import com.ltech.pagamentos.model.Pagamento;
import com.ltech.pagamentos.padrao.ServiceCrud;
import com.ltech.pagamentos.repository.PagamentoRepository;

@Service
public class PagamentoService extends ServiceCrud<Pagamento, Long, PagamentoRepository> {

    private final DebitoService debitoService;

    public PagamentoService(PagamentoRepository repository, DebitoService debitoService) {
        super(repository);
        this.debitoService = debitoService;
    }

    @Override
    public void ajusteAntesGravacao(Pagamento entity) {
        debitoService.gravar(entity.getUnidade().getDebito());
        super.ajusteAntesGravacao(entity);
    }

}
