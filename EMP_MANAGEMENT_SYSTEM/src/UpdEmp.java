import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;
import java.sql.*;


public class UpdEmp {



    Connection connect = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:XE", "c##ABIKASH", "DBMS");


    public UpdEmp() throws SQLException {
    }

    public void UpdEmpFrame(String user) throws SQLException, IOException {


        JFrame Jupd = new JFrame("UPDATE EMPLOYEE DETAILS");

        final Image backgroundImage = javax.imageio.ImageIO.read(new File("Images/BackGroundDetails.png"));
        Jupd.setContentPane(new JPanel(new BorderLayout()) {
            @Override public void paintComponent(Graphics g) {
                g.drawImage(backgroundImage,0,0,500,500,null);
            }
        });

        JButton b1 = new JButton("NEXT");

        JTextField t2 = new JTextField();

        JLabel l1 =new JLabel("Enter Emp_Number:");l1.setForeground(Color.white);

        JTextField t1 = new JTextField();


        Jupd.setLayout(null);

        Jupd.add(b1);
        Jupd.add(t1);
        Jupd.add(l1);
        l1.setBounds(100,100,100,20);
        t1.setBounds(200,100,100,20);
        b1.setBounds(200,300,100,30);


        String sqlAdmin  = "Select UserType,Eno from EMLogin ";

        Statement Stmtlogin2 = connect.createStatement();
        final ResultSet[] eml = new ResultSet[1000];
        final String[] power = {null};




        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String E_Num = t1.getText();

                try {
                      if (!E_Num.isBlank()&& EnoValid(E_Num)) {

                            eml[0] = Stmtlogin2.executeQuery(sqlAdmin);
                            while (eml[0].next()) {

                                if (eml[0].getString(2).equals(E_Num)) {


                                    power[0] = eml[0].getString(1);
                                }
                            }

                            if (power[0].equals("r") || user.equals("a")) {

                                b1.setText("SuccessFull");

                                UpdEmpFrame2(E_Num, user);
                                Jupd.setVisible(false);

                            } else {
                                JOptionPane.showMessageDialog(Jupd, "You have no permission to edit an Write permission person details.");
                            }


                    }else{JOptionPane.showMessageDialog(Jupd,"The Entered Employee number is not in the List or null. ");}
                }  catch (SQLException ex) {
                         throw new RuntimeException(ex);}
                   catch (IOException ex) {
                         throw new RuntimeException(ex);}
            }
        });

        Jupd.setSize(500,500);
        Jupd.setVisible(true);
        Jupd.setResizable(false);
    }
    public void UpdEmpFrame2(String Num,String user) throws SQLException, IOException {

        JFrame jf1 = new JFrame();

        final Image backgroundImage = javax.imageio.ImageIO.read(new File("Images/BackGroundDetails.png"));
        jf1.setContentPane(new JPanel(new BorderLayout()) {
            @Override public void paintComponent(Graphics g) {
                g.drawImage(backgroundImage,0,0,800,700,null);
            }
        });

        JButton b1 = new JButton("Submit");b1.setBackground(Color.white);

        JLabel l1 =new JLabel("ENumber:");l1.setForeground(Color.white);
        JLabel l2 =new JLabel("Name:");l2.setForeground(Color.white);
        JLabel l3 =new JLabel("Designation:");l3.setForeground(Color.white);
        JLabel l4 =new JLabel("Department:");l4.setForeground(Color.white);
        JLabel l5 =new JLabel("PhoneNumber:");l5.setForeground(Color.white);
        JLabel l6 =new JLabel("Address:");l6.setForeground(Color.white);
        JLabel l7 =new JLabel("Salary:");l7.setForeground(Color.white);
        JLabel l8 =new JLabel("BloodGroup:");l8.setForeground(Color.white);
        JLabel l9 =new JLabel("AadharNo:");l9.setForeground(Color.white);
        JLabel l10 =new JLabel("PanNo:");l10.setForeground(Color.white);
        JLabel l11 =new JLabel("Experience:");l11.setForeground(Color.white);
        JLabel l12 = new JLabel("DateOfBirth:");l12.setForeground(Color.white);
        JLabel l13 = new JLabel("UserType:");l13.setForeground(Color.white);


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
        b1.setBounds(300,500,200,20);


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


        String sql = "select * from Employee where Eno = ?";


        PreparedStatement stmt = connect.prepareStatement(sql);

        stmt.setString(1,Num);

        ResultSet upd  = stmt.executeQuery();


        String splitted;
        final String[] revdate = {""};
        String unsplit = null;

        final String[] id = new String[1];
        final String[] name = new String[1];
        final String[] designation = new String[1];
        final String[] dept = new String[1];
        final String[] PhoneNo = new String[1];
        final String[] Address = new String[1];
        final String[] Salary = new String[1];
        final String[] BloodGroup = new String[1];
        final String[] AadharNo = new String[1];
        final String[] PanNo = new String[1];
        final String[] Experience = new String[1];
        final String[] type = new String[1];



        while (upd.next()) {


            if (upd.getString(1).equals(Num)) {
                t1.setText(upd.getString(1));
                t2.setText(upd.getString(2));
                t3.setText(upd.getString(3));
                t4.setText(upd.getString(4));
                t5.setText(upd.getString(5));
                t6.setText(upd.getString(6));
                t7.setText(upd.getString(7));
                t8.setText(upd.getString(8));
                t9.setText(upd.getString(9));
                t10.setText(upd.getString(10));
                t11.setText(upd.getString(11));
                unsplit = upd.getString(12);
                t13.setText(upd.getString(13));
                break;
            }
        }

         revdate[0] = reverseDate(unsplit);


        t12.setText(revdate[0]);

        String sql2 = "update Employee set ENo = ?, EName = ?, Designation = ?, Department = ?, PhoneNumber = ?, Address = ?, Salary = ?, BloodGroup = ?," +
                "   AadharNo=?, PanNo=?, Experience=? , DateOfBirth = ? ,UserType = ? where Eno = ?";
        String sqlLogin = "update EMLogin set UserName = ? ,PassWord = ? ,UserType = ?,Eno = ? where Eno = ?";

        PreparedStatement Stmt2 = connect.prepareStatement(sql2);
        PreparedStatement StmtLogin = connect.prepareStatement(sqlLogin);


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                id[0] = t1.getText();
                if(id[0].isBlank()){t1.setBackground(Color.red);}
                name[0] = t2.getText();
                if(name[0].isBlank()){t2.setBackground(Color.red);}
                designation[0] = t3.getText();
                dept[0] = t4.getText();
                PhoneNo[0] = t5.getText();
                Address[0] = t6.getText();
                Salary[0] = t7.getText();
                BloodGroup[0] = t8.getText();
                AadharNo[0] = t9.getText();
                PanNo[0] = t10.getText();
                if(PanNo[0].isBlank()){t10.setBackground(Color.red);}
                Experience[0] = t11.getText();
                revdate[0] = t12.getText();
                type[0] = t13.getText();
                if(type[0].isBlank()){t13.setBackground(Color.red);}


                if(!id[0].isBlank() && !name[0].isBlank() &&  !PanNo[0].isBlank() && !type[0].isBlank() ) {
                    try {
                        Stmt2.setString(1, id[0]);
                        Stmt2.setString(2, name[0]);
                        Stmt2.setString(3, designation[0]);
                        Stmt2.setString(4, dept[0]);
                        Stmt2.setString(5, PhoneNo[0]);
                        Stmt2.setString(6, Address[0]);
                        Stmt2.setString(7, Salary[0]);
                        Stmt2.setString(8, BloodGroup[0]);
                        Stmt2.setString(9, AadharNo[0]);
                        Stmt2.setString(10, PanNo[0]);
                        Stmt2.setString(11, Experience[0]);
                        Stmt2.setString(12, revdate[0]);

                        Stmt2.setString(14, id[0]);
                        StmtLogin.setString(1, name[0]);
                        StmtLogin.setString(2, PanNo[0]);

                        StmtLogin.setString(4, id[0]);
                        StmtLogin.setString(5, id[0]);

                        if ((user.equals("a") && (type[0].equals("w") )|| type[0].equals("r"))) {
                            Stmt2.setString(13, type[0]);
                            StmtLogin.setString(3, type[0]);
                        } else {
                            JOptionPane.showMessageDialog(jf1, "You are not an admin !!!, so the type is given default value r ");
                            Stmt2.setString(13, "r");
                            StmtLogin.setString(3, "r");
                        }


                        Stmt2.executeUpdate();
                        StmtLogin.executeUpdate();
                        b1.setText("Successful");

                        DbController db = new DbController();
                        db.DetailsView(type[0]);
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
    public String reverseDate(String unsplit){

        if(unsplit==null){unsplit=".............";}
        CharSequence[] splitted = unsplit.split(" ", 2);
        String rev = "";
        rev += splitted[0].charAt(8);
        rev += splitted[0].charAt(9);
        rev+= ".";
        rev+= splitted[0].charAt(5);
        rev+= splitted[0].charAt(6);
        rev+= ".";
        rev+= splitted[0].charAt(0);
        rev+= splitted[0].charAt(1);
        rev+= splitted[0].charAt(2);
        rev+= splitted[0].charAt(3);
        if(rev.equals("..........")){
            rev=null;
        }
        return rev;
    }

    public  boolean EnoValid(String Eno) throws SQLException {
        boolean check = false;

         String sqleno=  "Select Eno from Employee";
         Statement stmtEno = connect.createStatement();
         ResultSet checkEno = stmtEno.executeQuery(sqleno);

         while(checkEno.next()){
             if(checkEno.getString(1).equals(Eno)){
                 check = true;
                 break;
             }
         }
        return check;
    }


}

