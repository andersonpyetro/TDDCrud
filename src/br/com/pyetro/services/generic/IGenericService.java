package br.com.pyetro.services.generic;

import br.com.pyetro.dao.Persistente;
import br.com.pyetro.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericService <T extends Persistente, E extends Serializable> {

    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;

    public void excluir(E valor);

    public void alterar (T entity) throws TipoChaveNaoEncontradaException;

    public T consultar (E valor);

    public Collection<T> buscarTodos();
}
