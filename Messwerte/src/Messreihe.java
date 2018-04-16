import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Messreihe {

	private JFrame frame;
	private JTextField tfMesswert;
	private JTextField tfMesswerteBearbeiten;
	private JTextField tfWert;
	
	// Deklarierung Public Variablen / Arrays
	public double[] Messwerte;
	public double anzahl;
	private JTable table;
	
	
	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Messreihe window = new Messreihe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Messreihe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 630, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWievieleMesswerteSollen = new JLabel("Wieviele Messwerte sollen eingegeben werden?");
		lblWievieleMesswerteSollen.setBounds(31, 25, 313, 20);
		frame.getContentPane().add(lblWievieleMesswerteSollen);
		
		JTextField tfAnzahlMesswerte = new JTextField();
		tfAnzahlMesswerte.setBounds(397, 25, 86, 20);
		frame.getContentPane().add(tfAnzahlMesswerte);
		tfAnzahlMesswerte.setColumns(10);
		
		JButton btnAnzahlMesswerte = new JButton("OK");
		btnAnzahlMesswerte.setBounds(493, 24, 89, 23);
		frame.getContentPane().add(btnAnzahlMesswerte);
		
		JLabel lblMesswert = new JLabel("Messwert");
		lblMesswert.setBounds(31, 78, 70, 20);
		frame.getContentPane().add(lblMesswert);
		lblMesswert.setVisible(false);
		
		tfMesswert = new JTextField();
		tfMesswert.setBounds(31, 109, 150, 20);
		frame.getContentPane().add(tfMesswert);
		tfMesswert.setColumns(10);
		tfMesswert.setVisible(false);
		
		JButton btnMesswert = new JButton("OK");
		btnMesswert.setBounds(206, 108, 89, 23);
		frame.getContentPane().add(btnMesswert);
		btnMesswert.setVisible(false);
		
		JLabel lblMesswerte = new JLabel("Messwerte:");
		lblMesswerte.setBounds(31, 140, 70, 20);
		frame.getContentPane().add(lblMesswerte);
		lblMesswerte.setVisible(false);
		
		tfMesswerteBearbeiten = new JTextField();
		tfMesswerteBearbeiten.setBounds(31, 171, 86, 20);
		frame.getContentPane().add(tfMesswerteBearbeiten);
		tfMesswerteBearbeiten.setColumns(10);
		tfMesswerteBearbeiten.setVisible(false);
		
		JLabel lblMesswertBearbeiten = new JLabel(".Messwert");
		lblMesswertBearbeiten.setBounds(127, 171, 70, 20);
		frame.getContentPane().add(lblMesswertBearbeiten);
		lblMesswertBearbeiten.setVisible(false);
		
		JButton btnMesswertBearbeiten = new JButton("Bearbeiten");
		btnMesswertBearbeiten.setBounds(206, 170, 117, 23);
		frame.getContentPane().add(btnMesswertBearbeiten);
		btnMesswertBearbeiten.setVisible(false);
		
		JLabel lblWert = new JLabel("Wert");
		lblWert.setBounds(31, 202, 54, 20);
		frame.getContentPane().add(lblWert);
		lblWert.setVisible(false);
		
		tfWert = new JTextField();
		tfWert.setBounds(31, 233, 150, 20);
		frame.getContentPane().add(tfWert);
		tfWert.setColumns(10);
		tfWert.setVisible(false);
		
		JButton btnWertSpeichern = new JButton("Speichern");
		btnWertSpeichern.setBounds(206, 232, 117, 23);
		frame.getContentPane().add(btnWertSpeichern);
		btnWertSpeichern.setVisible(false);
		
		JButton btnMessreiheAuswerten = new JButton("Messreihe auswerten");
		btnMessreiheAuswerten.setBounds(31, 264, 201, 23);
		frame.getContentPane().add(btnMessreiheAuswerten);
		btnMessreiheAuswerten.setVisible(false);
		
		JLabel lblMaxmimalwert = new JLabel("Maxmimalwert");
		lblMaxmimalwert.setBounds(31, 298, 86, 20);
		frame.getContentPane().add(lblMaxmimalwert);
		lblMaxmimalwert.setVisible(false);
		
		JLabel lblMinimalwert = new JLabel("Minimalwert");
		lblMinimalwert.setBounds(31, 329, 70, 20);
		frame.getContentPane().add(lblMinimalwert);
		lblMinimalwert.setVisible(false);
		
		JLabel lblMittelwert = new JLabel("Mittelwert");
		lblMittelwert.setBounds(31, 360, 70, 20);
		frame.getContentPane().add(lblMittelwert);
		lblMittelwert.setVisible(false);
		
		JLabel lblMaxWert = new JLabel("");
		lblMaxWert.setBounds(127, 298, 46, 20);
		frame.getContentPane().add(lblMaxWert);
		lblMaxWert.setVisible(false);
		
		JLabel lblMinWert = new JLabel("");
		lblMinWert.setBounds(127, 329, 54, 20);
		frame.getContentPane().add(lblMinWert);
		lblMinWert.setVisible(false);
		
		JLabel lblMittelWert = new JLabel("");
		lblMittelWert.setBounds(127, 360, 54, 20);
		frame.getContentPane().add(lblMittelWert);
		lblMittelWert.setVisible(false);
		
		table = new JTable();
		table.setBounds(397, 363, 150, -253);
		frame.getContentPane().add(table);
		table.setVisible(true);
		TableCellEditor anEditor = null;
		table.setCellEditor(anEditor);
		
		
		btnAnzahlMesswerte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anzahl = Integer.parseInt(tfAnzahlMesswerte.getText());
				Messwerte = new double [(int) anzahl];
				
				// Unsichtbar
				lblWievieleMesswerteSollen.setVisible(false);
				tfAnzahlMesswerte.setVisible(false);
				btnAnzahlMesswerte.setVisible(false);
				// Sichtbar
				lblMesswert.setVisible(true);
				tfMesswert.setVisible(true);
				btnMesswert.setVisible(true);
				lblMesswerte.setVisible(true);
				tfMesswerteBearbeiten.setVisible(true);
				lblMesswertBearbeiten.setVisible(true);
				btnMesswertBearbeiten.setVisible(true);
				lblWert.setVisible(true);
				tfWert.setVisible(true);
				btnWertSpeichern.setVisible(true);
				btnMessreiheAuswerten.setVisible(true);
			/*	lblMaxmimalwert.setVisible(true);
				lblMinimalwert.setVisible(true);
				lblMittelwert.setVisible(true);
				lblMaxWert.setVisible(true);
				lblMinWert.setVisible(true);
				lblMittelWert.setVisible(true);
			*/
			}
			
		});
		btnMesswert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Double MesswertDouble;
				
				MesswertDouble = Messwerte[(int) anzahl];
				tfMesswerteBearbeiten.setText(""+ MesswertDouble);
				
			}
		});

	}
}
