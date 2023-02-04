package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Reservas;

//Classe DAO implementa dados da reserva
public class ReservaDAO {
	
	//Conexão com o banco de dados
	private Connection connection;
	
	 //Construtor que recebe a conexão como parâmetro
	public ReservaDAO(Connection connection) {
		this.connection = connection;
	}
	
	 //Método para salvar uma reserva no banco de dados
	public void salvar(Reservas reserva) {
		// Executar o código dentro do bloco try
		try {
			//Define a string SQL para inserir dados na tabela reservas
			String sql = "INSERT INTO reservas (DataEntrada, DataSaida, Valor, FormaPagamento) VALUES (?, ?, ?, ?)";

			 //Prepara o statement com o SQL
			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				//Adiciona os valores ao statement
				pstm.setDate(1, reserva.getDataEntrada());
				pstm.setDate(2, reserva.getDataSaida());
				pstm.setString(3, reserva.getValor());
				pstm.setString(4, reserva.getFormaPagamento());

				//Executa o statement
				pstm.executeUpdate();

				//Tenta obter a chave gerada pelo banco de dados
				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						//Adiciona a chave gerada ao objeto reserva
						reserva.setId(rst.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			//Lança uma exception em caso de erro na inserção no banco
			throw new RuntimeException(e);
		}

	}
	
	//Método para listar todas as reservas	
	public List<Reservas> buscar() {
		List<Reservas> reserva = new ArrayList<Reservas>();
		try {
			String sql = "SELECT id, DataEntrada, DataSaida, Valor, FormaPagamento FROM reservas";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				transformarResultSetEmReserva(reserva, pstm);
			}
			return reserva;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Método para buscar uma reserva pelo id	
	public List<Reservas> buscarId(String id) {
		List<Reservas> reserva = new ArrayList<Reservas>();
		try {

			String sql = "SELECT id, DataEntrada, DataSaida, Valor, FormaPagamento FROM reservas WHERE id = ?";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setString(1, id);
				pstm.execute();

				transformarResultSetEmReserva(reserva, pstm);
			}
			return reserva;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Método para deletar uma reserva do banco de dados.	
	public void deletar(Integer id) {
		try (PreparedStatement stm = connection.prepareStatement("DELETE FROM reservas WHERE id = ?")) {
			stm.setInt(1, id);
			stm.execute();
		} catch (SQLException e) {			
			// Lanca uma exceção RuntimeException caso ocorra algum erro na execução da instrução SQL
			throw new RuntimeException(e);
		}
	}
	
	// Método para atualizar os dados de uma reserva no banco de dados.
	public void atualizar(Date DataEntrada, Date DataSaida, String Valor, String FormaPagamento, Integer id) {
		
		// Criação da declaração SQL para atualizar os dados da reserva
		try (PreparedStatement stm = connection
				.prepareStatement("UPDATE reservas SET DataEntrada = ?, DataSaida = ?, Valor = ?, FormaPagamento = ? WHERE id = ?")) {
			
			// Adiciona valores aos parâmetros da declaração SQL
			stm.setDate(1, DataEntrada);
			stm.setDate(2, DataSaida);
			stm.setString(3, Valor);
			stm.setString(4, FormaPagamento);
			stm.setInt(5, id);
			
			// Execução da declaração SQL
			stm.execute();
		} catch (SQLException e) {
			// Faz o lançamento de uma exceção em caso de erro na atualização
			throw new RuntimeException(e);
		}
	}

						
	//Método para transformar um ResultSet em uma lista de objetos reservas.
	private void transformarResultSetEmReserva(List<Reservas> reservas, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			// Percorre o ResultSet e cria objetos Reservas a partir dos dados retornados
			while (rst.next()) {
				
				// Cria um objeto Reserva usando os dados retornados do ResultSet
				Reservas reserva = new Reservas(rst.getInt(1), rst.getDate(2), rst.getDate(3), rst.getString(4), rst.getString(5));
				// Adiciona o objeto Reservas a lista de reservas
				reservas.add(reserva);
			}
		}
	}
}
