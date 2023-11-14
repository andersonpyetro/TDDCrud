package br.com.pyetro.dao;

import br.com.pyetro.dao.generics.GenericDao;
import br.com.pyetro.domain.Venda;
import br.com.pyetro.domain.Venda.Status;
import br.com.pyetro.exceptions.TipoChaveNaoEncontradaException;

public class VendaDao extends GenericDao<Venda, String> implements IVendaDao {
    @Override
    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException {
        venda.setStatus(Status.CONCLUIDA);
        super.alterar(venda);

    }

    @Override
    public Class<Venda> getTipoClasse() {
        return Venda.class;
    }

    @Override
    public void excluir(String valor) {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    public void atualizarDados(Venda entity, Venda entityCadastado) {
        entityCadastado.setCodigo(entity.getCodigo());
        entityCadastado.setStatus(entity.getStatus());

    }

}
