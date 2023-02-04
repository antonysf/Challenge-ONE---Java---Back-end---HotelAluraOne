package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.Hospedes;

//Classe DAO implementa dados do hospede
public class HospedeDAO {
    //Conexão com o banco de dados
    private Connection connection;
    
    //Construtor que recebe a conexão como parâmetro
    public HospedeDAO(Connection connection) {
        this.connection = connection;
    }
    
    //Método para salvar um hospede no banco de dados
    public void salvar(Hospedes hospede) {
        try {
            //Define a string SQL para inserir dados na tabela hospedes
            String sql = "INSERT INTO hospedes (Nome, Sobrenome, DataNascimento, Nacionalidade, Telefone, idReserva) VALUES (?, ?, ?, ?,?,?)";

            //Prepara o statement com o SQL
            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                //Adiciona os valores ao statement
                pstm.setString(1, hospede.getNome());
                pstm.setString(2, hospede.getSobrenome());
                pstm.setDate(3, hospede.getDataNascimento());
                pstm.setString(4, hospede.getNacionalidade());
                pstm.setString(5, hospede.getTelefone());
                pstm.setInt(6, hospede.getIdReserva());

                //Executa o statement
                pstm.execute();

                //Tenta obter a chave gerada pelo banco de dados
                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        //Adiciona a chave gerada ao objeto hospede
                        hospede.setId(rst.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            //Lança uma exception em caso de erro na inserção no banco
            throw new RuntimeException(e);
        }
    }
    
    //Método para listar todos os hospedes
	public List<Hospedes> listarHospedes() {
		List<Hospedes> hospede = new ArrayList<>();
		try {
			String sql = "SELECT id, Nome, Sobrenome, DataNascimento, Nacionalidade, Telefone, idReserva FROM hospedes";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				transformarResultSetEmHospede(hospede, pstm);
			}
			return hospede;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Método para buscar um hospede pelo id
	public List<Hospedes> buscarId(String id) {
		List<Hospedes> hospede = new ArrayList<Hospedes>();
		try {

			String sql = "SELECT id, Nome, Sobrenome, DataNascimento, Nacionalidade, Telefone, idReserva FROM hospedes WHERE id = ?";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setString(1, id);
				pstm.execute();

				transformarResultSetEmHospede(hospede, pstm);
			}
			return hospede;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	 // Método para atualizar os dados do hospede no banco de dados.	 
	public void atualizar(String Nome, String Sobrenome, Date DataNascimento, String Nacionalidade, String Telefone, Integer idReserva, Integer id) {
	 
		// Criação da declaração SQL para atualizar os dados do hospede
	  try (PreparedStatement stm = connection
	        .prepareStatement("UPDATE hospedes SET Nome = ?, Sobrenome = ?, DataNascimento = ?, Nacionalidade = ?, Telefone = ?, idReserva = ? WHERE id = ?")) {
	   
		// Adiciona valores aos parâmetros da declaração SQL
	    stm.setString(1, Nome);
	    stm.setString(2, Sobrenome);
	    stm.setDate(3, DataNascimento);
	    stm.setString(4, Nacionalidade);
	    stm.setString(5, Telefone);
	    stm.setInt(6, idReserva);
	    stm.setInt(7, id);

	    // Execução da declaração SQL
	    stm.execute();
	  
	  } catch (SQLException e) {	    
		// Faz o lançamento de uma exceção em caso de erro na atualização
	    throw new RuntimeException(e);
	  }
	}

	//Método para deletar um hóspede do banco de dados.
	public void deletar(Integer id) {
		try (PreparedStatement stm = connection.prepareStatement("DELETE FROM hospedes WHERE id = ?")) {
			stm.setInt(1, id);
			stm.execute();
		} catch (SQLException e) {			
			// Lanca uma exceção RuntimeException caso ocorra algum erro na execução da instrução SQL
			throw new RuntimeException(e);
		}
	}
	
	//Método para transformar um ResultSet em uma lista de objetos Hospedes
	private void transformarResultSetEmHospede(List<Hospedes> reservas, PreparedStatement pstm) throws SQLException {
		
		try (ResultSet rst = pstm.getResultSet()) {
			// Percorre o ResultSet e cria objetos Hospedes a partir dos dados retornados
			while (rst.next()) {
				
				// Cria um objeto Hospedes usando os dados retornados do ResultSet
				Hospedes hospedes = new Hospedes(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDate(4), rst.getString(5), rst.getString(6), rst.getInt(7));
				// Adiciona o objeto Hospedes a lista de reservas
				reservas.add(hospedes);
			}
		}
	}
}

