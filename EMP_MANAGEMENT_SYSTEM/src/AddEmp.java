import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class AddEmp {
    Connection connect = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:XE", "c##ABIKASH", "DBMS");


    public static void main(String[] args) throws SQLException, IOException {
        AddEmp a = new AddEmp();
        a.AddEmpFrame("a");
    }
    public AddEmp() throws SQLException {

    }


    public void AddEmpFrame(String user) throws SQLException, IOException {



        JFrame jf1 = new JFrame();

        final Image backgroundImage = javax.imageio.ImageIO.read(new File("Images/BackGroundDetails.png"));
        jf1.setContentPane(new JPanel(new BorderLayout()) {
            @Override public void paintComponent(Graphics g) {
                g.drawImage(backgroundImage,0,0,800,700,null);
            }
        });

        JButton b1 = new JButton("Submit");b1.setBackground(Color.white);

        JLabel l1 =new JLabel("ENumber:");l1.setForeground(Color.WHITE);
        JLabel l2 =new JLabel("Name:");l2.setForeground(Color.WHITE);
        JLabel l3 =new JLabel("Designation:");l3.setForeground(Color.WHITE);
        JLabel l4 =new JLabel("Department:");l4.setForeground(Color.WHITE);
        JLabel l5 =new JLabel("PhoneNumber:");l5.setForeground(Color.WHITE);
        JLabel l6 =new JLabel("Address:");l6.setForeground(Color.WHITE);
        JLabel l7 =new JLabel("Salary:");l7.setForeground(Color.WHITE);
        JLabel l8 =new JLabel("BloodGroup:");l8.setForeground(Color.WHITE);
        JLabel l9 =new JLabel("AadharNo:");l9.setForeground(Color.WHITE);
        JLabel l10 =new JLabel("PanNo:");l10.setForeground(Color.WHITE);
        JLabel l11 =new JLabel("Experience:");l11.setForeground(Color.WHITE);
        JLabel l12 = new JLabel("DateOfBirth:");l12.setForeground(Color.WHITE);
        JLabel l13 = new JLabel("UserType:");l13.setForeground(Color.WHITE);


        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();
        JTextField t4 = new JTextField();
        JTextField t5 = new JTextField();
        JTextField t6 = new JTextField();
        JTextField t7 = new JTextField();
        JTextField t8 = new JTextField();
        JTextField t9 = new JTextField();
        JTextField t10 = new JTextField();
        JTextField t11 = new JTextField();
        JTextField t12 = new JTextField();
        JTextField t13 = new JTextField();


        jf1.setLayout(null);

        jf1.add(b1);
        b1.setBounds(250,500,200,20);

        final int TextX1 = 250;
        jf1.add(t1);
        t1.setBounds(TextX1,100,100,20);
        jf1.add(t2);
        t2.setBounds(TextX1,150,100,20);
        jf1.add(t3);
        t3.setBounds(TextX1,200,100,20);
        jf1.add(t4);
        t4.setBounds(TextX1,250,100,20);
        jf1.add(t5);
        t5.setBounds(TextX1,300,100,20);
        jf1.add(t6);
        final int TextX2 = 500;
        t6.setBounds(TextX2,100,100,20);
        jf1.add(t7);
        t7.setBounds(TextX2,150,100,20);
        jf1.add(t8);
        t8.setBounds(TextX2,200,100,20);
        jf1.add(t9);
        t9.setBounds(TextX2,250,100,20);
        jf1.add(t10);
        t10.setBounds(TextX2,300,100,20);
        jf1.add(t11);
        t11.setBounds(TextX1,350,100,20);
        jf1.add(t12);
        t12.setBounds(TextX2,350,100,20);
        jf1.add(t13);
        t13.setBounds(TextX1,400,100,20);


        final int labelX1 = 150;
        jf1.add(l1);
        l1.setBounds(labelX1,100,100,20);
        jf1.add(l2);
        l2.setBounds(labelX1,150,100,20);
        jf1.add(l3);
        l3.setBounds(labelX1,200,100,20);
        jf1.add(l4);
        l4.setBounds(labelX1,250,100,20);
        jf1.add(l5);
        l5.setBounds(labelX1,300,100,20);
        jf1.add(l6);

        final int labelX2 = 400;
        l6.setBounds(labelX2,100,100,20);
        jf1.add(l7);
        l7.setBounds(labelX2,150,100,20);
        jf1.add(l8);
        l8.setBounds(labelX2,200,100,20);
        jf1.add(l9);
        l9.setBounds(labelX2,250,100,20);
        jf1.add(l10);
        l10.setBounds(labelX2,300,100,20);
        jf1.add(l11);
        l11.setBounds(labelX1,350,100,20);
        jf1.add(l12);
        l12.setBounds(labelX2,350,100,20);
        jf1.add(l13);
        l13.setBounds(labelX1,400,100,20);





        String sql2 = "insert into Employee"+" values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String sqlLogin = "insert into EMLogin values(?,?,?,?)";


        PreparedStatement Stmt2 = connect.prepareStatement(sql2);
        PreparedStatement StmtLogin = connect.prepareStatement(sqlLogin);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {

                String id  = t1.getText();
                if(id.isBlank()){t1.setBackground(Color.red);t1.setForeground(Color.WHITE);}
                String name = t2.getText();
                if(name.isBlank()){t2.setBackground(Color.red);t2.setForeground(Color.WHITE);}
                String designation = t3.getText();
                String dept = t4.getText();
                String PhoneNo = t5.getText();
                String Address = t6.getText();
                String Salary = t7.getText();
                String BloodGroup = t8.getText();
                String AadharNo = t9.getText();
                String PanNo = t10.getText();
                if(PanNo.isBlank()){t10.setBackground(Color.red);t10.setForeground(Color.WHITE);}
                String Experience = t11.getText();
                String dob = t12.getText();
                String type = t13.getText();
                if(type.isBlank()){t13.setBackground(Color.red);t13.setForeground(Color.WHITE);}




                if(!id.isBlank() && !name.isBlank()  && !PanNo.isBlank() && !type.isBlank() && !type.equals("a")) {
                    try {


                        Stmt2.setString(1, id);
                        Stmt2.setString(2, name);
                        Stmt2.setString(3, designation);
                        Stmt2.setString(4, dept);
                        Stmt2.setString(5,PhoneNo);
                        Stmt2.setString(6,Address);
                        Stmt2.setString(7,Salary);
                        Stmt2.setString(8,BloodGroup);
                        Stmt2.setString(9,AadharNo);
                        Stmt2.setString(10, PanNo);
                        Stmt2.setString(11,Experience);
                        Stmt2.setString(12,dob);
                        StmtLogin.setString(1,name);
                        StmtLogin.setString(2,PanNo);
                        if(user.equals("a")){
                            StmtLogin.setString(3,type);
                            Stmt2.setString(13,type);
                        } else{
                            JOptionPane.showMessageDialog(jf1,"Since you are not an admin you can't provide write permission .");
                            StmtLogin.setString(3,"r");
                            Stmt2.setString(13,"r");
                        }

                        StmtLogin.setString(4,id);

                        b1.setText("Successful");


                        Stmt2.executeUpdate();
                        StmtLogin.executeUpdate();

                        DbController db = new DbController();
                        db.DetailsView(user);
                        jf1.setVisible(false);

                    } catch (SQLException ex) {
                        b1.setText("Failure");
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }else{JOptionPane.showMessageDialog(jf1,"Enter the values for the , red colour fields it can't be empty.");}
            }


        });

        jf1.setSize(800,700);
        jf1.setVisible(true);
        jf1.setResizable(false);

    }


}