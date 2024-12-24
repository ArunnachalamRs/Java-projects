import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class Login {
    JFrame jl = new JFrame(" LOGIN ");





    Connection connect = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:XE", "c##ABIKASH", "DBMS");



    Container c = jl.getContentPane();

    public Login() throws SQLException, IOException {
    }

    public void LoginFrame() throws SQLException, IOException {

        jl.setFont(new Font("TimesRoman",Font.BOLD,14));


        final BufferedImage backgroundImage = ImageIO.read(new File("Images/BackGroundDetails.png"));
        jl.setContentPane(new JPanel(new BorderLayout()) {
            @Override public void paintComponent(Graphics g) {
                g.drawImage(backgroundImage,0,0,400,400,null);
            }
        });

        JLabel l1= new JLabel("UserName:");
        l1.setForeground(Color.white);
        JLabel l2 = new JLabel("Password:");
        l2.setForeground(Color.white);
        JLabel Heading = new JLabel("   ENTER YOU LOGIN INFO");
        Heading.setFont(new Font("TimesRoman",Font.BOLD,14));
        Heading.setBounds(100,20,200,30);
        Heading.setForeground(Color.WHITE);
        jl.add(Heading);



        MENU m = new MENU();

        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();

        JButton b1 = new JButton("Submit");
        b1.setBackground(Color.getColor("#03103a"));


        String sql ="Select * from EMLogin";

       Statement StmtLogin = connect.createStatement();


        jl.add(l1);
        jl.add(l2);
        jl.add(t1);
        jl.add(t2);
        jl.add(b1);

        l1.setBounds(100,100,100,20);
        l2.setBounds(100,200,100,20);
        t1.setBounds(200,100,100,20);
        t2.setBounds(200,200,100,20);
        b1.setBounds(150,300,100,20);


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String UName = t1.getText();
                String Pass = t2.getText();


                String UN = null;
                String PW = null;
                String Type = null;
                String ENO = null;

                ResultSet s = null;
                try {
                    s = StmtLogin.executeQuery(sql);


                    if (UName != null || Pass != null) {



                            while (s.next()) {

                                if (s.getString(1).equals(UName) && s.getString(2).equals(Pass)) {


                                    UN = s.getString(1);
                                    PW = s.getString(2);
                                    Type = s.getString(3);
                                    ENO = s.getString(4);
                                }
                            }


                            if (UName.equals(UN) && Pass.equals(PW)) {
                                if ("w".equals(Type) || "a".equals(Type)) {

                                    c.setBackground(Color.CYAN);
                                    c.setForeground(Color.CYAN);
                                    m.EditterMenu(Type, ENO);
                                    jl.setVisible(false);
                                } else if ("r".equals(Type)) {
                                    c.setBackground(Color.DARK_GRAY);
                                    c.setForeground(Color.DARK_GRAY);
                                    m.UserMenu(ENO, Type);
                                    jl.setVisible(false);
                                }
                            } else {
                                c.setBackground(Color.red);
                                c.setForeground(Color.red);
                                JOptionPane.showMessageDialog(jl, "The Entered UserName or Password is wrong,Re-enter once again.");

                            }
                    }else{JOptionPane.showMessageDialog(jl,"Null values are not accepted, Enter a valid UserName and Password .");}
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });



        jl.setLayout(null);
        jl.setSize(400,400);
        jl.setVisible(true);
        jl.setResizable(false);



    }

}
