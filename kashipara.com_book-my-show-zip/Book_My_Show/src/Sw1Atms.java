		import java.awt.Font;
		import java.awt.event.ActionEvent;
		import java.awt.event.ActionListener;

		import javax.swing.ImageIcon;
		import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
		import javax.swing.JLabel;
		import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Sw1Atms extends JFrame implements ActionListener {
	JLabel l1,l2,l3,l4,l5,l6;
	JButton b1;
	JTextField tf1,tf2,tf3,tf4;
	JComboBox cb1,cb2;

	public Sw1Atms() {

				super.setTitle("Payment Gateway:");
				super.setBounds(400, 100, 600, 500);
				super.setResizable(false);
				
				Font font=new Font("Courier New",Font.BOLD,20);
				l1=  new JLabel("Card Number :");
				l1.setBounds(20, 10, 200, 25);
				super.add(l1);
				l1.setFont(font);
				
				l2=  new JLabel("Name on Card :");
				l2.setBounds(20, 40, 200, 25);
				super.add(l2);
				l2.setFont(font);
				
				l3=  new JLabel("CVV No. :");
				l3.setBounds(20, 70, 200, 25);
				super.add(l3);
				l3.setFont(font);
				
				l4=  new JLabel("Expairy :");
				l4.setBounds(20, 100, 200, 25);
				super.add(l4);
				l4.setFont(font);
				
				
				String s1="";
				int i;
				
				for ( i = 1; i < 32; i++) {
					String s= Integer.toString(i);
					s1=s1.concat(s+" ");
				}
				s1= "Month ".concat(s1);
				String[] s2 = s1.split(" ");
								
				cb1=  new JComboBox(s2);
				cb1.setBounds(250, 100, 100, 25);
				super.add(cb1);
				cb1.setFont(font);
				
				String s3="";
				int i2;
				
				for ( i2 = 2017; i2 < 2028; i2++) {
					String s= Integer.toString(i2);
					s3=s3.concat(s+" ");
				}
				s3= "Year ".concat(s3);
				String[] s4 = s3.split(" ");
				
				cb2=  new JComboBox(s4);
				cb2.setBounds(370, 100, 100, 25);
				super.add(cb2);
				cb2.setFont(font);
				
				
				l5=  new JLabel("Amount :");
				l5.setBounds(20, 130, 200, 25);
				super.add(l5);
				l5.setFont(font);
				
				tf1=  new JTextField();
				tf1.setBounds(250, 10, 250, 25);
				super.add(tf1);
				tf1.setFont(font);
				
				tf2=  new JTextField();
				tf2.setBounds(250, 40, 250, 25);
				super.add(tf2);
				tf2.setFont(font);
				
				tf3=  new JTextField();
				tf3.setBounds(250, 70, 100, 25);
				super.add(tf3);
				tf3.setFont(font);
					
				l6=  new JLabel(Sw1sil.cos);
				l6.setBounds(250, 130, 200, 25);
				super.add(l6);
				l6.setFont(font);
				
				
				b1 = new JButton("");
				b1.setBounds(180, 200, 200, 30);
				super.add(b1);
				b1.addActionListener(this);
				
				ImageIcon img1 = new ImageIcon("D:\\cetpa8july\\program\\button_pay.png");
				b1.setIcon(img1);
				
				
				super.setLayout(null);
				super.setVisible(true);
				super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b1){
				int card=0,cvv=0;
					String str1= tf1.getText();
					String str2= tf3.getText();
					String str3= tf2.getText();
					Object o1 = cb1.getSelectedItem();
					String str4 = o1.toString();
					Object o2 = cb2.getSelectedItem();
					String str5 = o2.toString();
					try {
						long ca = Long.parseLong(str1);
						
					} catch (Exception e2) {
					card++;
					}
					try {
						int ca = Integer.parseInt(str2);
						
					} catch (Exception e2) {
					cvv++;
					}
					
					
					if (str1.isEmpty()||str2.isEmpty()||str3.isEmpty()){
						JOptionPane.showMessageDialog(this, "Field should not left blank ");
					}
					if (!(str1.isEmpty()||str2.isEmpty()||str3.isEmpty())){
						//JOptionPane.showMessageDialog(this, "Field should not left blank ");	
					
					if(str1.length()!=16||card==1){
						JOptionPane.showMessageDialog(this, "Please input valid card number ");
					}
					if (str2.length()!=3||cvv==1){
						JOptionPane.showMessageDialog(this, "Please input valid cvv number ");
					}
					if (Validate.validateText(str3)){
						JOptionPane.showMessageDialog(this, "Name must contian alphabet only ");
					}
					if (str4.equalsIgnoreCase("month")){
						JOptionPane.showMessageDialog(this, "Please select month of expiry ");
					}
					if (str5.equalsIgnoreCase("year")){
						JOptionPane.showMessageDialog(this, "Please select year of expiry ");
					}
					
					
			if(!Validate.validateText(str3)&&str1.length()==16&&str2.length()==3&&card==0&&cvv==0&&!str4.equalsIgnoreCase("month")&&!str5.equalsIgnoreCase("year"))
			{
					
						
						JOptionPane.showMessageDialog(this, "Payment succesfull ");
						Sw1pays sw1ps = new Sw1pays();
						super.dispose();
						
					}
			}
					
				
				}
			}
			
			
			

			Sw1Atms sw1ats ;

			

		}


