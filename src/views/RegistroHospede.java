package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

import controller.HospedesController;
import controller.ReservasController;
import modelo.Hospedes;
import modelo.Reservas;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.Format;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class RegistroHospede extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtTelefone;
	private JTextField txtNreserva;
	private JDateChooser txtDataN;
	private JComboBox<Format> txtNacionalidade;
	private HospedesController hospedesController;
	private ReservasController reservasController;
	private JLabel labelExit;
	private JLabel labelAtras;
	int xMouse, yMouse;
	int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroHospede frame = new RegistroHospede(0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public RegistroHospede(int idReserva) throws SQLException {
		this.hospedesController = new HospedesController();
		this.reservasController = new ReservasController();
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroHospede.class.getResource("/imagenes/lOGO-50PX.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 634);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		
		JPanel header = new JPanel();
		header.setLayout(null);
		header.setBackground(SystemColor.text);
		header.setOpaque(false);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReservasView reservas = new ReservasView();
				reservas.setVisible(true);
				dispose();				
			}
			@Override
			
			//MUDAR COR DO BOTÃO
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(210, 210, 210));
				labelAtras.setForeground(Color.blue);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(new Color(210, 210, 210));
			     labelAtras.setForeground(Color.BLACK);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(new Color(210, 210, 210));
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("🢀");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setForeground(Color.BLACK);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNome.setBounds(560, 135, 285, 33);
		txtNome.setBackground(Color.WHITE);
		txtNome.setColumns(10);
		txtNome.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtNome);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtSobrenome.setBounds(560, 204, 285, 33);
		txtSobrenome.setColumns(10);
		txtSobrenome.setBackground(Color.WHITE);
		txtSobrenome.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtSobrenome);
		
		txtDataN = new JDateChooser();
		txtDataN.setBounds(560, 278, 285, 36);
		txtDataN.getCalendarButton().setIcon(new ImageIcon(RegistroHospede.class.getResource("/imagenes/icon-reservas.png")));
		txtDataN.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtDataN.setDateFormatString("yyyy-MM-dd");
		contentPane.add(txtDataN);
		
		txtNacionalidade = new JComboBox();
		txtNacionalidade.setBounds(560, 350, 289, 36);
		txtNacionalidade.setBackground(SystemColor.text);
		txtNacionalidade.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		txtNacionalidade.setModel(new DefaultComboBoxModel(new String[] {"Afeganistão", "Alemanha", "Árabia Saudita", "Argentina", "Australia", "Belgica", "Bolivia", "Brasil", "Camboja", "Canadar", "Chile", "China", "Colombia", "Coreia", "Costa Rica", "Cuba", "Dinamarca", "Equador", "Egíto", "Salvador", "Escócia", "Espanha", "Estadoul", "Estonia", "Estados Unidos", "etíopia", "Filipinas", "Finlandia", "frança", "Pais de Galês", "Grecia", "Quatemala", "Haiti", "Holanda", "Honduras", "Indonésia", "Inglaterra", "Iraque", "Irania", "Irlanda", "Israel", "Italia", "Japão", "Jordania", "Laosia", "letonia", "Libania", "Malia", "Marrocos", "Mexico", "Nicaragua", "Noruegua", "Nova Zelandia", "Panama", "Paraguai", "Peru", "Polonia", "Brasil", "Portorrico", "Domenia", "Romenia", "Russia", "Suecia", "Suíça", "Tailandia", "Taiwan", "Turquia", "Ucrania", "Uruguai", "Venezuela", "Vietna"}));
		contentPane.add(txtNacionalidade);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setBounds(562, 108, 253, 25);
		lblNome.setForeground(SystemColor.textInactiveText);
		lblNome.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		contentPane.add(lblNome);
		
		JLabel lblSobrenome = new JLabel("SOBRENOME");
		lblSobrenome.setBounds(560, 189, 255, 14);
		lblSobrenome.setForeground(SystemColor.textInactiveText);
		lblSobrenome.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		contentPane.add(lblSobrenome);
		
		JLabel lblNascimento = new JLabel("DATA DE NASCIMENTO");
		lblNascimento.setBounds(560, 256, 255, 14);
		lblNascimento.setForeground(SystemColor.textInactiveText);
		lblNascimento.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		contentPane.add(lblNascimento);
		
		JLabel lblNacionalidade = new JLabel("Pais");
		lblNacionalidade.setBounds(560, 326, 255, 14);
		lblNacionalidade.setForeground(SystemColor.textInactiveText);
		lblNacionalidade.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		contentPane.add(lblNacionalidade);
		
		JLabel lblTelefone = new JLabel("TELEFONE");
		lblTelefone.setBounds(562, 406, 253, 14);
		lblTelefone.setForeground(SystemColor.textInactiveText);
		lblTelefone.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		contentPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtTelefone.setBounds(560, 424, 285, 33);
		txtTelefone.setColumns(10);
		txtTelefone.setBackground(Color.WHITE);
		txtTelefone.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtTelefone);
		
		JLabel lblNewLabel_4 = new JLabel("REGISTRO HÓSPEDE");
		lblNewLabel_4.setBounds(606, 55, 234, 42);
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 23));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNreserva = new JLabel("NÚMERO DE RESERVA");
		lblNreserva.setBounds(560, 474, 253, 14);
		lblNreserva.setForeground(SystemColor.textInactiveText);
		lblNreserva.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		contentPane.add(lblNreserva);
		
		txtNreserva = new JTextField();

		txtNreserva.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		txtNreserva.setBounds(560, 495, 285, 33);
		txtNreserva.setColumns(10);
		txtNreserva.setBackground(Color.WHITE);
		txtNreserva.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtNreserva.setEditable(false);
		System.out.println(idReserva);
		String id = String.valueOf(idReserva);
		txtNreserva.setText(id);
		contentPane.add(txtNreserva);



		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(560, 170, 289, 2);
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2);
		
		JSeparator separator_1_2_1 = new JSeparator();
		separator_1_2_1.setBounds(560, 240, 289, 2);
		separator_1_2_1.setForeground(new Color(12, 138, 199));
		separator_1_2_1.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_1);
		
		JSeparator separator_1_2_2 = new JSeparator();
		separator_1_2_2.setBounds(560, 314, 289, 2);
		separator_1_2_2.setForeground(new Color(12, 138, 199));
		separator_1_2_2.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_2);
		
		JSeparator separator_1_2_3 = new JSeparator();
		separator_1_2_3.setBounds(560, 386, 289, 2);
		separator_1_2_3.setForeground(new Color(12, 138, 199));
		separator_1_2_3.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_3);
		
		JSeparator separator_1_2_4 = new JSeparator();
		separator_1_2_4.setBounds(560, 457, 289, 2);
		separator_1_2_4.setForeground(new Color(12, 138, 199));
		separator_1_2_4.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_4);
		
		JSeparator separator_1_2_5 = new JSeparator();
		separator_1_2_5.setBounds(560, 529, 289, 2);
		separator_1_2_5.setForeground(new Color(12, 138, 199));
		separator_1_2_5.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_5);
		
		JPanel btnSalvar = new JPanel();
		btnSalvar.setBounds(723, 560, 122, 35);
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				salvarHospede();
			}
		});
		btnSalvar.setLayout(null);
		btnSalvar.setBackground(new Color(12, 138, 199));
		contentPane.add(btnSalvar);
		btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel labelSalvar = new JLabel("SALVAR ✅");
		labelSalvar.setHorizontalAlignment(SwingConstants.CENTER);
		labelSalvar.setForeground(Color.WHITE);
		labelSalvar.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelSalvar.setBounds(0, 0, 122, 35);
		btnSalvar.add(labelSalvar);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 489, 634);
		panel.setBackground(new Color(210, 210, 210));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel imagemFundo = new JLabel("");
		imagemFundo.setBounds(0, 121, 479, 502);
		panel.add(imagemFundo);
		imagemFundo.setIcon(new ImageIcon(RegistroHospede.class.getResource("/imagenes/registro.png")));
		
		JLabel logo = new JLabel("");
		logo.setBounds(194, 39, 104, 107);
		panel.add(logo);
		logo.setIcon(new ImageIcon(RegistroHospede.class.getResource("/imagenes/Ha-100px.png")));
		
		JPanel btnexit = new JPanel();
		btnexit.setBounds(857, 0, 53, 36);
		contentPane.add(btnexit);
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal principal = new MenuPrincipal();
				principal.setVisible(true);
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
		btnexit.setBackground(Color.white);
		
		labelExit = new JLabel("❌");
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(SystemColor.black);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
	}
	

	private void salvarHospede() {
		
			if (txtDataN.getDate() != null && !txtNome.equals("") && !txtSobrenome.equals("") && !txtTelefone.equals("")) {
				String dataNascimento = ((JTextField) txtDataN.getDateEditor().getUiComponent()).getText();
				int nreserva = Integer.parseInt(txtNreserva.getText());
				Hospedes hospedes = new Hospedes(txtNome.getText(), txtSobrenome.getText(),  java.sql.Date.valueOf(dataNascimento), txtNacionalidade.getSelectedItem().toString(), txtTelefone.getText(), nreserva);
				this.hospedesController.salvar(hospedes);
				Sucesso sucesso = new Sucesso();
				sucesso.setVisible(true);
				dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Você deve preencher todos os campos.");
			}									
	}

}
