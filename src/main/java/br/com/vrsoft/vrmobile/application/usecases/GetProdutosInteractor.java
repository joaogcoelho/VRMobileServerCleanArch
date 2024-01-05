package br.com.vrsoft.vrmobile.application.usecases;

import br.com.vrsoft.vrmobile.application.gateways.ProdutoGateway;
import br.com.vrsoft.vrmobile.domain.entity.Produto;
import br.com.vrsoft.vrmobile.domain.entity.VRException;
import io.vavr.control.Either;

import java.util.List;

public class GetProdutosInteractor {
    private final ProdutoGateway produtoGateway;

    public GetProdutosInteractor(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public Either<VRException, List<Produto>> getProdutos() {
        try {
            return Either.right(produtoGateway.getProdutos());
        } catch (Exception exception) {
            return Either.left(new VRException("Não foi possível buscar produtos."));
        }
    }
}
