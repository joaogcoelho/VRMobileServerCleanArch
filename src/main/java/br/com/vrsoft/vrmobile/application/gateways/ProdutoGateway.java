package br.com.vrsoft.vrmobile.application.gateways;

import br.com.vrsoft.vrmobile.domain.entity.Produto;

import java.util.List;

public interface ProdutoGateway {
    List<Produto> getProdutos() throws Exception;
}
