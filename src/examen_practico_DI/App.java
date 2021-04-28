package examen_practico_DI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App extends JFrame {

	private JPanel contentPane;
	private JTextField textField_introduceNum;
	private int numRandom;
	private	int numIntentos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][grow][][][]", "[][][][][][][][][][grow][][grow][][]"));
		
		JLabel label_intentos = new JLabel("N\u00BA Intentos");
		contentPane.add(label_intentos, "cell 1 9,alignx center");
		
		JTextPane textPane_intentos = new JTextPane();
		textPane_intentos.setEditable(false);
		contentPane.add(textPane_intentos, "cell 4 9,grow");
		
		JLabel label_pista = new JLabel("Pista");
		contentPane.add(label_pista, "cell 1 11,alignx center");
		
		JTextPane textPane_pista = new JTextPane();
		textPane_pista.setEditable(false);
		contentPane.add(textPane_pista, "cell 4 11,grow");
		
		JButton button_aceptar = new JButton("Aceptar");
		
		JButton button_iniciar = new JButton("Iniciar");
		button_iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numIntentos = 0;
				textPane_intentos.setText("");
				textPane_pista.setText("");
				numRandom = (int) Math.floor(Math.random()*100+1);
				textField_introduceNum.setEnabled(true);
				button_aceptar.setEnabled(true);
			}
		});
		contentPane.add(button_iniciar, "cell 4 1,alignx center");
		
		JLabel label_introduceNum = new JLabel("Introduce un n\u00FAmero del 0 al 100");
		contentPane.add(label_introduceNum, "cell 1 4");
		
		textField_introduceNum = new JTextField();
		textField_introduceNum.setEnabled(false);
		contentPane.add(textField_introduceNum, "cell 4 4,growx");
		textField_introduceNum.setColumns(10);
		
		button_aceptar.setEnabled(false);
		button_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = 0;
				try {
					num = Integer.parseInt(textField_introduceNum.getText());
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "¡Debes introducir un número entre 1 y 100!");
				}
				if(numIntentos < 5) {
					if(num == numRandom) {
					JOptionPane.showMessageDialog(null, "¡Has acertado, enhorabuena!");
					button_iniciar.setText("Reiniciar");
				}else {
					if(num > numRandom) {
						textPane_pista.setText("Es más bajo");
						numIntentos++;
						textPane_intentos.setText(Integer.toString(numIntentos));
					}else if(num < numRandom) {
						textPane_pista.setText("Es más Alto");
						numIntentos++;
						textPane_intentos.setText(Integer.toString(numIntentos));
					}
				}
				}else {
					JOptionPane.showMessageDialog(null, "¡Has perdido, lo siento!");
					button_iniciar.setText("Reiniciar");
				}
				
			}
		});
		contentPane.add(button_aceptar, "cell 4 6,alignx center");
		
		JLabel label_nombre = new JLabel("Hecho por David Curbelo Mart\u00EDn");
		contentPane.add(label_nombre, "cell 4 13");
	}

}
