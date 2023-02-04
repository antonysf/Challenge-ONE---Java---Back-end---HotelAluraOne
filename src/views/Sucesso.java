package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Sucesso extends JDialog {

	// Painel conteúdo da janela
	private final JPanel contentPanel = new JPanel();

	/**
	 * Inicia a aplicação.
	 */
	public static void main(String[] args) {
		try {
			// Cria uma nova instância da classe Sucesso
			Sucesso dialog = new Sucesso();
			
			// Define a operação padrão ao fechar a janela
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			// Torna a janela visível
			dialog.setVisible(true);
		} catch (Exception e) {
			// Trata a exceção lançada na criação da janela Sucesso
			e.printStackTrace();
		}
	}

	// Cria a janela.	 
	public Sucesso() {
		// Define a imagem do ícone da janela
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sucesso.class.getResource("/imagenes/aH-40px.png")));
		
		// Dimensões da janela
		setBounds(100, 100, 394, 226);
		
		// Layout do painel de conteúdo da janela
		getContentPane().setLayout(new BorderLayout());
		
		// Fundo do painel de conteúdo
		contentPanel.setBackground(SystemColor.control);
		
		// Adiciona uma borda vazia no painel de conteúdo
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		// Adiciona o painel de conteúdo
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		// Define a localização da janela
		setLocationRelativeTo(null);
		
		// Define o layout do painel de conteúdo
		contentPanel.setLayout(null);
		
		// Cria um novo icone
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			
			// Define o ícone imagem Ha-100px.png
			lblNewLabel.setIcon(new ImageIcon(Sucesso.class.getResource("/imagenes/Ha-100px.png")));
			
			// Define as dimensões do icone
			lblNewLabel.setBounds(141, 11, 100, 100);
			contentPanel.add(lblNewLabel);
		}		
		
		{
			// Cria uma janela para exibir a mensagem "Registro adicionado com sucesso".
			JLabel lblNewLabel_1 = new JLabel("Registro adicionado com sucesso");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			
			// Define a cor da fonte como azul escuro.
			lblNewLabel_1.setForeground(new Color (12, 138, 199));
			
			// Define a fonte como arial, negrito e tamanho 18.
			lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
			
			// Define a posição e o tamanho
			lblNewLabel_1.setBounds(34, 110, 303, 21);
			
			
			contentPanel.add(lblNewLabel_1);
		}
		{
			// Cria um novo painel "buttonPane".
			JPanel buttonPane = new JPanel();
			
			// Define o layout do painel
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			
			// Adiciona o painel buttonPane no fundo da janela.
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				// Cria um novo botão 
				JButton okButton = new JButton("OK");
				okButton.setHorizontalAlignment(SwingConstants.LEFT);
				
				// Adiciona uma ação no botão okButton
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Fecha a janela
						dispose();
						
						// Cria uma nova instância da classe MenuUsuario
						MenuUsuario usuario = new MenuUsuario();
						
						// Exibe a janela MenuUsuario
						usuario.setVisible(true);
					}
				});
				
				// Define o comando do botão okButton
				okButton.setActionCommand("OK");
				
				// Adiciona o botão okButton no painel buttonPane
				buttonPane.add(okButton);
				
				// Define o botão okButton como o botão padrão para a janela.
				getRootPane().setDefaultButton(okButton);
			}
			{
				// Cria um novo botão cancelButton.
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
