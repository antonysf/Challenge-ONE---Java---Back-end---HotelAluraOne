package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import controller.ReservasController;
import modelo.Reservas;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.sql.Date;
import java.text.Format;
import java.util.Calendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Toolkit;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class ReservasView extends JFrame {

	private JPanel contentPane;
	public static JTextField txtValor;
	public static JDateChooser txtDataEntrada;
	public static JDateChooser txtDataSaida;
	public static JComboBox<Format> txtFormaPagamento;	
	int xMouse, yMouse;
	private JLabel labelExit;
	private JLabel lblNewLabel_3; 
	private JLabel labelAtras;
	private ReservasController reservasController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservasView frame = new ReservasView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame 
	 */
	public ReservasView() {
		super("Reserva");
		this.reservasController = new ReservasController();

		setIconImage(Toolkit.getDefaultToolkit().getImage(ReservasView.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 560);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		

		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 910, 560);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(SystemColor.textHighlight);
		separator_1_2.setBounds(68, 195, 289, 2);
		separator_1_2.setBackground(SystemColor.textHighlight);
		panel.add(separator_1_2);
		
		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setForeground(SystemColor.textHighlight);
		separator_1_3.setBackground(SystemColor.textHighlight);
		separator_1_3.setBounds(68, 453, 289, 2);
		panel.add(separator_1_3);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(SystemColor.textHighlight);
		separator_1_1.setBounds(68, 281, 289, 11);
		separator_1_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1_1);
		
		txtDataEntrada = new JDateChooser();
		txtDataEntrada.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtDataEntrada.getCalendarButton().setBackground(new Color(240, 240, 240));
		txtDataEntrada.getCalendarButton().setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/icon-reservas.png")));
		txtDataEntrada.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
		txtDataEntrada.setBounds(68, 161, 289, 35);
		txtDataEntrada.getCalendarButton().setBounds(268, 0, 21, 33);
		txtDataEntrada.setBackground(Color.WHITE);
		txtDataEntrada.setBorder(new LineBorder(SystemColor.window));
		txtDataEntrada.setDateFormatString("yyyy-MM-dd");
		txtDataEntrada.setFont(new Font("Roboto", Font.PLAIN, 18));
		panel.add(txtDataEntrada);
		
		lblNewLabel_3 = new JLabel("R$");
		lblNewLabel_3.setBounds(121, 332, 21, 25);
		lblNewLabel_3.setForeground(SystemColor.textHighlight);
		lblNewLabel_3.setFont(new Font("Roboto", Font.BOLD, 17));
		lblNewLabel_3.setEnabled(false);
		panel.add(lblNewLabel_3);
		
		JLabel lblCheckIn = new JLabel("DATA DE CHECK IN");
		lblCheckIn.setForeground(SystemColor.textInactiveText);
		lblCheckIn.setBounds(68, 136, 169, 14);
		lblCheckIn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		panel.add(lblCheckIn);
		
		JLabel lblCheckOut = new JLabel("DATA DE CHECK OUT");
		lblCheckOut.setForeground(SystemColor.textInactiveText);
		lblCheckOut.setBounds(68, 221, 187, 14);
		lblCheckOut.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		panel.add(lblCheckOut);
		
		txtDataSaida = new JDateChooser();
		txtDataSaida.setForeground(new Color(0, 0, 0));
		txtDataSaida.getCalendarButton().setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/icon-reservas.png")));
		txtDataSaida.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 11));
		txtDataSaida.setBounds(68, 246, 289, 35);
		txtDataSaida.getCalendarButton().setBounds(267, 1, 21, 31);
		txtDataSaida.setBackground(Color.WHITE);
		txtDataSaida.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtDataSaida.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				calcularValor(txtDataEntrada, txtDataSaida);
				lblNewLabel_3.setVisible(true);
			}
		});
		txtDataSaida.setDateFormatString("yyyy-MM-dd");
		txtDataSaida.getCalendarButton().setBackground(new Color(240, 240, 240));
		txtDataSaida.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		panel.add(txtDataSaida);
		
	
		
		txtValor = new JTextField();
		txtValor.setBackground(SystemColor.text);
		txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtValor.setForeground(Color.BLACK);
		txtValor.setBounds(78, 328, 43, 33);
		txtValor.setEditable(false);
		txtValor.setFont(new Font("Roboto Black", Font.BOLD, 17));
		txtValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblValor = new JLabel("VALOR DA RESERVA");
		lblValor.setForeground(SystemColor.textInactiveText);
		lblValor.setBounds(72, 303, 196, 14);
		lblValor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		panel.add(lblValor);
		
		txtFormaPagamento = new JComboBox();
		txtFormaPagamento.setForeground(new Color(0, 128, 255));
		txtFormaPagamento.setBounds(68, 417, 289, 38);
		txtFormaPagamento.setBackground(SystemColor.text);
		txtFormaPagamento.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		txtFormaPagamento.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtFormaPagamento.setModel(new DefaultComboBoxModel(new String[] {" 💳 Crédito", " 💳 Débito", " 💵 Dinheiro"}));
		panel.add(txtFormaPagamento);
		
		JLabel lblFormaPagamento = new JLabel("FORMA DE PAGAMENTO");
		lblFormaPagamento.setForeground(SystemColor.textInactiveText);
		lblFormaPagamento.setBounds(68, 382, 187, 24);
		lblFormaPagamento.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		panel.add(lblFormaPagamento);
		
		JLabel lblTitulo = new JLabel("SISTEMA DE RESERVAS");
		lblTitulo.setBounds(109, 60, 219, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto", Font.BOLD, 18));
		panel.add(lblTitulo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(428, 0, 482, 560);
		panel_1.setBackground(new Color(230, 230, 230));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(197, 68, 104, 107);
		panel_1.add(logo);
		logo.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/Ha-100px.png")));
		
		JLabel imagemFundo = new JLabel("");
		imagemFundo.setBounds(0, 140, 500, 409);
		panel_1.add(imagemFundo);
		imagemFundo.setBackground(Color.WHITE);
		imagemFundo.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/reservas-img-3.png")));
		
		JPanel btnexit = new JPanel();
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
				btnexit.setBackground(new Color(230, 230, 230));
				labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(new Color(230, 230, 230));
		btnexit.setBounds(429, 0, 53, 36);
		panel_1.add(btnexit);
		
		labelExit = new JLabel("❌");
		labelExit.setBackground(new Color(230, 230, 230));
		labelExit.setForeground(Color.BLACK);
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		
		
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
		panel.add(header);
		
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
		
		labelAtras = new JLabel("🢀");
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.textHighlight);
		separator_1.setBounds(68, 362, 289, 2);
		separator_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1);
		
		JPanel btnProximo = new JPanel();
		btnProximo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (ReservasView.txtDataEntrada.getDate() != null && ReservasView.txtDataSaida.getDate() != null) {	
					
					salvarReserva();
				} else {
					JOptionPane.showMessageDialog(null, "Deve preencher todos os campos.");
				}
			}						
		});
		btnProximo.setLayout(null);
		btnProximo.setBackground(SystemColor.textHighlight);
		btnProximo.setBounds(238, 493, 122, 35);
		panel.add(btnProximo);
		btnProximo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel lblProximo = new JLabel("PRÓXIMO 🢂");
		lblProximo.setHorizontalAlignment(SwingConstants.CENTER);
		lblProximo.setForeground(Color.WHITE);
		lblProximo.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblProximo.setBounds(0, 0, 122, 35);
		btnProximo.add(lblProximo);
	}

	private void calcularValor(JDateChooser dataE,JDateChooser dataS) {
		if(dataE.getDate() != null && dataS.getDate() !=null) {
			Calendar inicio = dataE.getCalendar();
			Calendar fin = dataS.getCalendar();
			int dias = -1;
			int diaria = 180;
			int valor;
			
			while(inicio.before(fin)||inicio.equals(fin)) {
				dias++;
				inicio.add(Calendar.DATE,1);
			}
			valor = dias * diaria;
			txtValor.setText("" + valor);
		}
	}

	private void salvarReserva() {
		try {
			String dataEntrada = ((JTextField)txtDataEntrada.getDateEditor().getUiComponent()).getText();
			String dataSaida = ((JTextField)txtDataSaida.getDateEditor().getUiComponent()).getText();
			
			Reservas reservas = new Reservas(Date.valueOf(dataEntrada), Date.valueOf(dataSaida), ReservasView.txtValor.getText(), ReservasView.txtFormaPagamento.getSelectedItem().toString());
			this.reservasController.salvar(reservas);
			
			
			
			
			
			JOptionPane.showMessageDialog(contentPane, "Registro salvo com sucesso");
			
			
			
			
			
			RegistroHospede hospede = new RegistroHospede(reservas.getId());
			hospede.setVisible(true);
			dispose();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(contentPane, "Error: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}
}