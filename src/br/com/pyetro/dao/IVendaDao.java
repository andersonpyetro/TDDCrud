package br.com.pyetro.dao;

import br.com.pyetro.dao.generics.IGenericDao;
import br.com.pyetro.domain.Venda;
import br.com.pyetro.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDao extends IGenericDao<Venda, String> {
    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;
}
