package userinterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicArrowButton;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import com.ibm.icu.text.NumberFormat;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.text.ParseException;
import java.util.Locale;

public class Settings extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField textField;
	private JFormattedTextField textField_1;
	private JFormattedTextField textField_2;
	private JFormattedTextField textField_3;
	private NumberFormat percentformat;
	public static double perek=0.2;
	public static double pered=0.4;
	public static double perms=0.25;
	public static double perrp=0.15;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings frame = new Settings();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void setUpFormats() {
		percentformat = NumberFormat.getPercentInstance();
		percentformat.setMinimumFractionDigits(0);

	}
	
	/**
	 * Create the frame.
	 */
	
	public Settings() {
		setUpFormats();
		Image img1=new ImageIcon(this.getClass().getResource("/gear1.png")).getImage();
		setIconImage(img1);
		setTitle("Settings");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JFormattedTextField(percentformat);
		textField.setBounds(110, 33, 44, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setValue(0.2);
		
		textField_1 = new JFormattedTextField(percentformat);
		textField_1.setBounds(285, 33, 44, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setValue(0.4);
		
		textField_2 = new JFormattedTextField(percentformat);
		textField_2.setBounds(110, 100, 44, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setValue(0.25);
		
		textField_3 = new JFormattedTextField(percentformat);
		textField_3.setBounds(285, 100, 44, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setValue(0.15);
		
		JLabel lblEk = new JLabel("EK");
		lblEk.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEk.setBounds(22, 24, 30, 30);
		contentPane.add(lblEk);
		
		JLabel lblEd = new JLabel("ED");
		lblEd.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEd.setBounds(22, 86, 35, 40);
		contentPane.add(lblEd);
		
		JLabel lblMs = new JLabel("MS");
		lblMs.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMs.setBounds(187, 24, 55, 30);
		contentPane.add(lblMs);
		
		JLabel lblRp = new JLabel("RP");
		lblRp.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRp.setBounds(187, 93, 55, 27);
		contentPane.add(lblRp);
		
		BasicArrowButton arrowup = new BasicArrowButton(BasicArrowButton.NORTH);
		arrowup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setValue((double) textField_2.getValue()+.01);
			}
		});
		arrowup.setBounds(67, 80, 30, 30);
		contentPane.add(arrowup, BorderLayout.NORTH);
		
		BasicArrowButton arrowdown = new BasicArrowButton(BasicArrowButton.SOUTH);
		arrowdown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setValue((double) textField_2.getValue()-.01);
			}
		});
		arrowdown.setBounds(67, 110, 30, 30);
		contentPane.add(arrowdown, BorderLayout.SOUTH);
		
		BasicArrowButton basicArrowButton = new BasicArrowButton(5);
		basicArrowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setValue((double) textField_1.getValue()-.01);
			}
		});
		basicArrowButton.setBounds(242, 41, 30, 30);
		contentPane.add(basicArrowButton);
		
		BasicArrowButton basicArrowButton_1 = new BasicArrowButton(5);
		basicArrowButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setValue((double) textField_3.getValue()-.01);
			}
		});
		basicArrowButton_1.setBounds(242, 110,30, 30);
		contentPane.add(basicArrowButton_1);
		
		BasicArrowButton basicArrowButton_2 = new BasicArrowButton(5);
		basicArrowButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setValue((double) textField.getValue()-.01);
			}
		});
		basicArrowButton_2.setBounds(67, 41, 30, 30);
		contentPane.add(basicArrowButton_2);
		
		BasicArrowButton basicArrowButton_3 = new BasicArrowButton(1);
		basicArrowButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setValue((double) textField.getValue()+.01);
			}
		});
		basicArrowButton_3.setBounds(67, 11, 30, 30);
		contentPane.add(basicArrowButton_3);
		
		BasicArrowButton basicArrowButton_4 = new BasicArrowButton(1);
		basicArrowButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setValue((double) textField_1.getValue()+.01);
			}
		});
		basicArrowButton_4.setBounds(242, 11, 30, 30);
		contentPane.add(basicArrowButton_4);
		
		BasicArrowButton basicArrowButton_5 = new BasicArrowButton(1);
		basicArrowButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setValue((double) textField_3.getValue()+.01);
			}
		});
		basicArrowButton_5.setBounds(242, 80, 30, 30);
		contentPane.add(basicArrowButton_5);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(((double) textField.getValue()+(double) textField_3.getValue()+(double) textField_2.getValue()+(double) textField_1.getValue())==1) {
					
					try {
						perek=percentformat.parse(textField.getText()).
						doubleValue();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					pered=(double) textField_2.getValue();
					perms=(double) textField_1.getValue();
					perrp=(double) textField_3.getValue();
					System.out.println(perek);
					JOptionPane.showMessageDialog(contentPane,
						    "Settings updated.",
						    "Confirm",
						    JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(contentPane,
						    "The total percentage does not equal 100%.",
						    "Error",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(38, 193, 116, 30);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("%");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(159, 98, 30, 20);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("%");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(159, 33, 30, 20);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("%");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(337, 33, 30, 20);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("%");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(337, 100, 30, 20);
		contentPane.add(label_3);
		
	}
}
