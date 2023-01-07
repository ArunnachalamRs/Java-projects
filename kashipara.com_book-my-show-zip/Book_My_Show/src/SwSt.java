import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class SwSt extends JFrame implements ActionListener{
	
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JButton b1,b2,b3,back;
	JLabel[] la = new JLabel[6];
	
	public SwSt() {
		super.setTitle("Star Wars");
		super.setBounds(400, 100, 600, 500);
		super.setResizable(false);
		
		Font font=new Font("Courier New",Font.BOLD,16);
		
		
		l1=  new JLabel("Movie      :   Star Wars");
		l1.setBounds(10, 10, 500, 25);
		super.add(l1);
		l1.setFont(font);
		
		
		l2=  new JLabel("Starcast   :   Mark Hamill,Carrie Fisher");
		l2.setBounds(10, 40, 500, 25);
		super.add(l2);
		l2.setFont(font);
		
		l3=  new JLabel("Duration   :   2Hr31min");
		l3.setBounds(10, 70, 300, 25);
		super.add(l3);
		l3.setFont(font);
		
		l4=  new JLabel("Directed   :   Rian Johnson");
		l4.setBounds(10, 100, 500, 25);
		super.add(l4);
		l4.setFont(font);
		
		l5=  new JLabel("Producer   :   		Kathleen Kennedy, Ram Bergman");
		l5.setBounds(10, 130, 500, 25);
		super.add(l5);
		l5.setFont(font);
		
		l6=  new JLabel("Rating     :   3/5");
		l6.setBounds(10, 160, 500, 25);
		super.add(l6);
		l6.setFont(font);

		l7=  new JLabel("Story: Rey took her first steps");
		l7.setBounds(235, 190, 500, 25);
		super.add(l7);
		l7.setFont(font);
		
		la[0] = new JLabel("into a larger world in Star Wars");
		la[0].setBounds(235, 220, 500, 25);
		super.add(la[0]);
		la[0].setFont(font);
		
		la[1] = new JLabel("The Force Awakens and will");
		la[1].setBounds(235, 250, 500, 25);
		super.add(la[1]);
		la[1].setFont(font);
		
		la[2] = new JLabel("continue her epic journey with");
		la[2].setBounds(235, 280, 500, 25);
		super.add(la[2]);
		la[2].setFont(font);
		
		la[3] = new JLabel("Finn, Poe and Luke Skywalker in");
		la[3].setBounds(235, 310, 500, 25);
		super.add(la[3]);
		la[3].setFont(font);
		
		la[4] = new JLabel("the next chapter of the continuing ");
		la[4].setBounds(235, 340, 500, 25);
		super.add(la[4]);
		la[4].setFont(font);
		
		la[5] = new JLabel("Star Wars Saga..");
		la[5].setBounds(235, 370, 500, 25);
		super.add(la[5]);
		la[5].setFont(font);
		
		b1=  new JButton("12-3");
		b1.setBounds(10, 190, 200, 75);
		super.add(b1);
		b1.addActionListener(this);
		b1.setFont(font);
		
		b2=  new JButton("3-6");
		b2.setBounds(10, 285, 200, 75);
		super.add(b2);
		b2.addActionListener(this);
		b2.setFont(font);
		
		b3=  new JButton("6-9");
		b3.setBounds(10, 380, 200, 75);
		super.add(b3);
		b3.addActionListener(this);
		b3.setFont(font);
		
		back = new JButton("");
		back.setBounds(250, 400, 150, 50);
		super.add(back);
		back.addActionListener(this);
		ImageIcon img4 = new ImageIcon("D:\\cetpa8july\\program\\back.png");
		back.setIcon(img4);
		
		
		ImageIcon img1 = new ImageIcon("D:\\cetpa8july\\program\\button1.png");
		b1.setIcon(img1);
		
		ImageIcon img2 = new ImageIcon("D:\\cetpa8july\\program\\button2.png");
		b2.setIcon(img2);
		
		ImageIcon img3 = new ImageIcon("D:\\cetpa8july\\program\\button3.png");
		b3.setIcon(img3);
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==b1){
			
			SwSc swseat = new SwSc();
			super.dispose();
			
			
		}
		if (e.getSource()==b2){
			
			SwSc2 swseat2 = new SwSc2();
			super.dispose();
					
			
		}
		if (e.getSource()==b3){
			
			SwSc3 Swseat3 = new SwSc3();
			super.dispose();		
			}
		if (e.getSource()==back){
			
			Movies m = new Movies();
			super.dispose();
		}
		
	}

		
			
		
		SwSt sw;
		
	

}
