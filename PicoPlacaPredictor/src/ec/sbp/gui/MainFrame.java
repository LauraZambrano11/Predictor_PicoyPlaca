package ec.sbp.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JFormattedTextField;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import ec.sbp.acciones.Car;
import ec.sbp.acciones.Hour;


public class MainFrame extends JFrame {
	//Variables Globales
	private JPanel contentPane;
	private JFormattedTextField txtHora;
	private JFormattedTextField txtPlaca;//////
	Car carro = new Car();
	Hour hora = new Hour();
	
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
	
	//Inicio de GUI
	public MainFrame() {
		//Configuraciones iniciales
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 445);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Configuraciones de la barra menú y sus elementos
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);		
		JMenu mnOpciones = new JMenu("Opciones"); //Menú opciones
		mnOpciones.setHorizontalAlignment(SwingConstants.RIGHT);
		mnOpciones.setFont(new Font("Arial", Font.PLAIN, 15));
		menuBar.add(mnOpciones);		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda"); //Item Ayuda que despliega un pequeño manual de uso
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"INSTRUCCIONES:\r\n"
						+ "\r\n"
						+ "1. En el primer campo ingresar la  placa. \r\n"
						+ "\r\n"
						+ "2. Seleccionar la fecha en el calendario.\r\n"
						+ "\r\n"
						+ "3. Escribir la hora. Por defecto esta establecido en 00:00\r\n"
						+ "\r\n"
						+ "4. Click en el botón \"Enviar\"");
			}
		});
		mntmAyuda.setFont(new Font("Arial", Font.PLAIN, 12));
		mnOpciones.add(mntmAyuda);
		JMenuItem mntmSalir = new JMenuItem("Salir");//Item Salir que cierra la app
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmSalir.setFont(new Font("Arial", Font.PLAIN, 12));
		mnOpciones.add(mntmSalir);
		//Fin de Configuraciones de la barra menú y sus elementos
		
		//Configuración de labels
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
		lblHora.setBounds(44, 235, 127, 36);
		contentPane.add(lblHora);
		//Fin de Configuración de labels
				
		/////INICIO DE CONFIGURACIÓN DE CAMPOS DE TEXTO//////
		//Configuración del campo Placa
		try {
			MaskFormatter mascara = new MaskFormatter("???-####");
			txtPlaca= new JFormattedTextField(mascara);
			txtPlaca.setHorizontalAlignment(SwingConstants.CENTER);
			txtPlaca.setFont(new Font("Arial", Font.PLAIN, 15));
			txtPlaca.setBounds(205, 104, 263, 36);
			//txtPlaca.setValue(new String ("abc-1234"));
			contentPane.add(txtPlaca);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error"+e);
		}
		
		//Configuración del campo Fecha
		JDateChooser dcFecha = new JDateChooser();
		dcFecha.setBounds(205, 168, 263, 36);
		contentPane.add(dcFecha);
		
		//Configuración del campo Hora
		try {
		MaskFormatter mascara = new MaskFormatter("##:##");
		txtHora= new JFormattedTextField(mascara);
		txtHora.setHorizontalAlignment(SwingConstants.CENTER);
		txtHora.setFont(new Font("Arial", Font.PLAIN, 15));
		txtHora.setBounds(205, 235, 263, 36);
		txtHora.setValue(new String ("00:00"));
		contentPane.add(txtHora);
		
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error"+e);
		}
		/////FIN DE CONFIGURACIÓN DE CAMPOS DE TEXTO//////
		
		//Configuración de botón enviar
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				int unp = 0;
				//capturar y validar la placa
				String placa = txtPlaca.getText();
				if (carro.ValidaPlaca(placa)==true) {
					unp = carro.UltimoNumero(placa);
					//capturar el día
					Date date = dcFecha.getDate();
					Calendar calendario = Calendar.getInstance();
					calendario.setTime(date);
					int dia = calendario.get(Calendar.DAY_OF_WEEK);				
					//capturar y validar la hora
					String h = txtHora.getText();
					if(hora.ValidarHora(h)==true) {
						//acción
						boolean circula = carro.Circula(unp, dia,h);			
						if (circula == true) {
							JOptionPane.showMessageDialog(null, "Puede Circular");
						}else {
							JOptionPane.showMessageDialog(null, "No Puede Circular");
						}
					}	else {JOptionPane.showMessageDialog(null, "Hora Inválida. Ingresar nuevamente.");}
				}else {
					JOptionPane.showMessageDialog(null, "Placa Inválida. Ingresar nuevamente.");
				}									
			}
		});
		btnEnviar.setForeground(Color.DARK_GRAY);
		btnEnviar.setBackground(Color.LIGHT_GRAY);
		btnEnviar.setFont(new Font("Arial", Font.BOLD, 15));
		btnEnviar.setBounds(195, 306, 127, 36);
		contentPane.add(btnEnviar);
		
	}
}
