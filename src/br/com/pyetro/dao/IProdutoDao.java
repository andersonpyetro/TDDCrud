package br.com.pyetro.dao;

import br.com.pyetro.dao.generics.IGenericDao;
import br.com.pyetro.domain.Cliente;
import br.com.pyetro.domain.Produto;

public interface IProdutoDao extends IGenericDao<Produto, String> {
}
