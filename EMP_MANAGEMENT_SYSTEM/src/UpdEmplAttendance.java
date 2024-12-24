import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class UpdEmplAttendance
{
    public UpdEmplAttendance() throws SQLException {


    }
    Connection connect = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:XE", "c##ABIKASH", "DBMS");

    public void UpdEmpAttendanceFrame(String user) throws SQLException, IOException {


        JFrame Jupd = new JFrame("UPDATE EMPLOYEE Attendance");

        final Image backgroundImage = javax.imageio.ImageIO.read(new File("Images/BackGroundDetails.png"));
        Jupd.setContentPane(new JPanel(new BorderLayout()) {
            @Override public void paintComponent(Graphics g) {
                g.drawImage(backgroundImage,0,0,500,500,null);
            }
        });

        JButton b1 = new JButton("NEXT");

        JTextField t1 = new JTextField();

        JLabel l1 =new JLabel("Enter Emp_Number:");l1.setForeground(Color.white);

        JLabel l2 =new JLabel("Enter Date:");l2.setForeground(Color.white);

        JTextField t2 = new JTextField();

        JTextField t3 = new JTextField();


        Jupd.setLayout(null);

        Jupd.add(b1);
        Jupd.add(t1);
        Jupd.add(t2);
        Jupd.add(l2);
        Jupd.add(l1);
        l1.setBounds(100,100,100,20);
        t1.setBounds(200,100,100,20);
        l2.setBounds(100,200,100,20);
        t2.setBounds(200,200,100,20);

        b1.setBounds(200,300,100,30);


        String sqlAdmin  = "Select UserType,Eno from EMLogin ";

        Statement Stmtlogin2 = connect.createStatement();
        final ResultSet[] eml = new ResultSet[1000];
        final String[] power = {"r"};




        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String E_Num = t1.getText();
                String Datework = (t2.getText());


                try {
                    if(!E_Num.isBlank() && !Datework.isBlank()) {
                        if(EnoValid(E_Num)) {
                            eml[0] = Stmtlogin2.executeQuery(sqlAdmin);
                            while (eml[0].next()) {

                                if (eml[0].getString(2).equals(E_Num)) {

                                    power[0] = eml[0].getString(1);


                                }
                            }

                            if (power[0].equals("r") || user.equals("a")) {

                                b1.setText("SuccessFull");

                                UpdEmpFrame2(E_Num, user, Datework);
                                Jupd.setVisible(false);

                            } else {
                                JOptionPane.showMessageDialog(Jupd, "You have no permission to edit an Write permission person Attendace.");
                            }
                        }else{JOptionPane.showMessageDialog(Jupd,"The Entered Employee number in not int the DataBase .");}
                    }else {JOptionPane.showMessageDialog(Jupd,"Enter the Employee Number and Date .");}

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        Jupd.setSize(500,500);
        Jupd.setVisible(true);
        Jupd.setResizable(false);
    }
    public void UpdEmpFrame2(String Num,String user,String date) throws SQLException, IOException {

        JFrame jf1 = new JFrame();

        final Image backgroundImage = javax.imageio.ImageIO.read(new File("Images/BackGroundDetails.png"));
        jf1.setContentPane(new JPanel(new BorderLayout()) {
            @Override public void paintComponent(Graphics g) {
                g.drawImage(backgroundImage,0,0,800,700,null);
            }
        });

        JButton b1 = new JButton("Submit");b1.setBackground(Color.white);

        JLabel l1 =new JLabel("ENumber:");l1.setForeground(Color.white);
        JLabel l2 =new JLabel("EName:");l2.setForeground(Color.white);
        JLabel l3 =new JLabel("Date:");l3.setForeground(Color.white);
        JLabel l4 =new JLabel("Attendance");l4.setForeground(Color.white);
        JLabel lt1 = new JLabel();lt1.setForeground(Color.white);
        JLabel lt2 = new JLabel();lt2.setForeground(Color.white);
        JLabel lt3 = new JLabel();lt3.setForeground(Color.white);

        JTextField t4 = new JTextField();


        jf1.setLayout(null);

        jf1.add(b1);
        b1.setBounds(300,500,200,20);


        final int TextX1 = 250;
        jf1.add(lt1);
        lt1.setBounds(TextX1,100,100,20);
        jf1.add(lt2);
        lt2.setBounds(TextX1,150,100,20);
        jf1.add(lt3);
        lt3.setBounds(TextX1,200,100,20);
        jf1.add(t4);
        t4.setBounds(TextX1,250,100,20);



        final int labelX1 = 150;
        jf1.add(l1);
        l1.setBounds(labelX1,100,100,20);
        jf1.add(l2);
        l2.setBounds(labelX1,150,100,20);
        jf1.add(l3);
        l3.setBounds(labelX1,200,100,20);
        jf1.add(l4);
        l4.setBounds(labelX1,250,100,20);



        String sql = "select * from EmpAttendance where Eno = ? and DateWork = ?";

        PreparedStatement stmt = connect.prepareStatement(sql);

        stmt.setString(1,Num);


        stmt.setString(2,date);




        ResultSet upd  = stmt.executeQuery();



        final String[] id = new String[1];
        final String[] name = new String[1];
        final String[] datework = new String[1];
        final String[] Attendance = new String[1];



        while (upd.next()) {


            if (upd.getString(1).equals(Num)) {
                lt1.setText(upd.getString(1));
                lt2.setText(upd.getString(2));
                lt3.setText(reverseDate(upd.getString(3)));
                t4.setText(upd.getString(4));
                break;
            }
        }

        id[0] = upd.getString(1);
        name[0] = upd.getString(2);
        datework[0] = reverseDate(upd.getString(3));

        String sqlAtt = "update EmpAttendance set Eno = ? ,Ename = ? ,DateWork = ?,Present = ? where (Eno = ? and DateWork = ?)";


        PreparedStatement stmtAtt = connect.prepareStatement(sqlAtt);


        String sqlAdmin  = "Select UserType,Eno from EMLogin ";

        Statement Stmtlogin2 = connect.createStatement();

        Attendance a = new Attendance();

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Attendance[0] = t4.getText();


                int flag = 0;
                ResultSet s = null;
                try {
                    s = Stmtlogin2.executeQuery(sqlAdmin);



                    while(s.next()) {

                        if (id[0] != null || name[0] != null || datework[0] != null || Attendance[0] != null) {


                                stmtAtt.setString(1, id[0]);
                                stmtAtt.setString(2, name[0]);
                                stmtAtt.setString(3, datework[0]);
                                stmtAtt.setString(4, Attendance[0]);
                                stmtAtt.setString(5, id[0]);
                                stmtAtt.setString(6, datework[0]);


                                stmtAtt.executeUpdate();
                                b1.setText("Successful");
                                a.Attendanceframe(Num,date);

                                jf1.setVisible(false);
                                flag = 0;
                                break;

                        }else{flag = 2;}
                    }
                    if(flag == 2){JOptionPane.showMessageDialog(jf1,"Enter 1(Present) or 0(Absent) in the box ,it can't be left empty .");}
                } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }


        });



        jf1.setSize(800,700);
        jf1.setVisible(true);
        jf1.setResizable(false);

    }


    public String reverseDate(String unsplit){

        CharSequence[] splitted = unsplit.split(" ", 2);
        String rev = "";
        rev += splitted[0].charAt(8);
        rev += splitted[0].charAt(9);
        rev+= splitted[0].charAt(7);
        rev+= splitted[0].charAt(5);
        rev+= splitted[0].charAt(6);
        rev+= splitted[0].charAt(4);
        rev+= splitted[0].charAt(0);
        rev+= splitted[0].charAt(1);
        rev+= splitted[0].charAt(2);
        rev+= splitted[0].charAt(3);
        return rev;
    }

    public  boolean EnoValid(String Eno) throws SQLException {
        boolean check = false;

        String sqleno=  "Select Eno from EmpAttendance";
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
