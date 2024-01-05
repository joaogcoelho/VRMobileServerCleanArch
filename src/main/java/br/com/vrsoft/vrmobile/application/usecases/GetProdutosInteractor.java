package br.com.vrsoft.vrmobile.application.usecases;

import br.com.vrsoft.vrmobile.application.gateways.ProdutoGateway;
import br.com.vrsoft.vrmobile.domain.entity.Either;
import br.com.vrsoft.vrmobile.domain.entity.Produto;
import br.com.vrsoft.vrmobile.domain.entity.VRException;

import java.util.List;

public class GetProdutosInteractor {
    private final ProdutoGateway produtoGateway;

    public GetProdutosInteractor(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public List<Produto> getProdutos() throws Exception {
        try {
            return produtoGateway.getProdutos();
        } catch (Exception exception) {
            throw new VRException("Ocorreu um erro ao buscar produtos para sincronização.");
        }
    }
}
