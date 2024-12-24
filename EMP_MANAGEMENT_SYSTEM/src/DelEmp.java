import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class DelEmp {

    Connection connect = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:XE", "c##ABIKASH", "DBMS");




    public DelEmp() throws SQLException, ClassNotFoundException {

    }

    public void delEmpFrame(String user) throws SQLException, IOException {
        JFrame Fdel = new JFrame("DELETE EMPLOYEE DETAILS");

        final Image backgroundImage = javax.imageio.ImageIO.read(new File("Images/BackGroundDetails.png"));
        Fdel.setContentPane(new JPanel(new BorderLayout()) {
            @Override public void paintComponent(Graphics g) {
                g.drawImage(backgroundImage,0,0,800,700,null);
            }
        });

        JButton b1 = new JButton("DELETE");b1.setBackground(Color.white);

        JLabel l1 =new JLabel("Enter Emp_Number:");l1.setForeground(Color.white);

        JTextField t1 = new JTextField();

        String sql = "delete Employee where "+" Eno  = ?";

        PreparedStatement Stmt2 = connect.prepareStatement(sql);

        String sqlLog = "delete EMLogin where "+" Eno  = ?";

        PreparedStatement Stmtlog = connect.prepareStatement(sqlLog);

        String sqlAtt = "delete EmpAttendance where "+" Eno  = ?";

        PreparedStatement Stmt3 = connect.prepareStatement(sqlAtt);

        String sqlAdmin  = "Select UserType,Eno from EMLogin ";

        Statement Stmtlogin2 = connect.createStatement();

        Fdel.setLayout(null);

        Fdel.add(b1);
        Fdel.add(t1);
        Fdel.add(l1);
        l1.setBounds(100,100,100,20);
        t1.setBounds(200,100,100,20);
        b1.setBounds(200,300,100,30);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String E_Num = t1.getText();
                try {
                    if (E_Num != null && EnoValid(E_Num)) {

                        Stmt2.setString(1, E_Num);
                        Stmtlog.setString(1, E_Num);
                        Stmt3.setString(1, E_Num);

                        ResultSet s = Stmtlogin2.executeQuery(sqlAdmin);


                        int flag = 0;
                        while (s.next()) {

                            if (s.getString(2).equals(E_Num) && (s.getString(1).equals("r") || s.getString(1).equals("w"))) {
                                if (((s.getString(1).equals("w") && user.equals("a")) || s.getString(1).equals("r"))) {
                                    Stmt2.executeUpdate();
                                    Stmtlog.executeUpdate();
                                    Stmt3.executeUpdate();

                                    b1.setText("SuccessFull");

                                    DbController db = new DbController();
                                    db.DetailsView(s.getString(1));
                                    Fdel.setVisible(false);
                                    flag = 0;
                                    break;
                                } else {
                                    flag = 1;
                                }
                            } else {
                                flag = 2;
                            }

                        }
                        if (flag == 1) {
                            JOptionPane.showMessageDialog(Fdel, "YOU ARE NOT AN ADMIN TO PERFORM THIS OPERATION.");
                        } else if (flag == 2) {
                            JOptionPane.showMessageDialog(Fdel, "YOU CAN'T DELETE THE ATTENDANCE OF ANOTHER EDITTER !!!!");
                        }


                    } else {
                        JOptionPane.showMessageDialog(Fdel, "The Entered Employee number is not in the List or null. ");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        Fdel.setSize(500,500);
        Fdel.setVisible(true);
        Fdel.setResizable(false);

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
