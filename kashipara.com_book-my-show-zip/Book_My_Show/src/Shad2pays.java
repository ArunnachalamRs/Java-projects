import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Shad2pays extends JFrame implements ActionListener {
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18;
	JButton b1;
	
	public Shad2pays() {
		
		super.setTitle("Pay");
		super.setBounds(400, 100, 600, 500);
		super.setResizable(false);
		
		
		l1=  new JLabel("Movie :");
		l1.setBounds(20, 10, 200, 25);
		super.add(l1);
		
		l2=  new JLabel("Show time :");
		l2.setBounds(20, 40, 200, 25);
		super.add(l2);
		
		l3=  new JLabel("Name :");
		l3.setBounds(20, 70, 200, 25);
		super.add(l3);
		
		l4=  new JLabel("Email:");
		l4.setBounds(20, 100, 200, 25);
		super.add(l4);
		
		l5=  new JLabel("Mobile no.:");
		l5.setBounds(20, 130, 200, 25);
		super.add(l5);

		l6=  new JLabel("Number of seat:");
		l6.setBounds(20, 160, 200, 25);
		super.add(l6);
		
		l7=  new JLabel("Snacks :");
		l7.setBounds(20, 190, 200, 25);
		super.add(l7);
		
		l8=  new JLabel("Catagory :");
		l8.setBounds(20, 220, 200, 25);
		super.add(l8);
		
		l18=  new JLabel("Cost :");
		l18.setBounds(20, 250, 200, 25);
		super.add(l18);
		
		l9=  new JLabel("Shadi Mei Zror Ana");
		l9.setBounds(250, 10, 200, 25);
		super.add(l9);
		
		l10=  new JLabel("3-6");
		l10.setBounds(250, 40, 200, 25);
		super.add(l10);
		
		l11=  new JLabel(Sign_in.name);
		l11.setBounds(250, 70, 200, 25);
		super.add(l11);
		
		l12=  new JLabel(Sign_in.email);
		l12.setBounds(250, 100, 200, 25);
		super.add(l12);
		
		l13=  new JLabel(Sign_in.mob);
		l13.setBounds(250, 130, 200, 25);
		super.add(l13);

		l14=  new JLabel(Shad2sil.s1);
		l14.setBounds(250, 160, 200, 25);
		super.add(l14);
		 
		l15=  new JLabel(Shad2sil.s2);
		l15.setBounds(250, 190, 200, 25);
		super.add(l15);
		
		l16=  new JLabel("Silver");
		l16.setBounds(250, 220, 200, 25);
		super.add(l16);
		
		l17=  new JLabel(Shad2sil.cos);
		l17.setBounds(250, 250, 200, 25);
		super.add(l17);
		
		Font font=new Font("Courier New",Font.BOLD,20);
		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		l4.setFont(font);
		l5.setFont(font);
		l6.setFont(font);
		l7.setFont(font);
		l8.setFont(font);
		l9.setFont(font);
		l10.setFont(font);
		l11.setFont(font);
		l12.setFont(font);
		l13.setFont(font);
		l14.setFont(font);
		l15.setFont(font);
		l16.setFont(font);
		l17.setFont(font);
		l18.setFont(font);
		
		
		b1=  new JButton("Print reciept");
		b1.setBounds(20, 280, 200, 25);
		super.add(b1);
		b1.addActionListener(this);
		
		ImageIcon img1 = new ImageIcon("D:\\cetpa8july\\program\\pr.png");
		b1.setIcon(img1);
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1){

			String s1 = l1.getText();// movies
			String s2 = l2.getText();// show time
			String s3 = l3.getText();// name 1
			String s4 = l4.getText();// email 3
			String s5 = l5.getText();// mob 2
			String s6 = l6.getText();// seat
			String s7 = l7.getText();// snacks
			String s8 = l8.getText();// catagories
			String s9 = l9.getText();// movi name
			String s10 = l10.getText();// 12-3
			String s11 = l11.getText();// name ofusser1
			String s12 = l12.getText();// email id- 3
			String s13 = l13.getText();// mobile no2
			String s14 = l14.getText();// seat
			String s15 = l15.getText();// snacks
			String s16 = l16.getText();// catog
			String s17 = l17.getText();// tt cost
			String s18 = l18.getText();// cost

			String str1 = "Your Movie Reciept \n" + s3 + "\t" + s11 + "\n" + s5 + "\t" + s13 + "\n" + s4 + "\t" + s12
					+ "\n" + s1 + "\t" + s9 + "\n" + s2 + "\t" + s10 + "\n" + s8 + "\t" + s16 + "\n" + s6 + "\t" + s14
					+ "\n" + s7 + "\t" + s15 + "\n" + s18 + "\t" + s17+"\n Thank You Enjoy Your Show ;-) ";

			MailDemo.send("gulfamhassan.993@gmail.com", "mozammil", s12, "RECIEPT ", str1);

			JOptionPane.showMessageDialog(this, "Your Reciept has been sent :");
	
			Sign_in si = new Sign_in();
			super.dispose();

		
		}
	}

	
	Shad2pays shd2ps ;

	

}
