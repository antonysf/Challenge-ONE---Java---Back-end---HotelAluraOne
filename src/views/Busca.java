package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.HospedesController;
import controller.ReservasController;
import modelo.Hospedes;
import modelo.Reservas;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Date;
import java.util.List;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Optional;
import javax.swing.JScrollPane;

//Construtor da classe Busca, que extende a classe JFrame
@SuppressWarnings("serial")
public class Busca extends JFrame {

	// Declaração de componentes da interface gráfica
	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHospedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHospede;

	// Declaração dos controladores de reservas e hóspedes
	private ReservasController reservaController;
	private HospedesController hospedesController;

	// Declaração de rótulos para a barra de título
	private JLabel labelAtras;
	private JLabel labelExit;

	// Variáveis para armazenar as coordenadas do mouse
	int xMouse, yMouse;

	// Variáveis para armazenar as informações de reserva e hóspede
	String reserva;
	String hospedes;

	/**
	 * Método main, que inicia a aplicação Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busca frame = new Busca();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame. Construtor da classe Busca, responsável por inicializar as
	 * variáveis e exibir a janela
	 */
	public Busca() {
		this.reservaController = new ReservasController();
		this.hospedesController = new HospedesController();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busca.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane(tbReservas);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		JLabel lblTitulo = new JLabel("SISTEMA DE BUSCA");
		lblTitulo.setBounds(331, 62, 280, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto Black", Font.BOLD, 24));
		contentPane.add(lblTitulo);

		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBounds(20, 169, 865, 328);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		contentPane.add(panel);

		tbHospedes = new JTable();
		tbHospedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.addTab("Hóspedes", new ImageIcon(Busca.class.getResource("/imagenes/pessoas.png")), tbHospedes, null);
		modeloHospede = (DefaultTableModel) tbHospedes.getModel();
		modeloHospede.addColumn("Numero de Hóspede");
		modeloHospede.addColumn("Nome");
		modeloHospede.addColumn("Sobrenome");
		modeloHospede.addColumn("Data de Nascimento");
		modeloHospede.addColumn("Nacionalidade");
		modeloHospede.addColumn("Telefone");
		modeloHospede.addColumn("Numero de Reserva");
		preencherTabelaHospedes();

		tbReservas = new JTable();
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.addTab("Reservas", new ImageIcon(Busca.class.getResource("/imagenes/reservado.png")), tbReservas, null);
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Data Check In");
		modelo.addColumn("Data Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pagamento");
		tbReservas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		preencherTabelaReservas();

		JLabel logo = new JLabel("");
		logo.setBounds(56, 51, 104, 107);
		logo.setIcon(new ImageIcon(Busca.class.getResource("/imagenes/Ha-100px.png")));
		contentPane.add(logo);

		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);

			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		contentPane.add(header);

		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(255, 255, 255));
				labelAtras.setForeground(Color.BLUE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);

		// botão voltar

		labelAtras = new JLabel("🢀");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);

		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnexit.setBackground(Color.white);
				labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);

		labelExit = new JLabel("❌");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(539, 159, 193, 2);
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2);

		JPanel btnbuscar = new JPanel();
		btnbuscar.setBounds(748, 125, 128, 35);
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				limparTabela();

				// Verifica se o campo de busca está vazio
				if (txtBuscar.getText().equals("")) {
					// Preenche a tabela de reservas
					preencherTabelaReservas();
					// Preenche a tabela de hóspedes
					preencherTabelaHospedes();
				} else {
					// Preenche a tabela de reservas pelo ID
					preencherTabelaReservasId();
					// Preenche a tabela de hóspedes pelo ID
					preencherTabelaHospedesId();
				}
			}

		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);

		JLabel lblBuscar = new JLabel(" 🔍BUSCAR ID");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

		JPanel btnEditar = new JPanel();
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int filaReservas = tbReservas.getSelectedRow();
				int filaHospedes = tbHospedes.getSelectedRow();

				if (filaReservas >= 0) {
					atualizarReservas();
					limparTabela();
					preencherTabelaReservas();
					preencherTabelaHospedes();
				} else if (filaHospedes >= 0) {
					atualizarHospede();
					limparTabela();
					preencherTabelaHospedes();
					preencherTabelaReservas();
				}
			}

		});
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);

		JLabel lblEditar = new JLabel("✎EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);

		JPanel btnEliminar = new JPanel();
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.addMouseListener(new MouseAdapter() {
		  @Override
		  public void mouseClicked(MouseEvent e) {
		    int filaReservas = tbReservas.getSelectedRow();
		    int filaHospedes = tbHospedes.getSelectedRow();

		    String selectedTable = "";
		    int selectedRow = -1;
		    if (filaReservas >= 0) {
		      selectedTable = "reservas";
		      selectedRow = filaReservas;
		    } else if (filaHospedes >= 0) {
		      selectedTable = "hospedes";
		      selectedRow = filaHospedes;
		    } else {
		      JOptionPane.showMessageDialog(null, "Erro: fileira não selecionada, por favor realize uma busca e selecione uma fileira para excluir");
		      return;
		    }

		    int confirmar = JOptionPane.showConfirmDialog(null, "Deseja excluir os dados?");

		    if (confirmar == JOptionPane.YES_OPTION) {
		      String valor = (selectedTable == "reservas") ? tbReservas.getValueAt(selectedRow, 0).toString() : tbHospedes.getValueAt(selectedRow, 0).toString();
		      if (selectedTable == "reservas") {
		        reservaController.deletar(Integer.valueOf(valor));
		      } else {
		        hospedesController.deletar(Integer.valueOf(valor));
		      }
		      JOptionPane.showMessageDialog(contentPane, "Registro Excluído");
		      limparTabela();
		      preencherTabelaReservas();
		      preencherTabelaHospedes();
		    }
		  }
		});

		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);

		JLabel lblEliminar = new JLabel("❌EXCLUIR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
	}

	// Método para buscar todas as reservas
	private List<Reservas> buscarReservas() {
		// Retorna a lista de reservas obtida pelo método buscar() do controller de
		// reservas
		return this.reservaController.buscar();
	}

	// Método para buscar uma reserva específica por id
	private List<Reservas> buscarReservasId() {
		// Retorna a lista de reservas obtida pelo método buscarId() do controller de
		// reservas
		// O id é obtido a partir do texto digitado no componente txtBuscar
		return this.reservaController.buscarId(txtBuscar.getText());
	}

	// Método para buscar todos os hóspedes
	private List<Hospedes> buscarHospedes() {
		// Retorna a lista de hóspedes obtida pelo método listarHospedes() do controller
		// de hóspedes
		return this.hospedesController.listarHospedes();
	}

	// Método para buscar um hóspede específico por id
	private List<Hospedes> BuscarHospedesId() {
		// Retorna a lista de hóspedes obtida pelo método listarHospedesId() do
		// controller de hóspedes
		// O id é obtido a partir do texto digitado no componente txtBuscar
		return this.hospedesController.listarHospedesId(txtBuscar.getText());
	}

	// Método para limpar as tabelas tbHospedes e tbReservas
	private void limparTabela() {
		// Remove todas as linhas da tabela tbHospedes
		((DefaultTableModel) tbHospedes.getModel()).setRowCount(0);
		// Remove todas as linhas da tabela tbReservas
		((DefaultTableModel) tbReservas.getModel()).setRowCount(0);
	}

	// Método para preencher a tabela de reservas
	private void preencherTabelaReservas() {

		// Busca a lista de reservas
		List<Reservas> reservaLista = buscarReservas();

		try {
			// Adiciona cada objeto reserva na tabela
			for (Reservas reservas : reservaLista) {
				modelo.addRow(new Object[] { reservas.getId(), reservas.getDataEntrada(), reservas.getDataSaida(),
						reservas.getValor(), reservas.getFormaPagamento() });
			}
		} catch (Exception e) {
			// Lança exceção caso ocorra algum erro
			throw e;
		}
	}

	// Método para preencher a tabela de reservas por ID
	private void preencherTabelaReservasId() {

		// Busca a lista de reservas por ID
		List<Reservas> reservaLista = buscarReservasId();

		try {
			// Adiciona cada objeto reserva na tabela
			for (Reservas reservas : reservaLista) {
				modelo.addRow(new Object[] { reservas.getId(), reservas.getDataEntrada(), reservas.getDataSaida(),
						reservas.getValor(), reservas.getFormaPagamento() });
			}
		} catch (Exception e) {
			// Lança exceção caso ocorra algum erro
			throw e;
		}
	}

	// Método para preencher a tabela de hóspedes
	private void preencherTabelaHospedes() {

		// Busca a lista de hóspedes
		List<Hospedes> hospedesLista = buscarHospedes();

		try {
			// Adicionar cada objeto hóspede na tabela
			for (Hospedes hospede : hospedesLista) {
				modeloHospede.addRow(new Object[] { hospede.getId(), hospede.getNome(), hospede.getSobrenome(),
						hospede.getDataNascimento(), hospede.getNacionalidade(), hospede.getTelefone(),
						hospede.getIdReserva() });
			}
		} catch (Exception e) {
			// Lança exceção caso ocorra algum erro
			throw e;
		}
	}

	// Método para preencher a tabela de Hospedes por ID
	private void preencherTabelaHospedesId() {

		// Busca a lista de hospedes por ID
		List<Hospedes> hospedesLista = BuscarHospedesId();
		try {
			// Adicionar cada objeto hóspede na tabela
			for (Hospedes hospede : hospedesLista) {
				modeloHospede.addRow(new Object[] { hospede.getId(), hospede.getNome(), hospede.getSobrenome(),
						hospede.getDataNascimento(), hospede.getNacionalidade(), hospede.getTelefone(),
						hospede.getIdReserva() });
			}
		} catch (Exception e) {
			// Lança exceção caso ocorra algum erro
			throw e;
		}
	}

	// Método que atualiza os dados de uma reserva na tabela tbReservas
	private void atualizarReservas() {

		// Verifica se há uma célula selecionada na tabela de reservas
		Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
				.ifPresentOrElse(
						// Se houver, então atualiza os dados da reserva
						fila -> {
							// Recupera os dados da reserva selecionada
							Date DataEntrada = Date
									.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 1).toString());
							Date DataSaida = Date.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 2).toString());
							String Valor = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 3);
							String FormaPagamento = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 4);
							Integer id = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());

							// Chama o método de atualização da reserva no controlador
							this.reservaController.atualizar(DataEntrada, DataSaida, Valor, FormaPagamento, id);

							// Exibe uma mensagem de sucesso na atualização
							JOptionPane.showMessageDialog(this, String.format("Registro modificado com sucesso"));
						},
						// Se não houver, exibe uma mensagem de erro
						() -> JOptionPane.showMessageDialog(this, "Por favor, escolha um registro"));
	}

	// Método que atualiza os dados de um hóspede na tabela tbHospedes
	private void atualizarHospede() {

		// Verifica se algum item na tabela tbHospedes foi selecionado
		Optional.ofNullable(modeloHospede.getValueAt(tbHospedes.getSelectedRow(), tbHospedes.getSelectedColumn()))
				.ifPresentOrElse(filaHuesped -> {
					// Se algum item foi selecionado, pega os valores das colunas dessa linha
					String Nome = (String) modeloHospede.getValueAt(tbHospedes.getSelectedRow(), 1);
					String Sobrenome = (String) modeloHospede.getValueAt(tbHospedes.getSelectedRow(), 2);
					Date DataNascimento = Date
							.valueOf(modeloHospede.getValueAt(tbHospedes.getSelectedRow(), 3).toString());
					String Nacionalidade = (String) modeloHospede.getValueAt(tbHospedes.getSelectedRow(), 4);
					String Telefone = (String) modeloHospede.getValueAt(tbHospedes.getSelectedRow(), 5);
					Integer idReserva = Integer
							.valueOf(modeloHospede.getValueAt(tbHospedes.getSelectedRow(), 6).toString());
					Integer id = Integer.valueOf(modeloHospede.getValueAt(tbHospedes.getSelectedRow(), 0).toString());
					// Chama o método atualizar do controller de hóspedes passando os valores pegos
					// da tabela
					this.hospedesController.atualizar(Nome, Sobrenome, DataNascimento, Nacionalidade, Telefone,
							idReserva, id);
					// Mostra uma mensagem de sucesso na atualização
					JOptionPane.showMessageDialog(this, String.format("Registro modificado com êxito"));
				}, () -> JOptionPane.showMessageDialog(this, "Por favor, escolha um registro"));
	}

	// Método para salvar as coordenadas do mouse ao clicar no cabeçalho da janela
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	// Método para permitir o arrasto da janela pelo cabeçalho
	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}
}

