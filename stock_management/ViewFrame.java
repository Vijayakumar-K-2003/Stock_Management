package stock_management;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;

public class ViewFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    /**
     * Create the frame.
     */
    public ViewFrame() {
        setVisible(true);
        setTitle("STOCK MANAGEMENT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 525, 393);

        // Set the background image
        ImageIcon backgroundIcon = new ImageIcon("projectBG2.jpg"); // Replace with your image path
        Image img = backgroundIcon.getImage().getScaledInstance(525, 393, Image.SCALE_SMOOTH);
        backgroundIcon = new ImageIcon(img);

        JLabel backgroundLabel = new JLabel(new ImageIcon("C:\\Users\\Vijay\\Downloads\\projectBG8.jpg"));
        backgroundLabel.setLayout(new BorderLayout());
        setContentPane(backgroundLabel); // Set the background label as the content pane

        // Database connection and data fetching
        String url = "jdbc:mysql://localhost:3306/stock_management";
        String username = "root";
        String password = "Vijay@2003";
        String query = "SELECT * from products;";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columncount = rsmd.getColumnCount();
            Object[] columnNames = new Object[columncount];
            for (int i = 1; i <= columncount; i++) {
                columnNames[i - 1] = rsmd.getColumnName(i);
            }
            rs.last();
            int rowcount = rs.getRow();
            rs.beforeFirst();
            Object[][] data = new Object[rowcount][columncount];
            int row = 0;
            while (rs.next()) {
                for (int i = 1; i <= columncount; i++) {
                    data[row][i - 1] = rs.getObject(i);
                }
                row++;
            }

            // Create JTable with transparent background
            JTable tb = new JTable(data, columnNames);
            tb.setFont(new Font("Tahoma", Font.BOLD, 11));
            tb.setOpaque(false); // Make the table transparent
            tb.setForeground(Color.WHITE); // Text color
            tb.setBackground(new Color(0, 0, 0, 0)); // Transparent background for cells
            tb.setGridColor(Color.WHITE); // Grid color

            JScrollPane scrollPane = new JScrollPane(tb);
            scrollPane.setOpaque(false); // Transparent scroll pane
            scrollPane.getViewport().setOpaque(false); // Make the viewport transparent
            backgroundLabel.add(scrollPane, BorderLayout.CENTER);

            con.close();
        } catch (Exception f) {
            JOptionPane.showMessageDialog(this, f.getMessage());
        }

        // Add Back Button at the South
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.setOpaque(false); // Make the panel transparent
        JButton backButton = new JButton("Back");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame mf = new MainFrame();
                mf.show();
                dispose();
            }
        });
        southPanel.add(backButton);
        backgroundLabel.add(southPanel, BorderLayout.SOUTH);
    }
}
