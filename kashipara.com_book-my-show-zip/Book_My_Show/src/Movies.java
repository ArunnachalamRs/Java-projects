import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Movies extends JFrame implements ActionListener{
		JButton b1,b2,b3, back,next;
		JLabel l1,l2,l3;
	public Movies() {
		super.setTitle("Movies");
		super.setBounds(400, 100, 600, 500);
		super.setResizable(false);
		
		Font font = new Font("Courier New", Font.BOLD, 20);
		
		l1= new JLabel("Tumhari Sullu");
		l1.setBounds(60, 155, 200, 25);		
		super.add(l1);
		l1.setFont(font);
		
		l2= new JLabel("Shadi Mei Zaror Ana");
		l2.setBounds(330, 155, 300, 25);		
		super.add(l2);
		l2.setFont(font);
		
		l3= new JLabel("Star Wars");
		l3.setBounds(190, 345, 200, 25);		
		super.add(l3);
		l3.setFont(font);
		
		b1 = new JButton("");
		b1.setBounds(50, 10, 200, 140);
		super.add(b1);
		
		b2 = new JButton("");
		b2.setBounds(180, 200, 200, 140);
		super.add(b2);
		
		b3 = new JButton("");
		b3.setBounds(320, 10, 200, 140);
		super.add(b3);
		
		back = new JButton("");
		back.setBounds(200, 390, 150, 50);
		super.add(back);
		back.addActionListener(this);
		ImageIcon img4 = new ImageIcon("D:\\cetpa8july\\program\\back.png");
		back.setIcon(img4);
		
		
		
		ImageIcon img1 = new ImageIcon("D:\\cetpa8july\\program\\tsulu.jpg");
		b1.setIcon(img1);
		
		
		ImageIcon img2 = new ImageIcon("D:\\cetpa8july\\program\\starwar.jpg");
		b2.setIcon(img2);
		
		ImageIcon img3 = new ImageIcon("D:\\cetpa8july\\program\\smza.jpg");
		b3.setIcon(img3);
		
		
		
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b1){
			
			TsSt ts = new TsSt();
			super.dispose();
		}
		if (e.getSource()==b2){
			
			SwSt sw = new SwSt();
			super.dispose();

		}
		if (e.getSource()==b3){
			
			ShadSt shad = new ShadSt();
			super.dispose();
		}
		if (e.getSource()==back){
				
			Sign_in si = new Sign_in();
			super.dispose();
		}
	
		
	}
	
	
		Movies m;  

	
		
	

}
