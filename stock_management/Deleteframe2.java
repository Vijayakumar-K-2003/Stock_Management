package stock_management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Deleteframe2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pid;
	private JTextField pname;
	private JTextField category;
	private JTextField quantity;
	private JTextField price;
	private JButton delbtn;
	private JButton back;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Deleteframe2 frame = new
	 * Deleteframe2(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public Deleteframe2() {
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PRODUCT DETAILS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(196, 10, 171, 18);
		contentPane.add(lblNewLabel);
		
		pid = new JTextField();
		pid.setEditable(false);
		pid.setBounds(8, 69, 61, 19);
		contentPane.add(pid);
		pid.setColumns(10);
		
		pname = new JTextField();
		pname.setEditable(false);
		pname.setColumns(10);
		pname.setBounds(92, 69, 128, 19);
		contentPane.add(pname);
		
		category = new JTextField();
		category.setEditable(false);
		category.setColumns(10);
		category.setBounds(240, 69, 113, 19);
		contentPane.add(category);
		
		quantity = new JTextField();
		quantity.setEditable(false);
		quantity.setColumns(10);
		quantity.setBounds(378, 69, 76, 19);
		contentPane.add(quantity);
		
		price = new JTextField();
		price.setEditable(false);
		price.setColumns(10);
		price.setBounds(477, 69, 76, 19);
		contentPane.add(price);
		
		pid.setText(String.valueOf(Deleteframe.proid));
		pname.setText(Deleteframe.pname);	
		category.setText(Deleteframe.category);
		quantity.setText(String.valueOf(Deleteframe.quantity));
		price.setText(String.valueOf(Deleteframe.price));
		
		delbtn = new JButton("DELETE");
		delbtn.setBackground(Color.BLACK);
		delbtn.setForeground(Color.WHITE);
		delbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/stock_management";
				String username = "root";
				String password = "Vijay@2003";
				String query = "DELETE FROM products WHERE product_id ="+Deleteframe.proid+";";
				try {
					Connection connection = DriverManager.getConnection(url,username,password);
					PreparedStatement pst = connection.prepareStatement(query);
					int rs = pst.executeUpdate();
					if(rs>0) {
						JOptionPane.showMessageDialog(delbtn,"Successfully Deleted");
						pid.setText("");
						pname.setText("");	
						category.setText("");
						quantity.setText("");
						price.setText("");
					}
					else {
						JOptionPane.showMessageDialog(delbtn,"Couldn't Complete the Action");
					}
				}catch(Exception g) {
					JOptionPane.showMessageDialog(delbtn,"Couldn't Complete the Action");
				}
			}
		});
		delbtn.setBounds(291, 175, 83, 21);
		contentPane.add(delbtn);
		
		back = new JButton("BACK");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deleteframe df = new Deleteframe();
				df.show();
				dispose();
			}
		});
		back.setBounds(132, 175, 83, 21);
		contentPane.add(back);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Vijay\\Downloads\\projectBG7.jpg"));
		lblNewLabel_1.setBounds(0, 0, 561, 307);
		contentPane.add(lblNewLabel_1);
	}
}
