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

public class Updateframe extends JFrame {

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
	 * Runnable() { public void run() { try { Updateframe frame = new Updateframe();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public Updateframe() {
		setResizable(false);
		setVisible(true);
		setTitle("STOCK MANAGEMENT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPDATE PRODUCT");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(132, 10, 191, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PRODUCT ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(115, 59, 75, 13);
		contentPane.add(lblNewLabel_1);
		
		pid = new JTextField();
		pid.setBounds(223, 56, 100, 19);
		contentPane.add(pid);
		pid.setColumns(10);
		
		JButton updatebtn = new JButton("UPDATE ");
		updatebtn.setForeground(Color.WHITE);
		updatebtn.setBackground(Color.BLACK);
		updatebtn.addActionListener(new ActionListener() {
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
						
						Updateframe2 df2= new Updateframe2();
						df2.show();
						dispose();
						
						
						
					}else {
						JOptionPane.showMessageDialog(updatebtn, "Invalid ID");
						pid.setText("");
					}	
					connection.close();
					
				}catch(Exception f) {
					JOptionPane.showMessageDialog(updatebtn, "Invalid ID");
					pid.setText("");
				}
				}catch(Exception g) {
					JOptionPane.showMessageDialog(updatebtn,"Enter product ID to continue");
				}
			}
		});
		updatebtn.setBounds(223, 117, 100, 21);
		contentPane.add(updatebtn);
		
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
		backbtn.setBounds(103, 117, 100, 21);
		contentPane.add(backbtn);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Vijay\\Downloads\\projectBG9.jpg"));
		lblNewLabel_2.setBounds(-252, -202, 707, 644);
		contentPane.add(lblNewLabel_2);
	}

}
