package views;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main {

	public static void main(String[] args) {
		// Mostra mensagem de boas vindas ao sistema
		UIManager.put("OptionPane.okButtonText", "Entrar");
		ImageIcon icon = new ImageIcon("src/imagenes/aH-40px.png");
		
		int option = JOptionPane.showOptionDialog(null, "Bem-vindo ao Hotel Alura One!", "Sistema HotelAluraOne",
		                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, null, null);

		
		if (option == JOptionPane.OK_OPTION) {
			try {
				// O look and feel define a aparência e o comportamento da interface gráfica do usuário 
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				
				// Cria a tela principal do sistema
				MenuPrincipal frame = new MenuPrincipal();
				
				// Exibe a tela principal do sistema
				frame.setVisible(true);
			} catch (Exception e) {
				// Mostra mensagem de erro caso ocorra algum problema ao iniciar a aplicação
				JOptionPane.showMessageDialog(null, "Erro ao iniciar a aplicação: " + e.getMessage());
			}
		}
	}
}
