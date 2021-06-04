package com.sbp.gui;

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
import java.awt.event.ActionEvent;
import com.sbp.acciones.Circulacion;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlaca;
	private JTextField txtFecha;
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
		setBounds(100, 100, 540, 450);
		
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
						+ "1. Ingresar la  placa.\r\n"
						+ "\r\n"
						+ "2. Ingresar la fecha / Por defecto se establece la fecha actual.\r\n"
						+ "\r\n"
						+ "3. Ingresar la hora / Por defecto se establece la hora actual.\r\n"
						+ "\r\n"
						+ "4. Click en el botón \"Enviar\"");
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
		
		txtPlaca = new JTextField();
		txtPlaca.setFont(new Font("Arial", Font.PLAIN, 20));
		txtPlaca.setBounds(205, 105, 263, 36);
		contentPane.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setFont(new Font("Arial", Font.PLAIN, 20));
		txtFecha.setColumns(10);
		txtFecha.setBounds(205, 169, 263, 36);
		contentPane.add(txtFecha);
		
		txtHora = new JTextField();
		txtHora.setFont(new Font("Arial", Font.PLAIN, 20));
		txtHora.setColumns(10);
		txtHora.setBounds(205, 237, 263, 36);
		contentPane.add(txtHora);
		
		//Button configuration
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Write the button's code here
				JOptionPane.showMessageDialog(null, "No puede circular");
			}
		});
		btnEnviar.setForeground(Color.DARK_GRAY);
		btnEnviar.setBackground(Color.LIGHT_GRAY);
		btnEnviar.setFont(new Font("Arial", Font.BOLD, 15));
		btnEnviar.setBounds(195, 306, 127, 36);
		contentPane.add(btnEnviar);
	}
}
