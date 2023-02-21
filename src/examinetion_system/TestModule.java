package examinetion_system;

import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestModule extends JFrame {
	int k=0;
	int j =0;
	int result=0;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestModule frame = new TestModule();
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
	public TestModule() {
		String[] [] a=new String[100][7];
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_system","root","");			
			Statement stmt2=con.createStatement();        
	        ResultSet rs = null;
	        rs = stmt2.executeQuery("SELECT * FROM questiondate where COURSE='MCA'and TEACHER_ID='1' and SUBJECT='dsa'");  	        
	        //ArrayList<ArrayList<String>> a=new ArrayList<ArrayList<String>>();
	        
	        
	        int i=0;
	        while(rs.next()) {
	        	
	        	a[i][0]=rs.getString("QUES_NO");
	        	//System.out.println(a[i][0]);
	        	a[i][1]=rs.getString("QUESTION");
	        	//System.out.println(a[i][1]);
	        	a[i][2]=rs.getString("ANSWER");
	        	//System.out.println(a[i][2]);
	        	a[i][3]=rs.getString("OPTION_A");
	        	//System.out.println(a[i][3]);
	        	a[i][4]=rs.getString("OPTION_B");
	        	//System.out.println(a[i][4]);
	        	a[i][5]=rs.getString("OPTION_C");
	        	//System.out.println(a[i][5]);
	        	a[i][6]=rs.getString("OPTION_D");
	        	//System.out.println(a[i][6]);
			    i++;

	        }
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 777, 432);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea t1 = new JTextArea();
		t1.setEditable(false);
		t1.setBounds(30, 25, 729, 133);
		t1.setText(a[0][0]+" "+a[j][1]);
		panel.add(t1);
		
		JRadioButton r1 = new JRadioButton(a[j][3]);
		r1.setBounds(72, 209, 244, 21);
		panel.add(r1);
		
		JRadioButton r2 = new JRadioButton(a[j][4]);
		r2.setBounds(72, 291, 244, 21);
		panel.add(r2);
		
		JRadioButton r3 = new JRadioButton(a[j][5]);
		r3.setBounds(468, 209, 244, 21);
		panel.add(r3);
		
		JRadioButton r4 = new JRadioButton(a[j][6]);
		r4.setBounds(468, 291, 244, 21);
		panel.add(r4);
		
		ButtonGroup G = new ButtonGroup();
		G.add(r1);
		G.add(r2);
		G.add(r3);
		G.add(r4);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(j<10) {
					
					j++;
					t1.setText("Q."+a[j][0]+" "+a[j][1]);
					r1.setText(a[j][3]);
					r2.setText(a[j][4]);
					r3.setText(a[j][5]);
					r4.setText(a[j][6]);
					
					if(r1.isSelected()) {
						if(r1.getText()== a[j][2]) {
							result++;
						}
					}
					if(r2.isSelected()) {
						if(r2.getText()== a[j][2]) {
							result++;
						}
					}
					if(r3.isSelected()) {
						if(r3.getText()== a[j][2]) {
							result++;
						}
					}
					if(r4.isSelected()) {
						if(r4.getText()== a[j][2]) {
							result++;
						}
					}
						
					}
				if(j>9) {
					
					t1.setText("exam over");
					
					}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(657, 385, 85, 25);
		panel.add(btnNewButton);
		
		
		
		
		
	}
}
