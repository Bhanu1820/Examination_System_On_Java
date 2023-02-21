package examinetion_system;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogInAsPage extends JFrame {

	private JPanel contentPane;
	private final JLabel lb = new JLabel("");

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInAsPage frame = new LogInAsPage();
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
	public LogInAsPage() {
		super("Log As");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 333, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titel = new JLabel("Log As?");
		titel.setHorizontalAlignment(SwingConstants.CENTER);
		titel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		titel.setBounds(58, 10, 197, 46);
		contentPane.add(titel);
		
		ButtonGroup G = new ButtonGroup();
		
		JRadioButton ra = new JRadioButton("Admin");
		ra.setBounds(129, 86, 103, 21);
		contentPane.add(ra);
		
		JRadioButton rt = new JRadioButton("Teacher");
		rt.setBounds(129, 125, 103, 21);
		contentPane.add(rt);
		
		JRadioButton rs = new JRadioButton("Student");
		rs.setBounds(129, 164, 103, 21);
		contentPane.add(rs);
		
		G.add(ra);
		G.add(rt);
		G.add(rs);
		
		JButton but_ok = new JButton("OK");
		but_ok.setBounds(116, 212, 85, 21);
		contentPane.add(but_ok);
		lb.setBounds(94, 243, 127, 21);
		contentPane.add(lb);
		
		
		but_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(ra.isSelected()) {
					
					AdminLogIn ad=new AdminLogIn();
					ad.setVisible(true);
					dispose();
					
					
				}
				if(rt.isSelected()) {
					
					TeacherLogIn tc=new TeacherLogIn();
					tc.setVisible(true);
					dispose();
					
				}
				if(rs.isSelected()) {
					StudentLogIn st=new StudentLogIn();
					st.setVisible(true);
					dispose();
				}
				
				
			}
		});
		
	}
}
