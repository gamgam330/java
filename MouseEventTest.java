package �ڹ�;

import javax.swing.JFrame;

public class MouseEventTest extends JFrame{
	public MouseEventTest() {
		setSize(300, 300);
		setTitle("���콺�� �簢�� �׸���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MyPanel());
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MouseEventTest s = new MouseEventTest();
	}
}