package modelo;

import java.sql.Date;

//Classe que representa o modelo de uma reserva
public class Reservas {
	
	// Atributos da reserva
	private Integer id;
	private Date DataEntrada;
	private Date DataSaida;
	private String Valor;
	private String FormaPagamento;
	
	// Construtor que inicializa as informações da reserva, exceto o ID
	public Reservas(Date DataEntrada, Date DataSaida, String Valor, String FormaPagamento) {
		super();
		this.DataEntrada = DataEntrada;
		this.DataSaida = DataSaida;
		this.Valor = Valor;
		this.FormaPagamento = FormaPagamento;
	}
	
	// Construtor que inicializa todas as informações da reserva		
	public Reservas(Integer id, Date DataEntrada, Date DataSaida, String Valor, String FormaPagamento) {
		this.id = id;
		this.DataEntrada = DataEntrada;
		this.DataSaida = DataSaida;
		this.Valor = Valor;
		this.FormaPagamento = FormaPagamento;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}	

	//Obtém o id do reserva
	public Integer getId() {
		return id;
	}	

	//Obtém a DataEntrada da reserva
	public Date getDataEntrada() {
		return DataEntrada;
	}

	//Obtém a DataSaida da reserva
	public Date getDataSaida() {
		return DataSaida;
	}

	//Obtém o Valor da reserva
	public String getValor() {
		return Valor;
	}

	//Obtém a FormaPagamento da reserva
	public String getFormaPagamento() {
		return FormaPagamento;
	}
}
