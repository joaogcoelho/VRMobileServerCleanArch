package br.com.vrsoft.vrmobile.infrastructure.persistence.mappers;

import br.com.vrsoft.vrmobile.domain.entity.Produto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoRowMapper implements RowMapper<Produto> {
    @Override
    public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Produto(rs.getInt("id"), rs.getString("descricaoCompleta"));
    }
}
