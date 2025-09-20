package Textbook_selling_system;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.SwingUtilities;
import java.awt.Font;

/**
 * 
 *
 */

public class Book_selling_system {


	public static void main(String args[])
	{
		// Try to set Nimbus look-and-feel for a more modern appearance
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus isn't available, fall back to default LAF
		}

		// Set some sensible defaults (fonts) to modern San-Serif
		UIManager.put("Label.font", new Font("Segoe UI", Font.PLAIN, 14));
		UIManager.put("Button.font", new Font("Segoe UI", Font.PLAIN, 14));
		UIManager.put("TextField.font", new Font("Segoe UI", Font.PLAIN, 14));
		UIManager.put("PasswordField.font", new Font("Segoe UI", Font.PLAIN, 14));

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Main_screen ms = new Main_screen();
				ms.setTitle("Book Selling System");
				ms.setVisible(true);
			}
		});
	}
}
