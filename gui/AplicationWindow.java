package exMayo2017FranciscoRamirezRuiz.gui;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAccessor;

import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;

import exMayo2017FranciscoRamirezRuiz.funcionalidad.ContinuarAbortar;
import exMayo2017FranciscoRamirezRuiz.funcionalidad.ErrorAlGuardarException;
import exMayo2017FranciscoRamirezRuiz.funcionalidad.ErrorAlLeerException;
import exMayo2017FranciscoRamirezRuiz.funcionalidad.General;

import java.io.File;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

/**
 * Para las operaciones del tiempo debes usar las clases LocalDate,
 * 
 * @author Francisco Ramírez Ruiz
 *
 */
public class AplicationWindow {
	private static final String SIN_NOMBRE = "Sin nombre";
	private static final LocalDate FECHA_ACTUAL = LocalDate.now();
	static FileNameExtensionFilter filter = new FileNameExtensionFilter("Binarios", "fec");
	static JFileChooser jFileChooser = new JFileChooser();

	static {
		jFileChooser.setFileFilter(filter);
	}
	private JFrame frmExamenMayo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicationWindow window = new AplicationWindow();
					window.frmExamenMayo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExamenMayo = new JFrame();
		frmExamenMayo.setTitle("Examen Mayo 2016");
		actualizarTitulo(AplicationWindow.SIN_NOMBRE);

		frmExamenMayo.setBounds(100, 100, 450, 300);
		frmExamenMayo.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmExamenMayo.setJMenuBar(menuBar);

		JMenu mnHola = new JMenu("Hola");
		mnHola.setMnemonic('H');
		menuBar.add(mnHola);

		JMenuItem mntmError = new JMenuItem("Error");
		mntmError.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mntmError, "Error", "No puedes ser negativo", JOptionPane.ERROR_MESSAGE);
			}
		});
		mntmError.setMnemonic('e');
		mnHola.add(mntmError);

		JMenuItem mntmAdvierte = new JMenuItem("Advierte");
		mntmAdvierte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mntmAdvierte, "Cuidadín", "Esto es una advertencia",
						JOptionPane.WARNING_MESSAGE);
			}
		});
		mntmAdvierte.setMnemonic('a');
		mnHola.add(mntmAdvierte);

		JMenuItem mntmInforma = new JMenuItem("Informa");
		mntmInforma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mntmInforma, "Esto va bien.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		mntmInforma.setMnemonic('i');
		mnHola.add(mntmInforma);

		JMenu mnPtrhgunys = new JMenu("Pregunta");
		mnPtrhgunys.setMnemonic('P');
		menuBar.add(mnPtrhgunys);

		JMenuItem mntmDosOpciones = new JMenuItem("Dos opciones...");
		mntmDosOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(mntmDosOpciones, "¿Estás seguro?", "Indeciso", JOptionPane.YES_NO_OPTION);
			}
		});
		mntmDosOpciones.setMnemonic('d');
		mnPtrhgunys.add(mntmDosOpciones);

		JMenuItem mntmTresOpciones = new JMenuItem("Tres opciones...");
		mntmTresOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tresOpciones(mntmTresOpciones);

			}

			
		});
		mntmTresOpciones.setMnemonic('t');
		mnPtrhgunys.add(mntmTresOpciones);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de... ");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcercaDe acercaDe = new AcercaDe();
				acercaDe.setVisible(true);
			}
		});
		mntmAcercaDe.setMnemonic('a');
		mnPtrhgunys.add(mntmAcercaDe);

		JMenu mnHoras = new JMenu("Fechas");
		mnHoras.setMnemonic('F');
		menuBar.add(mnHoras);

		JMenuItem mntmNueva = new JMenuItem("Nueva");
		mntmNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		mntmNueva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnHoras.add(mntmNueva);

		JMenuItem mntmAbre = new JMenuItem("Abrir");
		mntmAbre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrir();
			}
		});
		mntmAbre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnHoras.add(mntmAbre);

		JSeparator separator_1 = new JSeparator();
		mnHoras.add(separator_1);

		JMenuItem mntmGuarda = new JMenuItem("Guardar");
		mntmGuarda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		mntmGuarda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		mnHoras.add(mntmGuarda);

		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo();
			}
		});
		mnHoras.add(mntmGuardarComo);

		JSeparator separator_2 = new JSeparator();
		mnHoras.add(separator_2);

		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mntmModificar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, InputEvent.CTRL_MASK));
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();
			}
		});
		mnHoras.add(mntmModificar);

		JSeparator separator = new JSeparator();
		mnHoras.add(separator);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		mnHoras.add(mntmSalir);
	}




	protected void salir() {
		if (guardarSiModificado() == ContinuarAbortar.ABORTAR)
			return;
		System.exit(0);
	}

	protected void modificar() {
		Modificar.enlazar(General.getLocalDate());
	}

	/**
	 * @return
	 * 
	 */
	protected ContinuarAbortar guardarComo() {
		File file;
		do {
			try {
				switch (jFileChooser.showSaveDialog(frmExamenMayo)) {
				case JFileChooser.CANCEL_OPTION:
				case JFileChooser.ERROR_OPTION:
					return ContinuarAbortar.ABORTAR;
				}
				file = jFileChooser.getSelectedFile();
				if (!file.exists() || deseaReemplazarlo(file)) {
					General.guardar(file);
					actualizarTitulo(General.getNombreFile());
					return ContinuarAbortar.CONTINUAR;
				}
			} catch (ErrorAlGuardarException e) {
				JOptionPane.showMessageDialog(frmExamenMayo, e.getMessage(), "Examen Mayo 2017",
						JOptionPane.ERROR_MESSAGE);
			}
		} while (true);
	}

	/**
	 * Indica si se desea reemplazar el fichero existente en caso de existir
	 * previamente.
	 * 
	 * @param file
	 *            Fichero que va a reemplazarse
	 * @return true si el fichero existe y se desea reemplazar. false si no se
	 *         desea reemplazar o el fichero no existe
	 */
	private boolean deseaReemplazarlo(File file) {
		if (file.exists()) {
			switch (JOptionPane.showConfirmDialog(frmExamenMayo, file.getName() + " ya existe. ¿Desea reemplazarlo?",
					"Confirmar Guardar Como", JOptionPane.YES_NO_OPTION)) {
			case JOptionPane.YES_OPTION:
				return true;
			case JOptionPane.NO_OPTION:
			case JOptionPane.CLOSED_OPTION:
				return false;
			}
		}

		return false;
	}

	/**
	 * 
	 * @return ContinuarAbortar.ABORTAR si se aborta la operación.
	 *         ContinuarAbortar.CONTINUAR si se continúa
	 */
	protected ContinuarAbortar guardar() {
		if (General.getFile() == null)
			return guardarComo();
		try {
			General.guardar();
			return ContinuarAbortar.CONTINUAR;
		} catch (ErrorAlGuardarException e) {
			JOptionPane.showMessageDialog(frmExamenMayo, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return ContinuarAbortar.ABORTAR;// error al guardar
		}
	}

	/**
	 * Pregunta al usuario si guardar al ser modificada la fecha.
	 * 
	 * @return ContinuarAbortar.ABORTAR si se aborta la operación.
	 *         ContinuarAbortar.CONTINUAR si se continúa
	 * @throws IOException
	 *             Cuando hay un error en la salida de datos
	 */
	ContinuarAbortar guardarSiModificado() {
		if (General.isModificado()) {
			switch (JOptionPane.showConfirmDialog(frmExamenMayo,
					"¿Desea guardar los cambios hechos a " + General.getNombreFile() + "?", "Examen Mayo 2017",
					JOptionPane.YES_NO_CANCEL_OPTION)) {
			case JOptionPane.YES_OPTION:
				return guardar();
			case JOptionPane.NO_OPTION:
				break;
			default:
				return ContinuarAbortar.ABORTAR;// case
												// JOptionPane.CANCEL_OPTION
												// case
			}
		}
		return ContinuarAbortar.CONTINUAR;
	}

	private void actualizarTitulo(String string) {
		frmExamenMayo.setTitle("Examen Mayo 2017: " + string);
	}

	static {
		Locale.setDefault(new Locale("es", "ES"));// para que me muestre los
													// meses/días en español
	}

	/**
	 * Obtiene el mes según el idioma español de España.
	 * 
	 * @return Mes según el idioma español de España.
	 */
	String getMes(LocalDate localDate) {
		return localDate.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
	}

	/**
	 * Obtiene el día de la semana según el idioma español de España.
	 * 
	 * @param localDate
	 * 
	 * @return Día de la semana según el idioma español de España.
	 */
	String getDiaDeLaSemana(TemporalAccessor localDate) {
		return DayOfWeek.from(localDate).getDisplayName(TextStyle.FULL, Locale.getDefault());
	}
	
	
	private void tresOpciones(JMenuItem mntmTresOpciones) {
		LocalDate fecha = FECHA_ACTUAL;
		switch (JOptionPane.showConfirmDialog(mntmTresOpciones, "¿Quieres saber en qué día vives?",
				"Seleccionar una Opción", JOptionPane.YES_NO_CANCEL_OPTION)) {
		
		case JOptionPane.YES_OPTION:
			JOptionPane.showMessageDialog(mntmTresOpciones, "Hoy es " +fecha.getDayOfMonth()+
					" de "+getMes(fecha) + " de "+fecha.getYear());
			return ;
			
		case JOptionPane.NO_OPTION:
			JOptionPane.showMessageDialog(mntmTresOpciones, "Pues tú te lo pierdes. Pero que sepas que hoy es "
					+ getDiaDeLaSemana(fecha));
					
//					fecha.getDayOfWeek().
//					//Convierte WEDNESDAY en miércoles.
//					getDisplayName(TextStyle.FULL, Locale.getDefault()));
//			
			return ;
			
		default:
			JOptionPane.showMessageDialog(mntmTresOpciones, "Cancelado");
		}
	}
	
	/**
	 * Permite abrir un fichero nuevo
	 */
	private void abrir() {
		if (guardarSiModificado() == ContinuarAbortar.ABORTAR) {
			return;
		}
		if (jFileChooser.showOpenDialog(frmExamenMayo) != JFileChooser.APPROVE_OPTION)
			return;
		try {
			General.abrir(jFileChooser.getSelectedFile());
			actualizarTitulo(General.getNombreFile());

		} catch (ErrorAlLeerException e) {
			JOptionPane.showMessageDialog(frmExamenMayo, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	/**
	 * Permite crear un fichero nuevo
	 */
	private void nuevo() {
		if(guardarSiModificado()==ContinuarAbortar.ABORTAR){
			return;
		}
		General.nueva();
		actualizarTitulo(SIN_NOMBRE);
		
	}
}
