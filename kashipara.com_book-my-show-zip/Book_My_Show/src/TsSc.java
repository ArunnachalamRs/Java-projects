import java.awt.Button;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dba.ConnectionProvider;

public class TsSc extends JFrame implements ActionListener{
	
	JLabel[] l = new JLabel[8];
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	JButton b1,b2,b3,back;
	public static int s,g,d;
		
	public TsSc() {
		super.setTitle("Seat type");
		super.setBounds(400, 100, 600, 500);
		super.setResizable(false);
		
		try {
			
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement ps1 = con.prepareStatement("select * from ts1 where seat_type=?");
			ps1.setString(1, "silver");
			ResultSet rs1 =ps1.executeQuery();
			
			while(rs1.next()){
				 s = rs1.getInt(2);
				
			}
			
			PreparedStatement ps2 = con.prepareStatement("select * from ts1 where seat_type=?");
			ps2.setString(1, "gold");
			ResultSet rs2 =ps2.executeQuery();
			
			while(rs2.next()){
				 g = rs2.getInt(2);
			}
			
			PreparedStatement ps3 = con.prepareStatement("select * from ts1 where seat_type=?");
			ps3.setString(1, "diamond");
			ResultSet rs3 =ps3.executeQuery();
			
			while(rs3.next()){
				 d = rs3.getInt(2);
			}
			
		} catch (Exception e) {
			System.out.println("database error" +e);
		}
		
		
		
		l[5]= new JLabel("Catagories");
		l[5].setBounds(30, 10, 200, 30);
		super.add(l[5]);
		
		
		l[0] = new JLabel("Cost (RS)");
		l[0].setBounds(270, 10, 100, 30);
		super.add(l[0]);
		
		l[1] = new JLabel("Available seats");
		l[1].setBounds(400, 10, 200, 30);
		super.add(l[1]);
		
		b1 = new JButton("Silver");
		b1.setBounds(30, 60, 200, 30);
		super.add(b1);
		b1.addActionListener(this);
		
		b2 = new JButton("Gold");
		b2.setBounds(30, 110, 200, 30);
		super.add(b2);
		b2.addActionListener(this);
		
		b3 = new JButton("Diamond");
		b3.setBounds(30, 160, 200, 30);
		super.add(b3);
		b3.addActionListener(this);
		
		ImageIcon img1 = new ImageIcon("D:\\cetpa8july\\program\\button_silver.png");
		b1.setIcon(img1);
		
		ImageIcon img2 = new ImageIcon("D:\\cetpa8july\\program\\button_gold.png");
		b2.setIcon(img2);
		
		ImageIcon img3 = new ImageIcon("D:\\cetpa8july\\program\\button_diamond.png");
		b3.setIcon(img3);
		
		l[2] = new JLabel("200/ ticket");
		l[2].setBounds(270, 60, 100, 30);
		super.add(l[2]);
		
		l[3] = new JLabel("300/ ticket");
		l[3].setBounds(270, 110, 100, 30);
		super.add(l[3]);
		
		l[4] = new JLabel("500/ ticket");
		l[4].setBounds(270, 160, 200, 30);
		super.add(l[4]);
		
		
		
		tf2= new JTextField(String.valueOf(s));
		tf2.setBounds(400, 60, 100, 30);
		super.add(tf2);
		tf2.setEditable(false);
		
		tf3= new JTextField(String.valueOf(g));
		tf3.setBounds(400, 110, 100, 30);
		super.add(tf3);
		tf3.setEditable(false);
		
		tf4= new JTextField(String.valueOf(d));
		tf4.setBounds(400, 160, 100, 30);
		super.add(tf4);
		tf4.setEditable(false);
		
		l[6]= new JLabel("Movie  :  Tumhari Sullu");
		l[6].setBounds(30, 210, 200, 30);
		super.add(l[6]);
		
		
		l[7]= new JLabel("Show time   : 12-3");
		l[7].setBounds(270, 210, 200, 30);
		super.add(l[7]);
				
		
		back = new JButton("");
		back.setBounds(220, 300, 150, 50);
		super.add(back);
		back.addActionListener(this);
		ImageIcon img4 = new ImageIcon("D:\\cetpa8july\\program\\back.png");
		back.setIcon(img4);

		Font font=new Font("Courier New",Font.BOLD,14);
		for (int i = 0; i < l.length; i++) {
			l[i].setFont(font);
		}
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	
	@Override
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==b1){
			
			Ts1sil ts1s = new Ts1sil();
			super.dispose();
			
		}
		
		if (e.getSource()==b2){
			
			Ts1gld ts1g = new Ts1gld();
			super.dispose();
		}
		
		if(e.getSource()==b3){
			
			Ts1dia ts1d = new Ts1dia();
			super.dispose();
		}
		if (e.getSource()==back){
			
			TsSt ts =new TsSt();
			super.dispose();
			
		}
		
	}
	
	
		
			
		
	
	TsSc seat ;
		
	
	
	
	
}
