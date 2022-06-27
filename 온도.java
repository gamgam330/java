package 자바;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class 온도 extends JFrame{
	public 온도() {
		JPanel panel=new JPanel(new FlowLayout());
		add(panel);
		JLabel label1 = new JLabel("화씨 온도");
		JLabel label2 = new JLabel("섭씨 온도");
		JTextField field1 = new JTextField(15);
		JTextField field2 = new JTextField(15);
		JButton button = new JButton("변환");
		panel.add(label1);panel.add(field1);
		panel.add(label2);panel.add(field2);  
		panel.add(button);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double f =Double.parseDouble(field1.getText());
				double c=(f-32)/1.8;
				field2.setText(String.format("%7.2f",  c));
			}
		});
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("온도변환기");
		setVisible(true);
	}
	
	public static void main(String[] args) {
		온도 s = new 온도();
	}
}
