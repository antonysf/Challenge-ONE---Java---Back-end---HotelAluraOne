package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.SystemColor;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class MenuUsuario extends JFrame {

	private JPanel contentPane;
	int xMouse, yMouse;
	private JLabel labelExit;
	private JLabel labelRegistro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUsuario frame = new MenuUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuUsuario.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 609);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JPanel header = new JPanel();
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
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(210, 210, 210));
		panelMenu.setBounds(0, 0, 257, 609);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(50, 58, 150, 150);
		panelMenu.add(logo);
		logo.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/aH-150px.png")));
		
		
		
		
		
		JPanel btnRegistro = new JPanel();
		btnRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistro.setBackground(new Color(118, 187, 223));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistro.setBackground(new Color(210, 210, 210));	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ReservasView reservas = new ReservasView();
				reservas.setVisible(true);
				dispose();
			}
		});
		btnRegistro.setBounds(0, 255, 257, 56);
		btnRegistro.setBackground(new Color(210, 210, 210));
		panelMenu.add(btnRegistro);
		btnRegistro.setLayout(null);
		btnRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		labelRegistro = new JLabel("Registro de reservas");
		labelRegistro.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/reservado.png")));
		labelRegistro.setForeground(new Color(0, 0, 0));
		labelRegistro.setBounds(25, 11, 205, 34);
		labelRegistro.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelRegistro.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistro.add(labelRegistro);
		
		JPanel btnBuscar = new JPanel();
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscar.setBackground(new Color(118, 187, 223));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBuscar.setBackground(new Color(210, 210, 210));	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Busca busca = new Busca();
				busca.setVisible(true);
				dispose();
			}
		});
		btnBuscar.setBounds(0, 312, 257, 56);
		btnBuscar.setBackground(new Color(210, 210, 210));
		panelMenu.add(btnBuscar);
		btnBuscar.setLayout(null);
		btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel lblBuscaDeReservas = new JLabel("Busca");
		lblBuscaDeReservas.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/pessoas.png")));
		lblBuscaDeReservas.setBounds(27, 11, 200, 34);
		lblBuscaDeReservas.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuscaDeReservas.setForeground(new Color(0, 0, 0));
		lblBuscaDeReservas.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnBuscar.add(lblBuscaDeReservas);
		
		
		

		JPanel btnSair = new JPanel();
        btnSair.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnSair.setBackground(new Color(118, 187, 223));               
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnSair.setBackground(new Color(210, 210, 210));    
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        btnSair.setBounds(0, 378, 257, 56);
        btnSair.setBackground(new Color(210, 210, 210));
        panelMenu.add(btnSair);
        btnSair.setLayout(null);
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        JLabel lblSair = new JLabel("Sair");
        lblSair.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/cerrar-sesion 32-px.png")));
        lblSair.setBounds(27, 11, 200, 34);
        lblSair.setHorizontalAlignment(SwingConstants.LEFT);
        lblSair.setForeground(new Color(0, 0, 0));
        lblSair.setFont(new Font("Roboto", Font.PLAIN, 18));
        btnSair.add(lblSair);

		
		
		
		
		
		
		
		
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(26, 219, 201, 2);
		panelMenu.add(separator);
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 944, 36);
		contentPane.add(header);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
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
		btnexit.setBounds(891, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("❌");
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		
	    JPanel panelData = new JPanel();
	    panelData.setBackground(new Color(230, 230, 230));
	    panelData.setBounds(256, 84, 688, 121);
	    contentPane.add(panelData);
	    panelData.setLayout(null);
	    
	    JLabel lblTituloPrincipal = new JLabel("Sistema de reservas Hotel AluraOne");
	    lblTituloPrincipal.setBounds(180, 11, 356, 42);
	    panelData.add(lblTituloPrincipal);
	    lblTituloPrincipal.setForeground(new Color(0, 128, 255));
	    lblTituloPrincipal.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
	    
	    JLabel labelData = new JLabel("New label");
	    labelData.setBounds(43, 74, 294, 36);
	    panelData.add(labelData);
	    labelData.setForeground(new Color(0, 97, 193));
	    labelData.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 21));
	    Date dataAtual = new Date(); //data e hora atuais
	    String data = new SimpleDateFormat("dd/MM/yyyy").format(dataAtual); //formata a data numa string
	    labelData.setText("Hoje é " + data); //estabelece a data na label
	    
	    JLabel lblTitulo = new JLabel("Bem-vindo");
	    lblTitulo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));
	    lblTitulo.setBounds(299, 216, 147, 46);
	    contentPane.add(lblTitulo);
	    
	    String textoDescricao = "<html><body>Sistema de reservas de hotéis. Controle e gerencie de forma otimizada e fácil <br> o fluxo de reservas e hóspedes do hotel   </body></html>";
	    JLabel labelDescricao = new JLabel(textoDescricao);
	    labelDescricao.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 17));
	   
	    labelDescricao.setBounds(309, 283, 598, 66);
	    contentPane.add(labelDescricao);
	    
	    String textoDescricao1 = "<html><body> Esta ferramenta permitirá que você mantenha um controle completo e detalhado de suas reservas e hóspedes, você terá acesso a ferramentas especiais para tarefas específicas como:</body></html>";
	    JLabel labelDescricao_1 = new JLabel(textoDescricao1);
	    labelDescricao_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 17));
	    labelDescricao_1.setBounds(309, 339, 569, 88);
	    contentPane.add(labelDescricao_1);
	    
	    JLabel lblDescricao_3 = new JLabel("📃 Registro de Reservas e Hóspedes");
	    lblDescricao_3.setFont(new Font("Dialog", Font.PLAIN, 17));
	    lblDescricao_3.setBounds(309, 438, 295, 27);
	    contentPane.add(lblDescricao_3);
	    
	    JLabel lblDescricao_4 = new JLabel("📝 Edição de Reservas e Hóspedes existentes");
	    lblDescricao_4.setForeground(new Color(0, 97, 193));
	    lblDescricao_4.setFont(new Font("Roboto", Font.PLAIN, 17));
	    lblDescricao_4.setBounds(309, 476, 355, 27);
	    contentPane.add(lblDescricao_4);
	    
	    JLabel lblDescricao_5 = new JLabel("❌ Excluir todos os tipos de registros");
	    lblDescricao_5.setForeground(new Color(255, 0, 0));
	    lblDescricao_5.setFont(new Font("Roboto", Font.PLAIN, 17));
	    lblDescricao_5.setBounds(309, 514, 295, 27);
	    contentPane.add(lblDescricao_5);
	}
	
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }
}
