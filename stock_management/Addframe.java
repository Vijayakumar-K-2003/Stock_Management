package stock_management;

//import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class Addframe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pid;
	private JTextField pname;
	private JTextField category;
	private JTextField quantity;
	private JTextField price;

	
	public Addframe() {
		setResizable(false);
		setVisible(true);
		setTitle("STOCK MANAGEMENT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("PRODUCT DETAILS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel.setBounds(128, 10, 172, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PRODUCT ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(46, 63, 125, 26);
		contentPane.add(lblNewLabel_1);
		
		pid = new JTextField();
		pid.setBounds(193, 67, 125, 22);
		contentPane.add(pid);
		pid.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("PRODUCT NAME");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(46, 98, 125, 26);
		contentPane.add(lblNewLabel_1_1);
		
		pname = new JTextField();
		pname.setColumns(10);
		pname.setBounds(193, 103, 125, 22);
		contentPane.add(pname);
		
		JLabel lblNewLabel_1_2 = new JLabel("CATEGORY");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setBounds(46, 134, 78, 26);
		contentPane.add(lblNewLabel_1_2);
		
		category = new JTextField();
		category.setColumns(10);
		category.setBounds(193, 139, 125, 22);
		contentPane.add(category);
		
		JLabel lblNewLabel_1_3 = new JLabel("QUANTITY");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setBounds(46, 171, 78, 26);
		contentPane.add(lblNewLabel_1_3);
		
		quantity = new JTextField();
		quantity.setColumns(10);
		quantity.setBounds(193, 175, 125, 22);
		contentPane.add(quantity);
		
		JButton add = new JButton("ADD");
		add.setForeground(Color.WHITE);
		add.setFocusable(false);
		add.setBackground(Color.BLACK);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/stock_management";
				String username = "root";
				String password = "Vijay@2003";
				try {
				int proid = Integer.parseInt(pid.getText());
				String proname = pname.getText();
				String cat = category.getText();
				int quant = Integer.parseInt(quantity.getText());
				int prs = Integer.parseInt(price.getText());
				
				String query = "INSERT INTO products VALUES (?,?,?,?,?)";
				
				try {
					Connection connection = DriverManager.getConnection(url,username,password);
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setInt(1,proid);
					pst.setString(2,proname);
					pst.setString(3,cat);
					pst.setInt(4,quant);
					pst.setInt(5,prs);
					int rs = pst.executeUpdate();
					if(rs>0) {
						JOptionPane.showMessageDialog(add, "Added Successfully");
						pid.setText("");
						pname.setText("");
						category.setText("");
						quantity.setText("");
						price.setText("");
					}
					else {
						JOptionPane.showMessageDialog(add, "Invalid ID");
						pid.setText("");
						pname.setText("");
						category.setText("");
						quantity.setText("");
						price.setText("");
					}
					connection.close();
					
				}catch(Exception f) {
					JOptionPane.showMessageDialog(add, "Invalid ID");
					pid.setText("");
					pname.setText("");
					category.setText("");
					quantity.setText("");
					price.setText("");
					
				}
				}catch(Exception f) {
					JOptionPane.showMessageDialog(add,"Enter product details to continue");
				}
			}
		});
		add.setBounds(235, 275, 83, 21);
		contentPane.add(add);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("PRICE");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_3_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3_1.setBounds(46, 207, 78, 26);
		contentPane.add(lblNewLabel_1_3_1);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(193, 211, 125, 22);
		contentPane.add(price);
		
		JButton back = new JButton("BACK");
		back.setFocusable(false);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame mf = new MainFrame();
				mf.show();
				dispose();
			}
		});
		back.setBounds(69, 275, 83, 21);
		contentPane.add(back);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Vijay\\Desktop\\projectBG3.jpg"));
		lblNewLabel_2.setBounds(0, 0, 433, 306);
		contentPane.add(lblNewLabel_2);
	}

}
