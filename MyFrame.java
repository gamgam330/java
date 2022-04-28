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
			setLocation(screenSize.width/2, screenSize.height/2);		//화면 뜨는 위치
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				//닫기창
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
			
			setLayout(new FlowLayout());				//배치관리자 설정
			JButton button = new JButton("버튼");			//컴포넌트 생성 및 추가
			this.add(button);
			setVisible(true);*/
	}
}