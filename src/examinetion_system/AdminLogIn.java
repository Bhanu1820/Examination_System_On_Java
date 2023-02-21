package examinetion_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AdminLogIn extends JFrame {

	private JPanel contentPane;
	private JTextField unametf;
	private JPasswordField upasstf;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogIn frame = new AdminLogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public AdminLogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel unamelb = new JLabel("Username");
		unamelb.setBounds(41, 59, 126, 37);
		unamelb.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(unamelb);
		
		JLabel upasslb = new JLabel("Password");
		upasslb.setBounds(41, 110, 126, 37);
		upasslb.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(upasslb);
		
		unametf = new JTextField();
		unametf.setBounds(189, 59, 303, 39);
		contentPane.add(unametf);
		unametf.setColumns(10);
		
		upasstf = new JPasswordField();
		upasstf.setBounds(189, 110, 303, 37);
		contentPane.add(upasstf);
		
		JButton SignUp_butt = new JButton("Sign Up");
		SignUp_butt.setEnabled(false);
		SignUp_butt.setBounds(128, 190, 119, 39);
		contentPane.add(SignUp_butt);
		
		JButton Log_butt = new JButton("Log In");
		Log_butt.setBounds(304, 190, 119, 39);
		contentPane.add(Log_butt);
		
		SignUp_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				
					Connection con;
				
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_system","root","");
					String un=unametf.getText();
					char[] aps=upasstf.getPassword();
					String ps= new String(aps);
					
					PreparedStatement stmt=con.prepareStatement("INSERT INTO admin VALUES (NULL,?,?)");  
			        
			        stmt.setString(1, un);
			        stmt.setString(2, ps);
			        //to run prepared state mant
			        stmt.executeUpdate();
			        stmt=null;
			        }
				catch(SQLException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		
		
		Log_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				
					Connection con;
				
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_system","root","");
					
					String un=unametf.getText();
					char[] aps=upasstf.getPassword();
					String ps= new String(aps);
			        Statement stmt2=con.createStatement();
			        
			        String qry="SELECT * FROM admin WHERE ADMIN_NAME ='"+un+"' AND ADMIN_PASS = '"+ps+"';" ;
			        
			        ResultSet rs = null;
			        rs = stmt2.executeQuery(qry);
		
			        
			        //to print all row we use loops
			        
			        if(rs.next()){

					    	upasslb.setText("ok access garnted");
					  }
			        
			        else {
			        	upasslb.setText("no");
			        }
			        //freeing up resourses
			        
			        stmt2=null;
			        rs=null;
			        
			        }
				catch(SQLException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
	}
}
