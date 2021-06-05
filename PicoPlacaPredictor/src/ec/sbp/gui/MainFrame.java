package ec.sbp.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import ec.sbp.acciones.Car;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;


public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlacaLetras;
	private JTextField txtPlacaNumeros;
	private JTextField txtHora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 445);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOpciones = new JMenu("Opciones");
		mnOpciones.setHorizontalAlignment(SwingConstants.RIGHT);
		mnOpciones.setFont(new Font("Arial", Font.PLAIN, 15));
		menuBar.add(mnOpciones);
		
		//Ayuda configuration
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"INSTRUCCIONES:\r\n"
						+ "\r\n"
						+ "1. En el primer campo ingresar solo las letras de la  placa. \r\n"
						+ "\r\n"
						+ "2. En el segundo campo ingresar solo los números de la  placa. \r\n"
						+ "\r\n"
						+ "3. Seleccionar la fecha / Por defecto se establece la fecha actual.\r\n"
						+ "\r\n"
						+ "4. Ingresar la hora / Por defecto se establece la hora actual.\r\n"
						+ "\r\n"
						+ "5. Click en el botón \"Enviar\"");
			}
		});
		mntmAyuda.setFont(new Font("Arial", Font.PLAIN, 12));
		mnOpciones.add(mntmAyuda);
		
		//Salir configuration
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmSalir.setFont(new Font("Arial", Font.PLAIN, 12));
		mnOpciones.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("\"Pico y Placa\" Predictor");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 35));
		lblTitulo.setBackground(Color.WHITE);
		lblTitulo.setBounds(10, 10, 504, 52);
		contentPane.add(lblTitulo);
		
		JLabel lblPlaca = new JLabel("Placa: ");
		lblPlaca.setForeground(Color.LIGHT_GRAY);
		lblPlaca.setFont(new Font("Arial", Font.PLAIN, 25));
		lblPlaca.setBounds(44, 104, 127, 36);
		contentPane.add(lblPlaca);
		
		JLabel lblFecha = new JLabel("Fecha: ");
		lblFecha.setForeground(Color.LIGHT_GRAY);
		lblFecha.setFont(new Font("Arial", Font.PLAIN, 25));
		lblFecha.setBounds(44, 168, 127, 36);
		contentPane.add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora: ");
		lblHora.setForeground(Color.LIGHT_GRAY);
		lblHora.setFont(new Font("Arial", Font.PLAIN, 25));
		lblHora.setBounds(44, 236, 127, 36);
		contentPane.add(lblHora);
		
		txtPlacaLetras = new JTextField();
		txtPlacaLetras.setFont(new Font("Arial", Font.PLAIN, 20));
		txtPlacaLetras.setBounds(205, 105, 127, 36);
		contentPane.add(txtPlacaLetras);
		txtPlacaLetras.setColumns(10);
		
		txtHora = new JTextField();
		txtHora.setFont(new Font("Arial", Font.PLAIN, 20));
		txtHora.setColumns(10);
		txtHora.setBounds(205, 237, 263, 36);
		contentPane.add(txtHora);
		
		//Date
		JDateChooser dcFecha = new JDateChooser();
		dcFecha.setBounds(205, 168, 263, 36);
		contentPane.add(dcFecha);
		
		
		//Button configuration
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Write the button's code here
				//variables
				String PlacaLetras = txtPlacaLetras.getText();
				int PlacaNumeros = Integer.parseInt(txtPlacaNumeros.getText());
				
				//date
				Date date = dcFecha.getDate();
				Calendar calendario = Calendar.getInstance();
				calendario.setTime(date);
				int dia = calendario.get(Calendar.DAY_OF_WEEK);
				
				//hour
				
				//acción
				boolean circula = false;
				Car carro = new Car();
				circula = carro.Circula(PlacaNumeros, dia);
				
				if (circula == true) {
					JOptionPane.showMessageDialog(null, "Puede Circular");
				}else {
					JOptionPane.showMessageDialog(null, "No Puede Circular");
				}
			}
		});
		btnEnviar.setForeground(Color.DARK_GRAY);
		btnEnviar.setBackground(Color.LIGHT_GRAY);
		btnEnviar.setFont(new Font("Arial", Font.BOLD, 15));
		btnEnviar.setBounds(195, 306, 127, 36);
		contentPane.add(btnEnviar);
		
		txtPlacaNumeros = new JTextField();
		txtPlacaNumeros.setFont(new Font("Arial", Font.PLAIN, 20));
		txtPlacaNumeros.setColumns(10);
		txtPlacaNumeros.setBounds(341, 105, 127, 36);
		contentPane.add(txtPlacaNumeros);
		
		
		
		
	}
}
