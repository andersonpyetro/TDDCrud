package br.com.pyetro.dao;

import br.com.pyetro.dao.generics.GenericDao;
import br.com.pyetro.domain.Produto;

public class ProdutoDao extends GenericDao<Produto, String> implements IProdutoDao {

    public ProdutoDao() {
        super();
    }
    @Override
    public Class<Produto> getTipoClasse() {
        return Produto.class;
    }

    @Override
    public void atualizarDados(Produto entity, Produto entityCadastrado) {
        entityCadastrado.setCodigo(entity.getCodigo());
        entityCadastrado.setDescricao(entity.getDescricao());
        entityCadastrado.setNome(entity.getNome());
        entityCadastrado.setValor(entity.getValor());

    }
}
