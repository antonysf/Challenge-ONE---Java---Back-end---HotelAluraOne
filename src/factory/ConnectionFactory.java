package factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

    private DataSource dataSource;

    public ConnectionFactory() {
        // Carrega as configurações do banco de dados a partir do arquivo dbconfig.properties
        Properties dbProperties = new Properties();
        try (InputStream in = ConnectionFactory.class.getResourceAsStream("/dbconfig.properties")) {
            dbProperties.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar configurações do banco de dados: " + e.getMessage(), e);
        }

        // Cria uma nova instância do ComboPooledDataSource
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        // Configura a URL de conexão com o banco de dados
        comboPooledDataSource.setJdbcUrl(dbProperties.getProperty("db.url"));

        // Configura o usuário e senha para conexão
        comboPooledDataSource.setUser(dbProperties.getProperty("db.user"));
        comboPooledDataSource.setPassword(dbProperties.getProperty("db.password"));

        // Atribui o DataSource configurado à variável de instância
        this.dataSource = comboPooledDataSource;
    }

    public Connection recuperarConexao() {
        try {
            // Tenta recuperar uma conexão do DataSource
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            // Trata a exceção e lança uma nova exceção com uma mensagem mais informativa
            throw new RuntimeException("Erro ao recuperar conexão com o banco de dados: " + e.getMessage(), e);
        }
    }
}

