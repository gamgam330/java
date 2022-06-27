package �ڹ�;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame implements ActionListener {
	private JButton button1;
	private JButton button2;
	private JPanel panel;
	
	public MyFrame() {
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("�̺�Ʈ ����");
		
		panel = new JPanel();
		
		button1 = new JButton("�����");
		button2 = new JButton("��ȫ��");
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		panel.add(button1);
		panel.add(button2);
		
		add(panel);
		
		setVisible(true);
	}
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == button1) {
				panel.setBackground(Color.YELLOW);
			}
			else if (e.getSource() == button2){
				panel.setBackground(Color.PINK);
			}
		}
	
	public static void main(String[] args) {
		MyFrame t = new MyFrame();
	}
}