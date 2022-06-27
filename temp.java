package ÀÚ¹Ù;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class temp extends JFrame implements ActionListener {
   private JTextField textfield1;
   private JTextField textfield2;
   private JPanel panel;
   private JButton button;
   private JLabel label1;
   private JLabel label2;
   
   public temp() {
	   panel = new JPanel();
	   label1 = new JLabel("È­¾¾ ¿Âµµ");
	   label2 = new JLabel("¼·¾¾ ¿Âµµ");
	   textfield1 = new JTextField(15);
	   textfield2 = new JTextField(15);
	   button = new JButton("º¯È¯");
	   add(panel);
	   panel.add(label1); panel.add(textfield1);
	   panel.add(label2); panel.add(textfield2);
	   panel.add(button);
	   
	   button.addActionListener(this);
	   
	   setSize(300,200);
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   setVisible(true);
   	}
   
  
   public static void main(String[] args) {
      temp t = new temp();
   }
   
   public void actionPerformed(ActionEvent e) {
	      double f = Double.parseDouble(textfield1.getText());
	      double c=(f-32)/1.8;
	      textfield2.setText(String.format("%7.2f",  c));
	   }
}