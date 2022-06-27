package 자바;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calcul extends JFrame implements ActionListener {

	JPanel panels;
	JTextField tField;
	JButton[] buttons;
	String[] labels = { 
			"Backspace", "", "", "CE", "C",
			"7", "8", "9", "/", "sqrt",
			"4", "5", "6", "x", "%",
			"1", "2", "3", "-", "1/x",
			"0", "+/-", ".", "+", "=",
	};


	public calcul() {
		tField = new JTextField(35);
		panels = new JPanel();
		setTitle("김규민의 계산기");

		panels.setLayout(new GridLayout(0, 5, 3, 3));		//뒤에 두숫자는 공백
		buttons = new JButton[25];
		int index = 0;
		for (int rows = 0; rows < 5; rows++) {
			for (int cols = 0; cols < 5; cols++) {
				buttons[index] = new JButton(labels[index]);
				if( cols >= 3 )
					buttons[index].setForeground(Color.red);		//빨간글씨
				else 
					buttons[index].setForeground(Color.blue);		//파란글씨
				buttons[index].setBackground(Color.yellow);			//뒷배경노란
				buttons[index].addActionListener(this);
				panels.add(buttons[index]);							//패널에 버튼 인덱스 순서대로 추가
				index++;
			}
		}
		add(tField, BorderLayout.NORTH);	 //북쪽배치
		add(panels, BorderLayout.CENTER);     //가운데배치
		setVisible(true); 
		pack();
	}
	
	public void actionPerformed(ActionEvent e) {
		float[] arr = new float[3];
		float action = 0;
		String actionCommand = e.getActionCommand();
		tField.setText(tField.getText() + actionCommand);
		if(actionCommand == "=") {
			String str = tField.getText();
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
					arr[i] = str.charAt(i) - '0';
				}
			}
			switch(str.charAt(1)) {
			case '+':{
				action = (arr[0] + arr[2]);
				break;
			}
			case '-':{
				action = (arr[0] - arr[2]);
				break;
			}
			case 'x':{
				action = (arr[0] * arr[2]);
				break;
			}
			case '/':{
				action = (arr[0] / arr[2]);
				break;
			}
		}
		tField.setText(tField.getText() + action);
	}
}
	public static void main(String args[]) {
		calcul s = new calcul();
	}
}
