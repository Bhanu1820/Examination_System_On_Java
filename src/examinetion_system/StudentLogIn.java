package examinetion_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class StudentLogIn extends JFrame {

	private JPanel contentPane;
	private JTextField s_roll_tf;
	private JTextField s_name_tf;
	private JPasswordField s_pass_tf;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLogIn frame = new StudentLogIn();
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
	public StudentLogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel s_roll_lb = new JLabel("Roll No");
		s_roll_lb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		s_roll_lb.setBounds(58, 58, 143, 30);
		contentPane.add(s_roll_lb);
		
		JLabel s_name_lb = new JLabel("Name");
		s_name_lb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		s_name_lb.setBounds(56, 128, 145, 30);
		contentPane.add(s_name_lb);
		
		JLabel s_pass_lb = new JLabel("Password");
		s_pass_lb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		s_pass_lb.setBounds(56, 202, 145, 30);
		contentPane.add(s_pass_lb);
		
		s_roll_tf = new JTextField();
		s_roll_tf.setBounds(235, 58, 288, 30);
		contentPane.add(s_roll_tf);
		s_roll_tf.setColumns(10);
		
		s_name_tf = new JTextField();
		s_name_tf.setBounds(235, 128, 288, 30);
		contentPane.add(s_name_tf);
		s_name_tf.setColumns(10);
		
		s_pass_tf = new JPasswordField();
		s_pass_tf.setBounds(235, 202, 288, 30);
		contentPane.add(s_pass_tf);
		
		JButton s_login_butt = new JButton("Log In");
		s_login_butt.setBounds(232, 276, 138, 30);
		contentPane.add(s_login_butt);
		
		
		s_login_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				
					Connection con;
				
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_system","root","");
					
					String ids=s_roll_tf.getText();
					String sn=s_name_tf.getText();
					char[] aps=s_pass_tf.getPassword();
					String ps= new String(aps);
			        Statement stmt2=con.createStatement();
			        
			        String qry="SELECT * FROM student WHERE ROLL_NO ='"+ids+"' AND S_PASS = '"+ps+"' AND S_NAME = '"+sn+"';" ;
			        
			        ResultSet rs = null;
			        rs = stmt2.executeQuery(qry);
		
			        
			        //to print all row we use loops
			        
			        if(rs.next()){

					    	s_pass_lb.setText("ok access garnted");
					  }
			        
			        else {
			        	s_pass_lb.setText("no");
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
