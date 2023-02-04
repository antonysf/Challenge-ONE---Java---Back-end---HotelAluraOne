package controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import factory.ConnectionFactory;
import dao.HospedeDAO;
import modelo.Hospedes;

// Classe controladora para o objeto Hospedes
public class HospedesController {
	
  // Variável de instância para o DAO Hospede
	private HospedeDAO hospedeDAO;
  
  // Construtor da classe, cria uma conexão com o banco de dados e instancia o DAO Hospede
	public HospedesController() {
			Connection connection = new ConnectionFactory().recuperarConexao();
			this.hospedeDAO = new HospedeDAO(connection);
		}
  
  // Método para salvar um objeto Hospedes
		public void salvar(Hospedes hospede) {
			this.hospedeDAO.salvar(hospede);
		}
  
  // Método para listar todos os objetos Hospedes
		public List<Hospedes> listarHospedes() {
			return this.hospedeDAO.listarHospedes();
		}
  
  // Método para listar um objeto Hospedes pelo ID
		public List<Hospedes> listarHospedesId(String id) {
			return this.hospedeDAO.buscarId(id);
		}
  
  // Método para atualizar um objeto Hospedes
	public void atualizar(String Nome, String Sobrenome, Date DataNascimento, String Nacionalidade, String Telefone, Integer idReserva, Integer id) {
		this.hospedeDAO.atualizar(Nome, Sobrenome, DataNascimento, Nacionalidade, Telefone, idReserva, id);
	}
  
  // Método para deletar um objeto Hospedes
		public void deletar(Integer id) {
			this.hospedeDAO.deletar(id);
		}
}
