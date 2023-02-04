package controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

// Importando classes necessárias
import factory.ConnectionFactory;
import dao.ReservaDAO;
import modelo.Reservas;

public class ReservasController {
  
  // Declarando uma variável reservaDAO do tipo ReservaDAO
  private ReservaDAO reservaDAO;
  
  // Construtor da classe ReservasController
  public ReservasController() {
	  
    // Criando uma conexão com o banco de dados
    Connection connection = new ConnectionFactory().recuperarConexao();
    
    // Instanciando reservaDAO com a conexão
    this.reservaDAO = new ReservaDAO(connection);
  }
  
  // Método para salvar uma reserva
  public void salvar(Reservas reserva) {
    this.reservaDAO.salvar(reserva);
  }
  
  // Método para buscar todas as reservas
  public List<Reservas> buscar() {
    return this.reservaDAO.buscar();
  }
  
  // Método para buscar uma reserva pelo id
  public List<Reservas> buscarId(String id) {
    return this.reservaDAO.buscarId(id);
  }
  
  // Método para atualizar uma reserva
  public void atualizar(Date DataEntrada, Date DataSaida, String Valor, String FormaPagamento, Integer id) {
    this.reservaDAO.atualizar(DataEntrada, DataSaida, Valor, FormaPagamento, id);
  }
  
  // Método para deletar uma reserva
  public void deletar(Integer id) {
		this.reservaDAO.deletar(id);
	}
}
