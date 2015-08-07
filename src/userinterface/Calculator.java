package userinterface;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.JButton;

import com.ibm.icu.text.NumberFormat;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

public class Calculator {

	private JFrame frmTibiaHuntCalculator;
	private JFormattedTextField textField;
	private JLabel lblEnterYourSpendings;
	private NumberFormat numFormat;
	private String amount="0";
	double edgp;
	double ekgp;
	double msgp;
	double rpgp;
	double amountgp=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frmTibiaHuntCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void setUpFormats() {
		numFormat = NumberFormat.getNumberInstance();

	}
	
	private void initialize() {
		setUpFormats();
		
		frmTibiaHuntCalculator = new JFrame();
		frmTibiaHuntCalculator.setTitle("Tibia Hunt Calculator");
		frmTibiaHuntCalculator.setBounds(100, 100, 327, 436);
		frmTibiaHuntCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTibiaHuntCalculator.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image img=new ImageIcon(this.getClass().getResource("/tibiaimage.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 318, 159);
		frmTibiaHuntCalculator.getContentPane().add(lblNewLabel);
		
		textField = new JFormattedTextField(numFormat);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		textField.setBounds(10, 205, 245, 25);
		textField.setValue(new Double(100000));
		frmTibiaHuntCalculator.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		lblEnterYourSpendings = new JLabel("Enter Your Spendings Here (gp)");
		lblEnterYourSpendings.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterYourSpendings.setBounds(10, 170, 255, 25);
		frmTibiaHuntCalculator.getContentPane().add(lblEnterYourSpendings);
		
		JTextArea txtrEkEdMs = new JTextArea();
		txtrEkEdMs.setForeground(Color.BLUE);
		txtrEkEdMs.setFont(new Font("Monospaced", Font.BOLD, 15));
		txtrEkEdMs.setText("EK(20%):  "+String.valueOf(ekgp)+"\r\nED(40%):  "+ String.valueOf(edgp)+ "\r\nMS(25%):  " +String.valueOf(msgp)+ "\r\nRP(15%):  "+ String.valueOf(rpgp) );
		txtrEkEdMs.setBounds(10, 300, 245, 87);
		txtrEkEdMs.setEditable(false);
		frmTibiaHuntCalculator.getContentPane().add(txtrEkEdMs);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amount = textField.getText();
				NumberFormat format = NumberFormat.getInstance(Locale.US);
			    try {
					Number number = format.parse(amount);
					amountgp = number.doubleValue();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				Calculations gp = new Calculations();
				gp.setamount(amountgp);
				edgp = gp.getamounted();
				ekgp = gp.getamountek();
				msgp = gp.getamountms();
				rpgp = gp.getamountrp();
				txtrEkEdMs.setText("EK(20%):  "+String.valueOf(ekgp)+"\r\nED(40%):  "+ String.valueOf(edgp)+ "\r\nMS(25%):  " +String.valueOf(msgp)+ "\r\nRP(15%):  "+ String.valueOf(rpgp) );
			}
		});
		btnNewButton.setBounds(31, 250, 150, 25);
		frmTibiaHuntCalculator.getContentPane().add(btnNewButton);
	}
}
