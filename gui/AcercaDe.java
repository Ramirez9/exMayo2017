package exMayo2017FranciscoRamirezRuiz.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

/**
 * Clase AcerdaDe
 * 
 * @author Francisco Ramirez
 * @version 1.0
 *
 */
public class AcercaDe extends JDialog {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AcercaDe dialog = new AcercaDe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AcercaDe() {
		setModal(true);
		setTitle("Acerca de. Examen Mayo 2017");
		setResizable(false);
		setBounds(100, 100, 319, 272);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html><p>IES GRAN CAPIT\u00C1N.</p>\r\nversi\u00F3n 1.0.</html>");
		lblNewLabel.setBounds(83, 11, 191, 63);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html><p>M\u00F3dulo: Programaci\u00F3n</p>\r\nMayo de 2017</html>");
		lblNewLabel_1.setBounds(80, 101, 147, 39);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblFranciscoRamrezRuiz = new JLabel("<html>Francisco Ram\u00EDrez Ruiz</html>");
		lblFranciscoRamrezRuiz.setBounds(83, 186, 144, 14);
		contentPanel.add(lblFranciscoRamrezRuiz);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
