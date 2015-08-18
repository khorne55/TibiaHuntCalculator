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

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;




import com.ibm.icu.text.NumberFormat;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

public class Calculator {

	private JFrame frmTibiaHuntCalculator;
	private JFormattedTextField textField;
	private JLabel lblEnterYourSpendings;
	private NumberFormat numFormat;
	private String amount = "0";
	private static Settings settings = null;
	double edgp;
	double ekgp;
	double msgp;
	double rpgp;
	double amountgp = 0;

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
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 */
	public Calculator() throws IOException, EncryptedDocumentException, InvalidFormatException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void setUpFormats() {
		numFormat = NumberFormat.getNumberInstance();
		numFormat.setMinimumFractionDigits(0);

	}

	private static Settings getInstance() {
		if (settings == null) {
			settings = new Settings();
		}
		return settings;
	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	private void initialize() throws IOException, EncryptedDocumentException, InvalidFormatException {
		setUpFormats();

		Workbook wb = WorkbookFactory.create(new File("images/itemlist.xlsx"));
		
		Sheet sheet1 = wb.getSheetAt(0);
	    for (Row row : sheet1) {
	        for (Cell cell : row) {
	            CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
	            System.out.print(cellRef.formatAsString());
	            System.out.print(" - ");

	            switch (cell.getCellType()) {
	                case Cell.CELL_TYPE_STRING:
	                    System.out.println(cell.getRichStringCellValue().getString());
	                    break;
	                case Cell.CELL_TYPE_NUMERIC:
	                    if (DateUtil.isCellDateFormatted(cell)) {
	                        System.out.println(cell.getDateCellValue());
	                    } else {
	                        System.out.println(cell.getNumericCellValue());
	                    }
	                    break;
	                case Cell.CELL_TYPE_BOOLEAN:
	                    System.out.println(cell.getBooleanCellValue());
	                    break;
	                case Cell.CELL_TYPE_FORMULA:
	                    System.out.println(cell.getCellFormula());
	                    break;
	                default:
	                    System.out.println();
	            }
	        }
	    }

		frmTibiaHuntCalculator = new JFrame();
		frmTibiaHuntCalculator.setTitle("Tibia Hunt Calculator");
		frmTibiaHuntCalculator.setBounds(100, 100, 327, 436);
		frmTibiaHuntCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTibiaHuntCalculator.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		Image img = new ImageIcon(this.getClass()
				.getResource("/tibiaimage.jpg")).getImage();
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
		txtrEkEdMs.setText("EK(20%):  " + String.valueOf((int) ekgp)
				+ "\r\nED(40%):  " + String.valueOf((int) edgp) + "\r\nMS(25%):  "
				+ String.valueOf((int) msgp) + "\r\nRP(15%):  "
				+ String.valueOf((int) rpgp));
		txtrEkEdMs.setBounds(10, 300, 229, 87);
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
				gp.update();
				edgp = gp.getamounted();
				ekgp = gp.getamountek();
				msgp = gp.getamountms();
				rpgp = gp.getamountrp();
				txtrEkEdMs.setText("EK(20%):  "
						+ String.valueOf((int) ekgp) + "\r\nED(40%):  "
						+ String.valueOf((int) edgp) + "\r\nMS(25%):  "
						+ String.valueOf((int) msgp) + "\r\nRP(15%):  "
						+ String.valueOf((int) rpgp));
				gp.set("Hunt Total: " + amount + System.lineSeparator()
						+ "ED: " + String.valueOf(edgp)
						+ System.lineSeparator() + "EK: "
						+ String.valueOf(ekgp) + System.lineSeparator()
						+ "MS: " + String.valueOf(msgp)
						+ System.lineSeparator() + "RP: "
						+ String.valueOf(rpgp) + System.lineSeparator());
			}
		});
		btnNewButton.setBounds(31, 250, 150, 25);
		frmTibiaHuntCalculator.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Settings");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getInstance();
				settings.setVisible(true);
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/gear1.png"))
				.getImage();
		btnNewButton_1.setIcon(new ImageIcon(img1));
		btnNewButton_1.setBounds(249, 318, 55, 57);
		frmTibiaHuntCalculator.getContentPane().add(btnNewButton_1);
	}
}
