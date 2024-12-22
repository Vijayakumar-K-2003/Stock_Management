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

public class Searchframe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pid;
	public static int proid ;
	public static String pname;
	public static String category;
	public static int quantity ;
	public static int price ;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Searchframe frame = new Searchframe();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public Searchframe() {
		setResizable(false);
		setVisible(true);
		setTitle("STOCK MANAGEMENT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SEARCH PRODUCTS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(142, 10, 207, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PRODUCT ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(120, 66, 78, 13);
		contentPane.add(lblNewLabel_1);
		
		pid = new JTextField();
		pid.setBounds(226, 63, 97, 19);
		contentPane.add(pid);
		pid.setColumns(10);
		
		JButton backbtn = new JButton("BACK");
		backbtn.setBackground(Color.BLACK);
		backbtn.setForeground(Color.WHITE);
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame mf = new MainFrame();
				mf.show();
				dispose();
			}
		});
		backbtn.setBounds(115, 134, 83, 21);
		contentPane.add(backbtn);
		
		JButton searchbtn = new JButton("SEARCH");
		searchbtn.setBackground(Color.BLACK);
		searchbtn.setForeground(Color.WHITE);
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				proid = Integer.parseInt(pid.getText());
				String url = "jdbc:mysql://localhost:3306/stock_management";
				String username = "root";
				String password = "Vijay@2003";
				String query = "SELECT * FROM products WHERE product_id="+proid+";";
				try {
					Connection connection = DriverManager.getConnection(url,username,password);
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					if(rs.next()) {
						pname=rs.getString(2);
						category=rs.getString(3);
						quantity=rs.getInt(4);
						price=rs.getInt(5);
						
						Searchframe2 df2= new Searchframe2();
						df2.show();
						dispose();
						
						
						
					}else {
						JOptionPane.showMessageDialog(searchbtn, "Invalid ID");
						pid.setText("");
					}	
					connection.close();
					
				}catch(Exception f) {
					JOptionPane.showMessageDialog(searchbtn, "Invalid ID");
					pid.setText("");
				}
				}catch(Exception g) {
					JOptionPane.showMessageDialog(searchbtn,"Enter product ID to continue");
				}
			}
		});
		searchbtn.setBounds(240, 134, 83, 21);
		contentPane.add(searchbtn);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Vijay\\Downloads\\projectBG8.png"));
		lblNewLabel_2.setBounds(-44, -34, 584, 343);
		contentPane.add(lblNewLabel_2);
	}
}
