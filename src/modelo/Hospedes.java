package modelo;

import java.sql.Date;

//Classe que representa o modelo de um hóspede
public class Hospedes {	
	// Atributos do hóspede
	private Integer Id;
	private String Nome;
	private String Sobrenome;
	private Date DataNascimento;
	private String Nacionalidade;
	private String Telefone;
	private Integer idReserva;
	
	// Construtor que inicializa as informações do hóspede, exceto o ID
	public Hospedes(String Nome, String Sobrenome, Date DataNascimento, String Nacionalidade, String Telefone,
					Integer idReserva) {
		super();
		this.Nome = Nome;
		this.Sobrenome = Sobrenome;
		this.DataNascimento = DataNascimento;
		this.Nacionalidade = Nacionalidade;
		this.Telefone = Telefone;
		this.idReserva = idReserva;
	}
	
	// Construtor que inicializa todas as informações do hóspede
	public Hospedes(Integer id, String Nome, String Sobrenome, Date DataNascimento, String Nacionalidade,
					String Telefone, Integer idReserva) {
		super();
		Id = id;
		this.Nome = Nome;
		this.Sobrenome = Sobrenome;
		this.DataNascimento = DataNascimento;
		this.Nacionalidade = Nacionalidade;
		this.Telefone = Telefone;
		this.idReserva = idReserva;
	}


	//Obtém o id do hóspede
	public Integer getId() {
		return Id;
	}
    
	//Define o id do hóspede
	public void setId(Integer id) {
		Id = id;
	}

	//Obtém o Nome do hóspede
	public String getNome() {
		return Nome;
	}

	//Define o Nome do hóspede
	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	//Obtém o Sobrenome
	public String getSobrenome() {
		return Sobrenome;
	}

	//Define o Sobrenome do hóspede
	public void setSobrenome(String Sobrenome) {
		this.Sobrenome = Sobrenome;
	}

	//Obtém a Nacionalidade do Hospede
	public String getNacionalidade() {
		return Nacionalidade;
	}

	//Define a Nacionalidade do hóspede
	public void setNacionalidade(String Nacionalidade) {
		this.Nacionalidade = Nacionalidade;
	}

	//Obtém a DataNascimento do Hospede
	public Date getDataNascimento() {
		return DataNascimento;
	}

	//Define a DataNacimento do hóspede
	public void setDataNascimento(Date DataNascimento) {
		this.DataNascimento = DataNascimento;
	}

	//Obtém o Telefone do hóspede
	public String getTelefone() {
		return Telefone;
	}

	//Define o Telefone do hóspede
	public void setTelefone(String Telefone) {
		this.Telefone = Telefone;
	}

	//Obtém o id da Reserva do hóspede
	public Integer getIdReserva() {
		return idReserva;
	}

	//Define o id da Reserva do hóspede
	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}	
}
