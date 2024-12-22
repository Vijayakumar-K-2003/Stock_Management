package stock_management;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.SystemColor;


public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public static void main(String[] args) {
		
		MainFrame frame=new MainFrame();
		frame.setVisible(true);
	}

	
	public MainFrame() {
		setResizable(false);
		
		setTitle("STOCK MANAGEMENT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("STOCK MANAGEMENT");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(125, 10, 186, 35);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JButton addbtn = new JButton("ADD PRODUCT");
		addbtn.setFocusable(false);
		addbtn.setForeground(Color.WHITE);
		addbtn.setBackground(Color.BLACK);
		addbtn.setBounds(39, 69, 144, 27);
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addframe af = new Addframe();
				af.show();
				dispose();
			}
		});
		
		JButton updatebtn = new JButton("UPDATE PRODUCT");
		updatebtn.setForeground(Color.WHITE);
		updatebtn.setFocusable(false);
		updatebtn.setBackground(Color.BLACK);
		updatebtn.setBounds(39, 131, 144, 27);
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Updateframe uf = new Updateframe();
				uf.show();
				dispose();
			}
		});
		
		JButton deletebtn = new JButton("DELETE PRODUCT");
		deletebtn.setBackground(Color.BLACK);
		deletebtn.setForeground(Color.WHITE);
		deletebtn.setFocusable(false);
		deletebtn.setBounds(263, 69, 144, 27);
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deleteframe df = new Deleteframe();
				df.show();
				dispose();
			}
		});
		
		JButton searchbtn = new JButton("SEARCH PRODUCT");
		searchbtn.setBackground(Color.BLACK);
		searchbtn.setFocusable(false);
		searchbtn.setForeground(Color.WHITE);
		searchbtn.setBounds(263, 131, 144, 27);
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Searchframe sf = new Searchframe();
				sf.show();
				dispose();
			}
		});
		
		JButton viewallbtn = new JButton("VIEW PRODUCTS");
		viewallbtn.setFocusable(false);
		viewallbtn.setForeground(Color.WHITE);
		viewallbtn.setBackground(Color.BLACK);
		viewallbtn.setBounds(143, 201, 144, 27);
		viewallbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewFrame vf = new ViewFrame();
				vf.show();
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(addbtn);
		contentPane.add(updatebtn);
		contentPane.add(deletebtn);
		contentPane.add(searchbtn);
		contentPane.add(viewallbtn);
		

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(SystemColor.control);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Vijay\\Downloads\\projectBG5.jpg"));
		lblNewLabel_1.setBounds(0, 0, 438, 265);
		contentPane.add(lblNewLabel_1);
		
		

	}
}
