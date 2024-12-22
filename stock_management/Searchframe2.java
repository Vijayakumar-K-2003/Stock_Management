package stock_management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Searchframe2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pid;
	private JTextField pname;
	private JTextField category;
	private JTextField quantity;
	private JTextField price;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Searchframe2 frame = new
	 * Searchframe2(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the frame.
	 */
	public Searchframe2() {
		setResizable(false);
		setVisible(true);
		setTitle("STOCK MANAGEMENT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PRODUCT DETAILS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(128, 10, 176, 18);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PRODUCT ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(76, 60, 88, 13);
		contentPane.add(lblNewLabel_1);
		
		pid = new JTextField();
		pid.setEditable(false);
		pid.setBounds(224, 58, 108, 19);
		contentPane.add(pid);
		pid.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("PRODUCT NAME");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(76, 95, 117, 13);
		contentPane.add(lblNewLabel_1_1);
		
		pname = new JTextField();
		pname.setEditable(false);
		pname.setColumns(10);
		pname.setBounds(224, 92, 108, 19);
		contentPane.add(pname);
		
		JLabel lblNewLabel_1_2 = new JLabel("CATEGORY");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(76, 131, 88, 13);
		contentPane.add(lblNewLabel_1_2);
		
		category = new JTextField();
		category.setEditable(false);
		category.setColumns(10);
		category.setBounds(224, 129, 108, 19);
		contentPane.add(category);
		
		JLabel lblNewLabel_1_3 = new JLabel("QUANTITY");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(76, 171, 88, 13);
		contentPane.add(lblNewLabel_1_3);
		
		quantity = new JTextField();
		quantity.setEditable(false);
		quantity.setColumns(10);
		quantity.setBounds(224, 169, 108, 19);
		contentPane.add(quantity);
		
		JLabel lblNewLabel_1_4 = new JLabel("PRICE");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setBounds(76, 209, 88, 13);
		contentPane.add(lblNewLabel_1_4);
		
		price = new JTextField();
		price.setEditable(false);
		price.setColumns(10);
		price.setBounds(224, 207, 108, 19);
		contentPane.add(price);
		pid.setText(String.valueOf(Searchframe.proid));
		pname.setText(Searchframe.pname);	
		category.setText(Searchframe.category);
		quantity.setText(String.valueOf(Searchframe.quantity));
		price.setText(String.valueOf(Searchframe.price));
		
		JButton backbtn = new JButton("BACK");
		backbtn.setBackground(Color.BLACK);
		backbtn.setForeground(Color.WHITE);
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Searchframe sf = new Searchframe();
				sf.show();
				dispose();
			}
		});
		backbtn.setBounds(249, 247, 83, 21);
		contentPane.add(backbtn);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Vijay\\Downloads\\projectBG8.jpg"));
		lblNewLabel_2.setBounds(-24, -43, 507, 378);
		contentPane.add(lblNewLabel_2);
	}

}
