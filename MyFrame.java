import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
		public MyFrame() {
			Toolkit kit = Toolkit.getDefaultToolkit();
			Dimension screenSize = kit.getScreenSize();
			setSize(300, 200);
			setLocation(screenSize.width/2, screenSize.height/2);		//ȭ�� �ߴ� ��ġ
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				//�ݱ�â
			setTitle("MyFrame");
			Image img = kit.getImage("dd.gif");
			setIconImage(img);
			setLayout(new FlowLayout());
			JButton button = new JButton("button");
			this.add(button);
			setVisible(true);
			
			
			
			
			
			/*setSize(300, 200);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("MyFrame");
			
			setLayout(new FlowLayout());				//��ġ������ ����
			JButton button = new JButton("��ư");			//������Ʈ ���� �� �߰�
			this.add(button);
			setVisible(true);*/
	}
}