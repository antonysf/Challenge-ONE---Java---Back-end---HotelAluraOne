package factory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

    public static void main(String[] args) {
        try {
            // Cria uma nova instância da ConnectionFactory
            ConnectionFactory connectionFactory = new ConnectionFactory();
            
            // Recupera uma conexão com o banco de dados
            Connection connection = connectionFactory.recuperarConexao();
            
            // Exibe uma mensagem de sucesso na conexão
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
            
            // Fecha a conexão
            connection.close();
            System.out.println("Conexão com o banco de dados Fechada com sucesso!!");
        } catch (SQLException e) {
            // Exibe uma mensagem de erro caso a conexão não seja estabelecida
            System.err.println("Erro ao estabelecer conexão com o banco de dados: " + e.getMessage());
        }
    }

}
