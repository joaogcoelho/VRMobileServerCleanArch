package br.com.vrsoft.vrmobile.infrastructure.gateways;

import br.com.vrsoft.vrmobile.application.gateways.ProdutoGateway;
import br.com.vrsoft.vrmobile.domain.entity.Produto;
import br.com.vrsoft.vrmobile.infrastructure.persistence.dao.ProdutoDao;

import java.util.List;

public class ProdutoDaoGateway implements ProdutoGateway {
    private final ProdutoDao produtoDao;

    public ProdutoDaoGateway(ProdutoDao produtoDao) {
        this.produtoDao = produtoDao;
    }

    @Override
    public List<Produto> getProdutos() throws Exception {
        return produtoDao.getProdutos();
    }
}
