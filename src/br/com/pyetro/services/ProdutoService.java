package br.com.pyetro.services;

import br.com.pyetro.dao.IProdutoDao;
import br.com.pyetro.domain.Produto;
import br.com.pyetro.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {
    public ProdutoService(IProdutoDao dao) {
        super(dao);
    }
}
