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
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Updateframe2 extends JFrame {

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
	 * Runnable() { public void run() { try { Updateframe2 frame = new
	 * Updateframe2(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public Updateframe2() {
		setResizable(false);
		setVisible(true);
		setTitle("STOCK MANAGEMENT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPDATE PRODUCT");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(134, 10, 177, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PRODUCT ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(94, 58, 87, 13);
		contentPane.add(lblNewLabel_1);
		
		pid = new JTextField();
		pid.setEditable(false);
		pid.setBounds(205, 55, 106, 19);
		contentPane.add(pid);
		pid.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("PRODUCT NAME");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(75, 99, 106, 13);
		contentPane.add(lblNewLabel_1_1);
		
		pname = new JTextField();
		pname.setColumns(10);
		pname.setBounds(205, 96, 106, 19);
		contentPane.add(pname);
		
		JLabel lblNewLabel_1_2 = new JLabel("CATEGORY");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setBounds(94, 135, 87, 13);
		contentPane.add(lblNewLabel_1_2);
		
		category = new JTextField();
		category.setColumns(10);
		category.setBounds(205, 132, 106, 19);
		contentPane.add(category);
		
		JLabel lblNewLabel_1_3 = new JLabel("QUANTITY");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(94, 173, 87, 13);
		contentPane.add(lblNewLabel_1_3);
		
		quantity = new JTextField();
		quantity.setColumns(10);
		quantity.setBounds(205, 170, 106, 19);
		contentPane.add(quantity);
		
		JLabel lblNewLabel_1_4 = new JLabel("PRICE");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4.setBounds(94, 209, 87, 13);
		contentPane.add(lblNewLabel_1_4);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(205, 206, 106, 19);
		contentPane.add(price);
		
		pid.setText(String.valueOf(Updateframe.proid));
		pname.setText(Updateframe.pname);	
		category.setText(Updateframe.category);
		quantity.setText(String.valueOf(Updateframe.quantity));
		price.setText(String.valueOf(Updateframe.price));
		
		JButton updatebtn = new JButton("UPDATE");
		updatebtn.setForeground(Color.WHITE);
		updatebtn.setBackground(Color.BLACK);
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/stock_management";
				String username = "root";
				String password = "Vijay@2003";
				String p_name = pname.getText();
				String p_category = category.getText();
				int p_quantity = Integer.parseInt(quantity.getText());
				int p_price = Integer.parseInt(price.getText());
				String query = "UPDATE products SET product_name=?,category=?,quantity=?,price=? WHERE product_id="+Updateframe.proid+";";
				try {
					Connection connection = DriverManager.getConnection(url,username,password);
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1,p_name);
					pst.setString(2,p_category);
					pst.setInt(3, p_quantity);
					pst.setInt(4, p_price);
					int rs = pst.executeUpdate();
					if(rs>0) {
						JOptionPane.showMessageDialog(updatebtn,"Successfully Updated");
						Updateframe uf = new Updateframe();
						uf.show();
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(updatebtn,"Couldn't Complete the Action");
					}
				}catch(Exception g) {
					JOptionPane.showMessageDialog(updatebtn,"Couldn't Complete the Action");
				}
			}
		});
		updatebtn.setBounds(228, 259, 83, 21);
		contentPane.add(updatebtn);
		
		JButton backbtn = new JButton("BACK");
		backbtn.setBackground(Color.BLACK);
		backbtn.setForeground(Color.WHITE);
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Updateframe uf = new Updateframe();
				uf.show();
				dispose();
			}
		});
		backbtn.setBounds(75, 259, 83, 21);
		contentPane.add(backbtn);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Vijay\\Downloads\\projectBG6.jpg"));
		lblNewLabel_2.setBounds(-16, 0, 477, 324);
		contentPane.add(lblNewLabel_2);
	}

}
