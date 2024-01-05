package br.com.vrsoft.vrmobile.infrastructure.persistence.dao.impl;

import br.com.vrsoft.vrmobile.domain.entity.Produto;
import br.com.vrsoft.vrmobile.infrastructure.persistence.dao.ProdutoDao;
import br.com.vrsoft.vrmobile.infrastructure.persistence.mappers.ProdutoRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProdutoDaoImpl implements ProdutoDao {
    private final JdbcTemplate jdbcTemplate;

    public ProdutoDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Produto> getProdutos() {
        return jdbcTemplate.query("SELECT id, descricaoCompleta FROM produto", new ProdutoRowMapper());
    }
}
