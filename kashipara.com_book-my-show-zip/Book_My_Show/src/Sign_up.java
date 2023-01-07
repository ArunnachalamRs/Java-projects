import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;


import javax.swing.*;

import dba.ConnectionProvider;


public class Sign_up extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField tf1,tf2,tf3,tf4;
	JComboBox cb;
	JPasswordField p1,p2;
	JButton b,back;
	JDialog db;
	int chk ;
	int i=0;
	int j=0;
	int k=0,opr=0;
	String s2="";
	
	public Sign_up() {
		
		
		super.setTitle("Sign Up");
		super.setBounds(400, 100, 600, 500);
		super.setResizable(false);
		
		
				
		Font font=new Font("Courier New",Font.BOLD,16);
		l1 = new JLabel("NAME :");
		l1.setBounds(50, 20, 100, 25);
		super.add(l1);
		l1.setFont(font);
		
		l2 = new JLabel("Email :");
		l2.setBounds(50, 50, 100, 25);
		super.add(l2);
		
		l3 = new JLabel("Password:");
		l3.setBounds(50, 80, 100, 25);
		super.add(l3);
		
		l4 = new JLabel("Password:");
		l4.setBounds(50, 110, 100, 25);
		super.add(l4);
				
		l5 = new JLabel("Mobile :");
		l5.setBounds(50, 140, 100, 25);
		super.add(l5);
		
		l6 = new JLabel("City :");
		l6.setBounds(50, 170, 100, 25);
		super.add(l6);
		
		l7 = new JLabel("Gender :");
		l7.setBounds(50, 200, 100, 25);
		super.add(l7);
		
		
		tf1= new JTextField();
		tf1.setBounds(160, 20, 300, 25);
		super.add(tf1);
		
		tf2= new JTextField();
		tf2.setBounds(160, 50, 300, 25);
		super.add(tf2);
		
		p1= new JPasswordField();
		p1.setBounds(160, 80, 300, 25);
		super.add(p1);
		
		p2= new JPasswordField();
		p2.setBounds(160, 110, 300, 25);
		super.add(p2);
		
		tf3= new JTextField();
		tf3.setBounds(160, 140, 300, 25);
		super.add(tf3);
		
		tf4= new JTextField();
		tf4.setBounds(160, 170, 300, 25);
		super.add(tf4);
		
		l2.setFont(font);
		l3.setFont(font);
		l4.setFont(font);
		l5.setFont(font);
		l6.setFont(font);
		l7.setFont(font);
		
		
		String[] s = "GENDER MALE FEMALE".split(" "); 
		cb= new JComboBox(s);
		cb.setBounds(160, 200, 300, 25);
		super.add(cb);
		
		b = new JButton("");
		b.setBounds(190, 240, 200, 40);
		super.add(b);
		b.addActionListener(this);
		b.setFont(font);
		ImageIcon img2 = new ImageIcon("D:\\cetpa8july\\program\\button_save.png");
		b.setIcon(img2);
		
		back = new JButton("");
		back.setBounds(220, 370, 150, 50);
		super.add(back);
		back.addActionListener(this);
		ImageIcon img4 = new ImageIcon("D:\\cetpa8july\\program\\back.png");
		back.setIcon(img4);
		
		
		super.setLayout(null);
		super.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int l=0;
		if (e.getSource()==b){
			
		
			String s1= tf1.getText();
			 		s2= tf2.getText();			
			char[] ch1 = p1.getPassword();
			String a = new String(ch1);
			char[] ch2=p2.getPassword();
			String b = new String(ch2);
			 String s3= tf3.getText();
			 String s4 = tf4.getText();
			 Object o = cb.getSelectedItem();
			String s5= o.toString();//gender
			int at = s2.lastIndexOf("@");
			int dot= s2.lastIndexOf(".");
			
			int pl=	a.length();
			int ml=s3.length();
			String[] str1= s2.split("@");
			String[] str2= s2.split("\\.");
			String[] str3= s2.split(" ");
			String[] str4=s1.split("");
			
			
			
			while(l<s1.length()){
				l++;
				
			}
			
			while(i<str1.length){
				i++;
			}
			
			while(j<str2.length){
				j++;
			}
			
			while(k<str3.length){
				k++;
			}
					
			try {
				long mobile1= Long.parseLong(s3);
			} catch (Exception e2) {
				opr++;
			}
				
			if((s1.isEmpty()||s2.isEmpty()||a.isEmpty()||s3.isEmpty()||s4.isEmpty())){
				JOptionPane.showMessageDialog(this, "please fill all the information ");
				
			}
			
		if(!(s1.isEmpty()||s2.isEmpty()||a.isEmpty()||s3.isEmpty()||s4.isEmpty())){
			
			if(at==-1||(dot-at)<=1||i>2||j>3||k>1||!(s2.endsWith(".com"))){
				//System.out.println(i+">"+j+">"+k);
				JOptionPane.showMessageDialog(this, "Please input valid email address ");	
			}
			if (pl<6){
				JOptionPane.showMessageDialog(this, "Password must contion 6 character ");
			}
			if (ml<10||ml>10){
				JOptionPane.showMessageDialog(this, "Please input valid mobile number ");
			}
			if (opr==1){
				JOptionPane.showMessageDialog(this, "Please inter 10 digit number ");
			}
			
			if (s5.equals("GENDER")){
				JOptionPane.showMessageDialog(this, "Please Select your Gender ");
			}
			if (Validate.validateText(s1)){
				JOptionPane.showMessageDialog(this, "Name must contain alphabhet only ");
			}
			if (Validate.validateText(s4)){
				JOptionPane.showMessageDialog(this, "city must contain alphabhet only ");
			}
			
		
			if 
			((!Validate.validateText(s1))&&a.equals(b)&&s2.endsWith(".com")&&(!Validate.validateText(s4))&&at!=-1&&(dot-at)>1&&i==2&&k==1&&j<=3&&pl>5&&ml==10&&opr==0&&!s5.equals("GENDER")){
				
				//System.out.println(i+" "+j+" "+k);
				
				try {
					
					Connection con = ConnectionProvider.getConnection();
							
					String sql = "insert into user_info values(?,?,?,?,?,?)"; 
					PreparedStatement ps = con.prepareStatement(sql);
					
					ps.setString(1,s1 );
					ps.setString(2,s2 );
					ps.setString(3,a );
					ps.setString(4,s3 );
					ps.setString(5,s4 );
					ps.setString(6,s5 );
					
					ps.executeUpdate();
					con.close();
					
					JOptionPane.showMessageDialog(null, "Sign Up Successful ");
					
					
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog
					(this, "Sign up Error ");
					JOptionPane.showMessageDialog
					(this, "Email or Mobile number already exist plz try again ");
				}
				Sign_in si = new Sign_in();
				super.dispose();
		
		}
		}
		
		
		if (!(a.equals(b))){
			JOptionPane.showMessageDialog(this, "Password not matched ");
		}
		
		}
		if (e.getSource()==back){
			
			Sign_in si = new Sign_in();
			super.dispose();
			
		}
	
	}
	
			
		
	Sign_up su ;
		
}
