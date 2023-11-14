package br.com.pyetro.dao;

import br.com.pyetro.dao.IProdutoDao;
import br.com.pyetro.domain.Cliente;
import br.com.pyetro.domain.Produto;
import br.com.pyetro.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class ProdutoDaoMock implements IProdutoDao {

    private Map<String, Produto> produtos = new HashMap<>();
    private Produto produto;


    @Override
    public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException {
        if (produtos.containsKey(produto.getCodigo())){
            throw new TipoChaveNaoEncontradaException("Produto já cadastrado com o código" + produto.getCodigo());

        }
        produtos.put(produto.getCodigo(),produto);
        return true;
    }

    @Override
    public void excluir(String valor) {
        produtos.remove(valor);
    }

    @Override
    public void alterar(Produto entity) throws TipoChaveNaoEncontradaException {
        Produto produto = new Produto();
        produto.setValor(produto.getValor());
        produto.setCodigo(produto.getCodigo());
        produto.setNome(produto.getNome());
        produto.setDescricao(produto.getDescricao());

    }

    @Override
    public Produto consultar(String valor) {
        Produto produto = new Produto();
        produto.setCodigo(valor);
        return produto;
    }

    @Override
    public Collection<Produto> buscarTodos() {
        return new ArrayList<>(produtos.values());
    }
}
