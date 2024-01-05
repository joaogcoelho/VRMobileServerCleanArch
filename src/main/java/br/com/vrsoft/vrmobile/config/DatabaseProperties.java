package br.com.vrsoft.vrmobile.config;

public class DatabaseProperties {
    private final String ipBanco;
    private final int portaBanco;
    private final String nomeBanco;
    private final String usuario;
    private final String senha;

    public DatabaseProperties() throws Exception {
        Properties properties = new Properties(Arquivo.getVRDirectory() + "/vr.properties");
        ipBanco = properties.getString("database.ip");
        portaBanco = properties.getInt("database.porta");
        nomeBanco = properties.getString("database.nome");
        usuario = properties.getString("database.usuario").isEmpty() ? "postgres" : properties.getString("database.usuario");
        senha = properties.getString("database.senha").isEmpty() ? "postgres" : properties.getString("database.senha");
    }

    public String getUrl() {
        return "jdbc:postgresql://" + ipBanco + ":" + portaBanco + "/" + nomeBanco;
    }

    public String getDriver() {
        return "org.postgresql.Driver";
    }

    public int getPortaBanco() {
        return portaBanco;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
}
