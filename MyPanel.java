// Ω≈»£µÓ
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel implements ActionListener{
   boolean flag = false;
   private int light_number = 0;
   private JButton b;
   private JButton b2;
   private JButton b3;
   
   public MyPanel() {
      setLayout(null);
      b = new JButton("RED");
      b2 = new JButton("GREEN");
      b3 = new JButton("YELLOW");
      b.addActionListener(this);
      b2.addActionListener(this);
      b3.addActionListener(this);
      add(b);
      add(b2);
      add(b3);
      
      b.setBounds(10,420,80,20);
      b2.setBounds(110,420,80,20);
      b3.setBounds(210,420,90,20);
   }
   
   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.BLACK);
      g.drawOval(100, 100, 100, 100);
      g.drawOval(100, 200, 100, 100);
      g.drawOval(100, 300, 100, 100);
      if(light_number == 0) {
         g.setColor(Color.RED);
         g.fillOval(100, 100, 100, 100);
      }
      else if(light_number == 1) {
         g.setColor(Color.GREEN);
         g.fillOval(100, 200, 100, 100);
      }
      else {
         g.setColor(Color.YELLOW);
         g.fillOval(100, 300, 100, 100);
      }
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == b)
         light_number = 0;
      else if(e.getSource() == b2)
         light_number = 1;
      else
         light_number = 2;
      repaint();
   }
}

public class RGY extends JFrame {
   public RGY() {
      add(new MyPanel());
      setSize(320,500);
      setVisible(true);
   }
   public static void main(String[] args) {
      new RGY();

   }

}