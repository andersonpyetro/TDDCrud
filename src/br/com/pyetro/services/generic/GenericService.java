package br.com.pyetro.services.generic;

import br.com.pyetro.dao.IProdutoDao;
import br.com.pyetro.dao.Persistente;
import br.com.pyetro.dao.generics.IGenericDao;
import br.com.pyetro.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public abstract class GenericService<T extends Persistente, E extends Serializable> implements IGenericService<T, E> {

    protected IGenericDao<T,E> dao;

    public GenericService(IGenericDao<T, E> dao) {
        this.dao = dao;
    }

    public GenericService(IProdutoDao dao) {
    }

    @Override
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException {
        return this.dao.cadastrar(entity);
    }

    @Override
    public void excluir(E valor) {
        this.dao.excluir(valor);

    }

    @Override
    public void alterar(T entity) throws TipoChaveNaoEncontradaException {
        this.dao.alterar(entity);

    }

    @Override
    public T consultar(E valor) {
        return this.dao.consultar(valor);
    }

    @Override
    public Collection<T> buscarTodos() {
        return this.dao.buscarTodos();
    }
}
