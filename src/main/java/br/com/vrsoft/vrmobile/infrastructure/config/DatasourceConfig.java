package br.com.vrsoft.vrmobile.infrastructure.config;

import br.com.vrsoft.vrmobile.config.Arquivo;
import br.com.vrsoft.vrmobile.config.DatabaseProperties;
import br.com.vrsoft.vrmobile.config.Properties;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {
    @Bean
    @Primary
    public DataSource dataSource() throws Exception {
        DatabaseProperties dbProperties = new DatabaseProperties();

        return DataSourceBuilder
            .create()
            .username(dbProperties.getUsuario())
            .password(dbProperties.getSenha())
            .url(dbProperties.getUrl())
            .driverClassName(dbProperties.getDriver())
            .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}