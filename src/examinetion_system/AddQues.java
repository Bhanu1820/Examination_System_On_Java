package examinetion_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;

public class AddQues extends JFrame {

	private JPanel contentPane;
	private JTextField ans_tf;
	private JTextField op_a_tf;
	private JTextField op_b_tf;
	private JTextField op_c_tf;
	private JTextField op_d_tf;
	private JTextField teacher_id_tf;
	private JLabel question_no_lb;
	private JLabel course_lb;
	private JLabel teacher_id_lb;
	private JTextField subject_tf;
	private JLabel ques;
	private JLabel ans;
	private JLabel op_a;
	private JLabel op_b;
	private JLabel op_c;
	private JLabel op_d;
	private JLabel subject;
	private JButton upload_q;
	private JButton get_quess;
	private JTable outputTable;
	private JScrollPane scrollPane;
	private JLabel warnings;
	private JButton deleteQues;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddQues frame = new AddQues();
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
	public AddQues() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100, 100, 1364, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		//drop down
		course_lb = new JLabel("Course");
		course_lb.setBounds(316, 58, 45, 13);
		contentPane.add(course_lb);
		
		JComboBox course = new JComboBox();
		course.setBounds(371, 54, 95, 21);
		course.setModel(new DefaultComboBoxModel(new String[] {"MCA", "MBA", "BTech", "MTech"}));
		contentPane.add(course);
		
		question_no_lb = new JLabel("Question No.");
		question_no_lb.setBounds(35, 55, 81, 13);
		contentPane.add(question_no_lb);
		
		
		JComboBox question_no = new JComboBox();
		question_no.setBounds(127, 54, 95, 21);
		question_no.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		contentPane.add(question_no);
		
		
		
		//teachers id
		
		teacher_id_tf = new JTextField();
		teacher_id_tf.setBounds(126, 95, 123, 28);
		
		contentPane.add(teacher_id_tf);
		teacher_id_tf.setColumns(10);
		teacher_id_tf.setText("0");
		teacher_id_lb = new JLabel("Teacher's ID");
		teacher_id_lb.setBounds(48, 102, 68, 13);
		contentPane.add(teacher_id_lb);
		
		//subject
		subject = new JLabel("Subject");
		subject.setBounds(288, 102, 45, 13);
		contentPane.add(subject);
		
		subject_tf = new JTextField();
		subject_tf.setBounds(343, 95, 123, 28);
		contentPane.add(subject_tf);
		subject_tf.setColumns(10);
		
		//text area
		
		ques = new JLabel("Question");
		ques.setBounds(58, 137, 45, 13);
		contentPane.add(ques);
		
		JScrollPane scrollPane_q = new JScrollPane();
		scrollPane_q.setBounds(127, 133, 339, 94);
		contentPane.add(scrollPane_q);
		
		JTextArea ques_area = new JTextArea();
		scrollPane_q.setViewportView(ques_area);
		
		
		//answer
		
		
		ans = new JLabel("Correct Ans.");
		ans.setBounds(35, 241, 68, 13);
		contentPane.add(ans);
		
		ans_tf = new JTextField();
		ans_tf.setBounds(127, 237, 339, 28);
		contentPane.add(ans_tf);
		ans_tf.setColumns(10);
		
		//options
		
		//a
		op_a_tf = new JTextField();
		op_a_tf.setBounds(127, 289, 339, 28);
		op_a_tf.setColumns(10);
		contentPane.add(op_a_tf);
		
		op_a = new JLabel("Option A");
		op_a.setBounds(58, 293, 45, 13);
		contentPane.add(op_a);
		//b
		op_b = new JLabel("Option B");
		op_b.setBounds(58, 331, 45, 13);
		contentPane.add(op_b);
		
		op_b_tf = new JTextField();
		op_b_tf.setBounds(127, 327, 339, 28);
		op_b_tf.setColumns(10);
		contentPane.add(op_b_tf);
		
		//c
		op_c_tf = new JTextField();
		op_c_tf.setBounds(127, 365, 339, 28);
		op_c_tf.setColumns(10);
		contentPane.add(op_c_tf);
		
		op_c = new JLabel("Option C");
		op_c.setBounds(58, 369, 45, 13);
		contentPane.add(op_c);
		
		
		//d
		op_d_tf = new JTextField();
		op_d_tf.setBounds(127, 403, 339, 28);
		op_d_tf.setColumns(10);
		contentPane.add(op_d_tf);
		
		op_d = new JLabel("Option D");
		op_d.setBounds(58, 407, 45, 13);
		contentPane.add(op_d);
				
				scrollPane = new JScrollPane();
				scrollPane.setBounds(512, 57, 828, 374);
				contentPane.add(scrollPane);
		
		//output
		
				outputTable = new JTable();
				scrollPane.setViewportView(outputTable);
				
				warnings = new JLabel("Warnings:");
				warnings.setBounds(512, 465, 828, 61);
				contentPane.add(warnings);
				
		
		//buttons
		upload_q = new JButton("Upload Question");
		upload_q.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(ques_area.getText().equals("")) {
			
					warnings.setText("no question entered");
				}
				else {	
				
				
					int qn= 1+question_no.getSelectedIndex();
					int tid=Integer.parseInt(teacher_id_tf.getText());
					String c=(String) course.getSelectedItem();
					String sb=subject_tf.getText();
					String q=ques_area.getText();
					String ca=ans_tf.getText();
					String oa=op_a_tf.getText();
					String ob=op_b_tf.getText();
					String oc=op_c_tf.getText();
					String od=op_d_tf.getText();
					
					warnings.setText(q);
				
				
					try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				
					Connection con;
				
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_system","root","");
					
					//INSERT INTO `questiondate` (`QUES_NO`, `COURSE`, `TEACHER_ID`, `SUBJECT`, `QUESTION`, `ANSWER`, `OPTION_A`, `OPTION_B`, `OPTION_C`, `OPTION_D`) 
					//VALUES ('1', 'MCA', '1', 'English', 'teat question what is xy zzzzsl?', 'correct', 'correct', 'incorrect', 'incorrect', 'incorrect')
					
					PreparedStatement stmt=con.prepareStatement("INSERT INTO questiondate VALUES (?,?,?,?,?,?,?,?,?,?)");  
			        
			        stmt.setInt(1,qn);
			        stmt.setString(2, c);
			        stmt.setInt(3, tid);
			        stmt.setString(4, sb);
			        stmt.setString(5, q);
			        stmt.setString(6, ca);
			        stmt.setString(7, oa);
			        stmt.setString(8, ob);
			        stmt.setString(9, oc);
			        stmt.setString(10, od);
			        
			        
			        //to run prepared state mant
			        stmt.executeUpdate();
				
			        stmt.close();
					con.close();
			        }
				catch(SQLException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
				}
			
			}
			
		});
		upload_q.setBounds(127, 456, 339, 28);
		contentPane.add(upload_q);
		
		get_quess = new JButton("Get All Question");
		get_quess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				
					Connection con;
				
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_system","root","");
					
					Statement st=con.createStatement();
					
					ResultSet rs = null;
			        rs = st.executeQuery("SELECT * FROM questiondate");
			        
			        
			        //to get meta data of table
			        ResultSetMetaData rsmd =rs.getMetaData();
			        
			        //to get column names
			        DefaultTableModel model=(DefaultTableModel) outputTable.getModel();
			        
			        int cols=rsmd.getColumnCount();
			        String[] colName=new String[cols];
			        for(int i=0;i<cols;i++) {
			        	
			        	colName[i]=rsmd.getColumnName(i+1);
			        	
			        }
			        model.setColumnIdentifiers(colName);
			        //end geting columns names
			        
			        //geting table contant
			        
			        int qn,tid;
					String c,sb,q,ca,oa,ob,oc,od;
					
					while(rs.next()) {
						
						qn=rs.getInt("QUES_NO");
						tid=rs.getInt("TEACHER_ID");
						c=rs.getNString("COURSE");
						sb=rs.getNString("SUBJECT");
						q=rs.getNString("QUESTION");
						ca=rs.getNString("ANSWER");
						oa=rs.getNString("OPTION_A");
						ob=rs.getNString("OPTION_B");
						oc=rs.getNString("OPTION_C");
						od=rs.getNString("OPTION_D");
						
						String[]row={""+qn,c,""+tid,sb,q,ca,oa,ob,oc,od};
						model.addRow(row);
						
					}
					st.close();
					con.close();
				
					
					}
				catch(SQLException e1) {
					e1.printStackTrace();
				} 
				catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		}});
		get_quess.setBounds(127, 498, 164, 28);
		contentPane.add(get_quess);
		
		
		
		deleteQues = new JButton("Delete a Question");
		deleteQues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con;
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_system","root","");
					
					int qn= 1+question_no.getSelectedIndex();
					int tid=Integer.parseInt(teacher_id_tf.getText());
					String c=(String) course.getSelectedItem();
					String sb=subject_tf.getText();
					
					if(tid==0||subject_tf.getText().equals("")) {
						
						warnings.setText("Enter all fields like Question no,Course,Teacher id and Subject");
						
					}
					else {
						
						
						PreparedStatement stmt=con.prepareStatement("DELETE FROM `questiondate` WHERE QUES_NO = ? AND TEACHER_ID=? AND COURSE=? AND SUBJECT=?");
						
						stmt.setInt(1, qn);
				        stmt.setInt(2, tid);
				        stmt.setString(3, c);
				        stmt.setString(4, sb);
				        stmt.executeUpdate();
						
						
						warnings.setText("deleted");
					}
					
					
				} 
				catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		deleteQues.setBounds(302, 498, 164, 28);
		contentPane.add(deleteQues);

		
		
		
	}
}
