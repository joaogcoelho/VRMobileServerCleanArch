package br.com.vrsoft.vrmobile.infrastructure.persistence.dao;

import br.com.vrsoft.vrmobile.domain.entity.Produto;

import java.util.List;

public interface ProdutoDao {
    List<Produto> getProdutos() throws Exception;
}
