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
import javax.swing.SwingConstants;

public class TeacherLogIn extends JFrame {

	private JPanel contentPane;
	private JTextField tidtf;
	private JPasswordField tpasstf;
	private JLabel msg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherLogIn frame = new TeacherLogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TeacherLogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel tidlb = new JLabel("Teacher Id");
		tidlb.setFont(new Font("Tahoma", Font.BOLD, 14));
		tidlb.setBounds(63, 74, 126, 38);
		contentPane.add(tidlb);
		
		JLabel tpasslb = new JLabel("Password");
		tpasslb.setFont(new Font("Tahoma", Font.BOLD, 14));
		tpasslb.setBounds(63, 140, 126, 38);
		contentPane.add(tpasslb);
		
		tidtf = new JTextField();
		tidtf.setBounds(209, 74, 292, 38);
		contentPane.add(tidtf);
		tidtf.setColumns(10);
		
		tpasstf = new JPasswordField();
		tpasstf.setBounds(209, 140, 293, 38);
		contentPane.add(tpasstf);
		
		JButton login_butt = new JButton("Log In");
		login_butt.setBounds(209, 222, 148, 31);
		contentPane.add(login_butt);
		
		msg = new JLabel("");
		msg.setHorizontalAlignment(SwingConstants.CENTER);
		msg.setBounds(120, 280, 332, 13);
		contentPane.add(msg);
		
		login_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				
					Connection con;
				
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_system","root","");
					
					String ids=tidtf.getText();
					
					char[] aps=tpasstf.getPassword();
					String ps= new String(aps);
			        Statement stmt2=con.createStatement();
			        
			        String qry="SELECT * FROM teacher WHERE TEACHER_ID ='"+ids+"' AND T_PASS = '"+ps+"';" ;
			        
			        ResultSet rs = null;
			        rs = stmt2.executeQuery(qry);
		
			        
			        //to print all row we use loops
			        
			        if(rs.next()){

					    	AddQues adq=new AddQues();
					    	adq.setVisible(true);
							dispose();
					  }
			        
			        else {
			        	msg.setText("Access denied enter valid id and password");
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
