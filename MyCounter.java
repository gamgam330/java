package 기말;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyCounter extends JFrame{
	private JLabel label, label1;
	private JButton button;
	private int count = 0;
	
	public MyCounter() {
		JPanel panel = new JPanel();
		label = new JLabel("Counter");
		panel.add(label);
		
		label1 = new JLabel(" " + count);
		label1.setFont(new Font("Serif", 
				Font.BOLD | Font.ITALIC, 100));
		panel.add(label1);
		button = new JButton("카운터 증가");
		panel.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				label1.setText(count + " ");
			}
		});
		add(panel);
		setSize(300,200);
		setTitle("My Counter");
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyCounter();
	}
}