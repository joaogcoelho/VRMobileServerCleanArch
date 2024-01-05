package br.com.vrsoft.vrmobile.infrastructure.config;

import br.com.vrsoft.vrmobile.application.gateways.ProdutoGateway;
import br.com.vrsoft.vrmobile.application.usecases.GetProdutosInteractor;
import br.com.vrsoft.vrmobile.infrastructure.controllers.mappers.ProdutoDTOMapper;
import br.com.vrsoft.vrmobile.infrastructure.gateways.ProdutoDaoGateway;
import br.com.vrsoft.vrmobile.infrastructure.persistence.dao.ProdutoDao;
import br.com.vrsoft.vrmobile.infrastructure.persistence.dao.impl.ProdutoDaoImpl;
import br.com.vrsoft.vrmobile.infrastructure.persistence.mappers.ProdutoRowMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ProdutoConfig {
    @Bean
    public ProdutoDao produtoDao(JdbcTemplate jdbcTemplate) {
        return new ProdutoDaoImpl(jdbcTemplate);
    }

    @Bean
    public ProdutoGateway produtoGateway(ProdutoDao produtoDao) {
        return new ProdutoDaoGateway(produtoDao);
    }

    @Bean
    public GetProdutosInteractor getProdutosInteractor(ProdutoGateway produtoGateway) {
        return new GetProdutosInteractor(produtoGateway);
    }

    @Bean
    public ProdutoDTOMapper produtoDTOMapper() {
        return new ProdutoDTOMapper();
    }

    @Bean
    public ProdutoRowMapper produtoRowMapper() {
        return new ProdutoRowMapper();
    }
}
