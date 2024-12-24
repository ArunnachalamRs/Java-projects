import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class DelEmpAttendance {

JFrame FdelAtt = new JFrame("DELETE EMPLOYEE ATTENDANCE ");

    public DelEmpAttendance() throws SQLException {


    }

    Connection connect = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:XE", "c##ABIKASH", "DBMS");



    public void delEmpAttendanceFrame(String user,String num2) throws SQLException, IOException {

        final Image backgroundImage = javax.imageio.ImageIO.read(new File("Images/BackGroundDetails.png"));
        FdelAtt.setContentPane(new JPanel(new BorderLayout()) {
            @Override public void paintComponent(Graphics g) {
                g.drawImage(backgroundImage,0,0,800,700,null);
            }
        });

        JButton b1 = new JButton("DELETE");b1.setBackground(Color.white);

        JLabel l1 =new JLabel("Enter Emp_Number:");l1.setForeground(Color.white);

        JLabel l2 = new JLabel("Enter the date :");l2.setForeground(Color.WHITE);

        JTextField t1 = new JTextField();

        JTextField t2 = new JTextField();

        String sql = "delete EmpAttendance where "+" Eno  = ? and DateWork = ?";

        PreparedStatement Stmt2 = connect.prepareStatement(sql);


        String sqlAdmin  = "Select UserType,Eno from EMLogin ";

        Statement Stmtlogin2 = connect.createStatement();

        FdelAtt.setLayout(null);

        FdelAtt.add(b1);
        FdelAtt.add(t1);
        FdelAtt.add(l1);
        FdelAtt.add(t2);
        FdelAtt.add(l2);
        l1.setBounds(100,100,100,20);
        l2.setBounds(100,200,100,20);
        t1.setBounds(200,100,100,20);
        t2.setBounds(200,200,100,20);
        b1.setBounds(200,300,100,30);


        Attendance a = new Attendance();

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String E_Num = t1.getText();
                String Date = (t2.getText());

                try {
                    if (E_Num != null && Date != null ) {
                        if (EnoValid(E_Num)) {

                            Stmt2.setString(1, E_Num);
                            Stmt2.setString(2, Date);


                            ResultSet s = Stmtlogin2.executeQuery(sqlAdmin);


                            int flag = 0;
                            while (s.next()) {

                                if (s.getString(2).equals(E_Num)) {
                                    if (((s.getString(1).equals("w") && user.equals("a")) || s.getString(1).equals("r"))) {
                                        Stmt2.executeUpdate();

                                        b1.setText("SuccessFull");


                                        FdelAtt.setVisible(false);
                                        a.Attendanceframe(user, num2);
                                        flag = 0;
                                        break;
                                    } else {
                                        flag = 1;
                                    }
                                }
                            }
                            if (flag == 1) {
                                JOptionPane.showMessageDialog(FdelAtt, "YOU ARE NOT AN ADMIN TO PERFORM THIS OPERATION !!!!");
                            }


                        }else{JOptionPane.showMessageDialog(FdelAtt,"The Entered Employee number in not int the DataBase .");}
                    }else {JOptionPane.showMessageDialog(FdelAtt,"Enter the Employee Number and Date .");}
                }catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
        });

        FdelAtt.setSize(500,500);
        FdelAtt.setVisible(true);
        FdelAtt.setResizable(false);

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
