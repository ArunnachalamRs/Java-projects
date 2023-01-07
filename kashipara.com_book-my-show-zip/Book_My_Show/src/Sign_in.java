import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dba.ConnectionProvider;

public class Sign_in extends JFrame implements ActionListener {

	JLabel l1, l2;
	JButton b1, b2, b3;
	JTextField tf1;
	JPasswordField pf;
	static String name, email, mob, city;

	public Sign_in() {

		super.setTitle("Sign In");
		super.setBounds(400, 100, 600, 500);
		super.setResizable(false);

		Font font = new Font("Courier New", Font.BOLD, 20);
		l1 = new JLabel("Email");
		l1.setBounds(100, 100, 100, 25);
		super.add(l1);
		l1.setFont(font);

		l2 = new JLabel("Password");
		l2.setBounds(100, 135, 100, 25);
		super.add(l2);
		l2.setFont(font);

		tf1 = new JTextField("");
		tf1.setBounds(210, 100, 200, 25);
		super.add(tf1);

		pf = new JPasswordField();
		pf.setBounds(210, 135, 200, 25);
		super.add(pf);

		b1 = new JButton("");
		b1.setBounds(210, 180, 200, 35);
		super.add(b1);
		b1.addActionListener(this);

		b2 = new JButton("");
		b2.setBounds(210, 225, 200, 35);
		super.add(b2);
		b2.addActionListener(this);
		
		b3 = new JButton("");
		b3.setBounds(210, 270, 200, 35);
		super.add(b3);
		b3.addActionListener(this);
		
		
		ImageIcon img1 = new ImageIcon("D:\\cetpa8july\\program\\button_login.png");
		b1.setIcon(img1);
		
		ImageIcon img2 = new ImageIcon("D:\\cetpa8july\\program\\sign-up.png");
		b2.setIcon(img2);
		
		ImageIcon img3 = new ImageIcon("D:\\cetpa8july\\program\\fp.png");
		b3.setIcon(img3);
		
		

		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {

			if (e.getSource() == b1) {

				String s1 = tf1.getText();
				char[] ch = pf.getPassword();
				String s2 = new String(ch);

				try {

					Connection con = ConnectionProvider.getConnection();

					String sql = "select * from user_info where email=? and password=?";
					PreparedStatement ps = con.prepareStatement(sql);

					ps.setString(1, s1);
					ps.setString(2, s2);
					ResultSet rs = ps.executeQuery();

					if (rs.next()) {

						name = rs.getString("name");
						email = rs.getString("email");
						mob = rs.getString("mobile");
						city = rs.getString("city");
						// System.out.println(name+email+mob+city);
						Movies m = new Movies();
						super.dispose();

					} else {
						JOptionPane.showMessageDialog(this, "Inavlid user name or password");

					}
					con.close();
				} catch (Exception e2) {
					System.out.println("erroe " + e2);

				}

			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Filled cannot be left blank");
		}

		if (e.getSource() == b2) {

			Sign_up su = new Sign_up();
			super.dispose();
		}
		if (e.getSource() == b3) {
			
			try {

				String email=JOptionPane.showInputDialog("Enter Email Id:");
				Connection con=ConnectionProvider.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from user_info where email=?");
				ps.setString(1,email);
				ResultSet rs=ps.executeQuery();
				if (rs.next()) {
					String password=rs.getString("password");
					MailDemo.send("gulfamhassan.993@gmail.com","mozammil",email,"Your Password","Your password is >" +password);
			
					JOptionPane.showMessageDialog(this,"Your Password has been sent to your Email Id:");
				}
				else {
					JOptionPane.showMessageDialog(this,"Invalid Email Id!!!","Error",JOptionPane.ERROR_MESSAGE);
				}
				con.close();
				
			} catch (Exception e2) {
				System.out.println("error" +e);
			}

		}

	}

	public static void main(String[] args) {
		Sign_in si = new Sign_in();

	}

}
