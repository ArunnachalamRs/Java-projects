import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dba.ConnectionProvider;

public class Shad3gld extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4, l5;
	float cost = 0;
	float tc = 0, sc = 0;
	JTextField tf3, tf4, tf5;
	JButton b1, b2;
	static String s1, s2, cos;
	int a = 0, b = 0, rs;

	public Shad3gld() {

		super.setTitle("Seat type");
		super.setBounds(400, 100, 600, 500);
		super.setResizable(false);
		
		Font font=new Font("Courier New",Font.BOLD,16);
		
		l1 = new JLabel("Shadi Mei Zaor Ana");
		l1.setBounds(20, 20, 200, 30);
		super.add(l1);
		l1.setFont(font);
		
		l2 = new JLabel("Gold");
		l2.setBounds(270, 20, 200, 30);
		super.add(l2);
		l2.setFont(font);
		
		l3 = new JLabel("No. of Seat");
		l3.setBounds(20, 70, 200, 30);
		super.add(l3);
		l3.setFont(font);
		
		l4 = new JLabel("No of Snacks");
		l4.setBounds(20, 110, 200, 30);
		super.add(l4);
		l4.setFont(font);
		
		tf3 = new JTextField("");
		tf3.setBounds(270, 70, 200, 30);
		super.add(tf3);
		tf3.setEditable(true);

		tf4 = new JTextField("");
		tf4.setBounds(270, 110, 200, 30);
		super.add(tf4);
		tf4.setEditable(!false);

		b2 = new JButton("");
		b2.setBounds(180, 210, 200, 30);
		super.add(b2);
		b2.addActionListener(this);

		ImageIcon img1 = new ImageIcon("D:\\cetpa8july\\program\\book.png");
		b2.setIcon(img1);
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {

			if (e.getSource() == b2) {

				s1 = tf3.getText();

				a = Integer.parseInt(s1);

				s2 = tf4.getText();
				b = Integer.parseInt(s2);

				tc = (a * 300) + (a * 3 * 28);
				sc = (b * 200) + (b * 2 * 18);

				cost = tc + sc;
				cos = String.valueOf(cost);

				if (s1.isEmpty()) {
					JOptionPane.showMessageDialog(this, "please enter how many seat you want ");
				}
				if (s1.isEmpty()) {
					JOptionPane.showMessageDialog(this, "please enter how many snacks you want ");
				}
				if (a > 0 && a <= 20 && b >= 0 && b <= 200) {

					if (a <= ShadSc3.g) {

						try {

							rs = ShadSc3.g - a;
							Connection con = ConnectionProvider.getConnection();

							PreparedStatement ps = con.prepareStatement("update shaad3 set seat=? where Seat_type=?");
							ps.setInt(1, rs);
							ps.setString(2, "gold");
							ps.executeUpdate();

							con.close();
						} catch (Exception e2) {
							System.out.println("error" + e2);
						}

						Shad3Atmg shad3atg = new Shad3Atmg();
						super.dispose();

					}
					if (a > ShadSc3.g) {
						JOptionPane.showMessageDialog(this, "Seat not available only " + ShadSc3.g + " seat left");

					}

				}
				if (!(a > 0 && a <= 20)) {
					JOptionPane.showMessageDialog(this, "please input a valid seat number in range of 1-20");
				}
				if (!(b >= 0 && b <= 200)) {
					JOptionPane.showMessageDialog(this, "snacks must bein range of 0-200");
				}

			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Filled should not be left blanks.");
		}

	}

	
		Shad3gld Shad3g ;
	

}
