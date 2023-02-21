package examinetion_system;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class QuesPanal extends JPanel {

	
	boolean iscorrect=false;
	/**
	 * Create the panel.
	 */
	
	public QuesPanal(int qno,String quse,String crr_ans,String op_1,String op_2,String op_3,String op_4) {
		setLayout(null);
		
		String correctAnswer=crr_ans;
		
		JLabel QuesNo_lb = new JLabel("Q"+qno);
		QuesNo_lb.setFont(new Font("Tahoma", Font.BOLD, 14));
		QuesNo_lb.setBounds(23, 48, 27, 21);
		add(QuesNo_lb);
		
		JTextPane Qusetion = new JTextPane();
		Qusetion.setBounds(60, 33, 755, 90);
		add(Qusetion);
		Qusetion.setText(quse);
		
		ButtonGroup G = new ButtonGroup();
		
		JRadioButton op_1_rb = new JRadioButton(op_1);
		op_1_rb.setBounds(117, 187, 130, 34);
		add(op_1_rb);
		
		JRadioButton op_2_rb = new JRadioButton(op_2);
		op_2_rb.setBounds(117, 243, 130, 34);
		add(op_2_rb);
		
		JRadioButton op_3_rb = new JRadioButton(op_3);
		op_3_rb.setBounds(515, 187, 130, 34);
		add(op_3_rb);
		
		JRadioButton op_4_rb = new JRadioButton(op_4);
		op_4_rb.setBounds(515, 241, 130, 38);
		add(op_4_rb);
		
		G.add(op_1_rb);
		G.add(op_2_rb);
		G.add(op_3_rb);
		G.add(op_4_rb);
		
		
		JButton ansSubmit_but = new JButton("submit");
		ansSubmit_but.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
			
				if(op_1_rb.isSelected()) {
					
					if(op_1 == correctAnswer) {
						iscorrect=true;
					}
				}
				if(op_2_rb.isSelected()) {
					if(op_2 == correctAnswer) {
						iscorrect=true;
					}
				}
				if(op_3_rb.isSelected()) {
					if(op_1 == correctAnswer) {
						iscorrect=true;
					}
				}
				if(op_4_rb.isSelected()) {
					if(op_1 == correctAnswer) {
						iscorrect=true;
					}
				}
				
			}
		});
		ansSubmit_but.setBounds(641, 316, 85, 21);
		add(ansSubmit_but);
		
		

	}
	public boolean checkans(){
		return iscorrect;
	}
}
