package com.ltech.pagamentos.service;

import com.ltech.pagamentos.model.TipoUsuario;
import com.ltech.pagamentos.padrao.ServiceCrud;
import com.ltech.pagamentos.repository.TipoUsuarioRepository;

public class TipoUsuarioService extends ServiceCrud<TipoUsuario, Long, TipoUsuarioRepository> {

    public TipoUsuarioService(TipoUsuarioRepository repository) {
        super(repository);
    }

}
