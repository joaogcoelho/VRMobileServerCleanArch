package br.com.vrsoft.vrmobile.infrastructure.controllers.mappers;

import br.com.vrsoft.vrmobile.domain.entity.Produto;
import br.com.vrsoft.vrmobile.infrastructure.controllers.dtos.GetProdutosResponse;
import br.com.vrsoft.vrmobile.infrastructure.controllers.dtos.SincronizacaoProdutoDto;

import java.util.List;

public class ProdutoDTOMapper {
    public GetProdutosResponse toGetProdutosResponse(List<Produto> produtos) {
        List<SincronizacaoProdutoDto> produtoDtos = produtos.stream().map(produto -> new SincronizacaoProdutoDto(produto.id(), produto.descricao())).toList();
        return new GetProdutosResponse(produtoDtos);
    }
}
