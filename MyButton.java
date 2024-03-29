package �ڹ�;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyButton extends JFrame {
   boolean flag = false;
   private int light_number = 0;
   
   protected void paintComponent(Graphics g) {
	  super.paintComponents(g);
      g.setColor(Color.BLACK);
      g.drawOval(100, 100, 100, 100);
      g.drawOval(100, 200, 100, 100);
      g.drawOval(100, 300, 100, 100);
      if(light_number == 0) {
         g.setColor(Color.RED);
         g.fillOval(100,100,100,100);
      }else if (light_number == 1) {
         g.setColor(Color.GREEN);
         g.fillOval(100,200,100,100);
      }else {
         g.setColor(Color.YELLOW);
         g.fillOval(100,300,100,100);
      }
   }
   
   public MyButton() {
      JPanel panel = new JPanel(new BorderLayout());
      JButton b = new JButton("traffic light turn on");
      b.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            if (++light_number >= 3)
               light_number = 0;
            repaint();
         }
         
      });
      add(b, BorderLayout.SOUTH);
      setSize(300,500);
      setVisible(true);
   }
   public static void main(String[] args) {
      MyButton t = new MyButton();
   }
}