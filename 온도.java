package �ڹ�;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class �µ� extends JFrame{
	public �µ�() {
		JPanel panel=new JPanel(new FlowLayout());
		add(panel);
		JLabel label1 = new JLabel("ȭ�� �µ�");
		JLabel label2 = new JLabel("���� �µ�");
		JTextField field1 = new JTextField(15);
		JTextField field2 = new JTextField(15);
		JButton button = new JButton("��ȯ");
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
		setTitle("�µ���ȯ��");
		setVisible(true);
	}
	
	public static void main(String[] args) {
		�µ� s = new �µ�();
	}
}
