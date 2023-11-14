package br.com.pyetro.dao;

import br.com.pyetro.dao.generics.GenericDao;
import br.com.pyetro.domain.Cliente;

public class ClienteDao extends GenericDao<Cliente, Long> implements IClienteDao {
    public ClienteDao(){
        super();
    }
    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualizarDados(Cliente entity, Cliente entityCadastado) {
        entityCadastado.setCidade(entity.getCidade());
        entityCadastado.setCpf(entity.getCpf());
        entityCadastado.setEstado(entity.getEstado());
        entityCadastado.setNome(entity.getNome());
        entityCadastado.setNumero(entity.getNumero());
        entityCadastado.setTel(entity.getTel());

    }
}
