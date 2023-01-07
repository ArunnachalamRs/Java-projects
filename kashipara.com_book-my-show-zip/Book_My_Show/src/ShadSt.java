import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class ShadSt extends JFrame implements ActionListener{
	
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JButton b1,b2,b3,back;
	JLabel[] la = new JLabel[6];
	
	
	public ShadSt () {
		super.setTitle("Shaadi Mei Zaror Ana");
		super.setBounds(400, 100, 600, 500);
		super.setResizable(false);
	
		Font font=new Font("Courier New",Font.BOLD,16);
		
		l1=  new JLabel("Movie      :   Shaadi Mei Zaror Ana");
		l1.setBounds(10, 10, 500, 25);
		super.add(l1);
		
		l2=  new JLabel("Starcast   :   		Rajkummar Rao, Kriti Kharbanda");
		l2.setBounds(10, 40, 500, 25);
		super.add(l2);
		
		l3=  new JLabel("Duration   :   2Hr30min");
		l3.setBounds(10, 70, 300, 25);
		super.add(l3);
		
		l4=  new JLabel("Directed   :   Ratnaa Sinha");
		l4.setBounds(10, 100, 500, 25);
		super.add(l4);
		
		l5=  new JLabel("Producer   :   		Vinod Bachchan, Manju Bachchan");
		l5.setBounds(10, 130, 500, 25);
		super.add(l5);
		
		l6=  new JLabel("Rating     :   3/5");
		l6.setBounds(10, 160, 500, 25);
		super.add(l6);
						
		l7=  new JLabel("Story: Shaadi Mein Zaroor Aana is");
		l7.setBounds(235, 190, 500, 25);
		super.add(l7);
		l7.setFont(font);
		
		la[0] = new JLabel("a failed and stereotypical attempt");
		la[0].setBounds(235, 220, 500, 25);
		super.add(la[0]);
		la[0].setFont(font);
		
		la[1] = new JLabel("of tackling issues like dowry and");
		la[1].setBounds(235, 250, 500, 25);
		super.add(la[1]);
		la[1].setFont(font);
		
		la[2] = new JLabel("sexism. You can watch it for,");
		la[2].setBounds(235, 280, 500, 25);
		super.add(la[2]);
		la[2].setFont(font);
		
		la[3] = new JLabel("Rajkummar Rao and Kriti Kharbanda.");
		la[3].setBounds(235, 310, 500, 25);
		super.add(la[3]);
		la[3].setFont(font);
		
		la[4] = new JLabel("This single reason is enough ");
		la[4].setBounds(235, 340, 500, 25);
		super.add(la[4]);
		la[4].setFont(font);
		
		la[5] = new JLabel("for you..");
		la[5].setBounds(235, 370, 500, 25);
		super.add(la[5]);
		la[5].setFont(font);
		
		b1=  new JButton("");
		b1.setBounds(10, 190, 200, 75);
		super.add(b1);
		b1.addActionListener(this);
		
		b2=  new JButton("");
		b2.setBounds(10, 285, 200, 75);
		super.add(b2);
		b2.addActionListener(this);
		
		b3=  new JButton("");
		b3.setBounds(10, 380, 200, 75);
		super.add(b3);
		b3.addActionListener(this);
		
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
		
		
		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		l4.setFont(font);
		l5.setFont(font);
		l6.setFont(font);
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==b1){
			
			ShadSc seat = new ShadSc();
			super.dispose();
		
		
	}
	if (e.getSource()==b2){
		
		ShadSc2 seat2 = new ShadSc2();
		super.dispose();
		
	}
	if (e.getSource()==b3){
		
		ShadSc3 shd = new ShadSc3();
		super.dispose();
	}
	if (e.getSource()==back){
		
		Movies m = new Movies();
		super.dispose();
	}

		
	}
		
		
		ShadSt shad ;
		
	

}
