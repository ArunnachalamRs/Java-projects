import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class MENU extends Container {

    Connection connect = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:XE", "c##ABIKASH", "DBMS");

    public MENU() throws SQLException {
    }

    public void EditterMenu(String user,String num) throws IOException, SQLException {
        JFrame J1 = new JFrame("EMPLOYEE DETAILS");

        final Image backgroundImage = javax.imageio.ImageIO.read(new File("Images/BackGroundDetails.png"));
        J1.setContentPane(new JPanel(new BorderLayout()) {
            @Override public void paintComponent(Graphics g) {
                g.drawImage(backgroundImage,0,0,800,700,null);
            }
        });

        JButton EmpDetailsButton = new JButton("Details");
        JButton AddEmpButton = new JButton("AddEmployee");
        JButton DelEmpButton = new JButton("DelEmployee");
        JButton UpdEmpButton = new JButton("UpdateEmployee");
        JButton AddAttButton = new JButton("AddAttendance");
        JButton  AttDetButton = new JButton("AttendanceDetails");
        JButton DelEmpAttButton = new JButton("DeleteEmpAttendance");
        JButton UpdEmpAttButton = new JButton("UpdateEmpAttendance");


        JButton LogOutButton = new JButton("LOGOUT");

        JLabel l1 = new JLabel("EMPLOYEE MANAGEMENT SOFTWARE WELCOMES YOU !!!");l1.setForeground(Color.white);l1.setFont(new Font("TimesRoman",Font.BOLD,20));
        JLabel l2 = new JLabel();l2.setForeground(Color.WHITE);l2.setFont(new Font("TimesRoman",Font.BOLD,18));
        J1.add(l1);
        J1.add(l2);
        l1.setBounds(100,50,700,40);
        l2.setBounds(250,150,400,40);

        if(user.equals("a")){
            l2.setText("ADMIN CONTROL MENU !!!");
        } else if (user.equals("w")) {
            l2.setText("EDIT  CONTROL  MENU !!!");
        }


        J1.setLayout(null);
        J1.add(EmpDetailsButton);
        EmpDetailsButton.setBounds(100,300,200,20);



        J1.add(AddEmpButton);
        AddEmpButton.setBounds(425,300,200,20);


        J1.add(DelEmpButton);
        DelEmpButton.setBounds(425,400,200,20);


        J1.add(UpdEmpButton);
        UpdEmpButton.setBounds(100,400,200,20);

        J1.add(AddAttButton);
        AddAttButton.setBounds(425,500,200,20);

        J1.add(AttDetButton);
        AttDetButton.setBounds(100,500,200,20);

        J1.add(DelEmpAttButton);DelEmpAttButton.setBounds(425,600,200,20);

        J1.add(UpdEmpAttButton);UpdEmpAttButton.setBounds(100,600,200,20);

        J1.add(LogOutButton);LogOutButton.setBounds(650,650,100,20);

        EmpDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    DbController d = new DbController();
                    d.DetailsView(user);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


            }

        });

        AddEmpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AddEmp a = new AddEmp();
                    a.AddEmpFrame(user);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        DelEmpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DelEmp del = new DelEmp();
                    del.delEmpFrame(user);
                } catch (SQLException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        DelEmpAttButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DelEmpAttendance del = new DelEmpAttendance();
                    del.delEmpAttendanceFrame(user,num);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        UpdEmpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UpdEmp u = new UpdEmp();
                    u.UpdEmpFrame(user);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        UpdEmpAttButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdEmplAttendance u = null;
                try {
                    u = new UpdEmplAttendance();
                    u.UpdEmpAttendanceFrame(user);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });


        AddAttButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Attendance att = new Attendance();
                    att.AddAttendance();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        Attendance att =new Attendance();
        AttDetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    att.Attendanceframe(num,user);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        LogOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    J1.setVisible(false);
                    Login l = new Login();
                    l.LoginFrame();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        J1.setSize(800,800);
        J1.setVisible(true);
        J1.setResizable(false);
    }

    public boolean UserMenu(String n,String user) throws SQLException, IOException {
        JFrame J1 = new JFrame("EMPLOYEE DETAILS");

        Container c = J1.getContentPane();


        final Image backgroundImage = javax.imageio.ImageIO.read(new File("Images/BackGroundDetails.png"));
        J1.setContentPane(new JPanel(new BorderLayout()) {
            @Override public void paintComponent(Graphics g) {
                g.drawImage(backgroundImage,0,0,800,700,null);
            }
        });






        JLabel Heading = new JLabel();Heading.setForeground(Color.WHITE);
        Heading.setFont(new Font("TimesRoman",Font.BOLD,16));
        Heading.setBounds(200,0,400,50);

        JLabel l1 = new JLabel("ENumber:");
        l1.setForeground(Color.white);
        JLabel l2 = new JLabel("Name:");
        l2.setForeground(Color.white);
        JLabel l3 = new JLabel("Designation:");
        l3.setForeground(Color.white);
        JLabel l4 = new JLabel("Department:");
        l4.setForeground(Color.white);
        JLabel l5 = new JLabel("PhoneNumber:");
        l5.setForeground(Color.white);
        JLabel l6 = new JLabel("Address:");
        l6.setForeground(Color.white);
        JLabel l7 = new JLabel("Salary:");
        l7.setForeground(Color.white);
        JLabel l8 = new JLabel("BloodGroup:");
        l8.setForeground(Color.white);
        JLabel l9 = new JLabel("AadharNo:");
        l9.setForeground(Color.white);
        JLabel l10 = new JLabel("PanNo:");
        l10.setForeground(Color.white);
        JLabel l11 = new JLabel("Experience:");
        l11.setForeground(Color.white);
        JLabel l12 = new JLabel("DateOfBirth:");
        l12.setForeground(Color.white);
        JLabel l13 = new JLabel("UserType:");
        l13.setForeground(Color.white);

        JLabel la1 = new JLabel();
        la1.setForeground(Color.white);
        JLabel la2 = new JLabel();
        la2.setForeground(Color.white);
        JLabel la3 = new JLabel();
        la3.setForeground(Color.white);
        JLabel la4 = new JLabel();
        la4.setForeground(Color.white);
        JLabel la5 = new JLabel();
        la5.setForeground(Color.white);
        JLabel la6 = new JLabel();
        la6.setForeground(Color.white);
        JLabel la7 = new JLabel();
        la7.setForeground(Color.white);
        JLabel la8 = new JLabel();
        la8.setForeground(Color.white);
        JLabel la9 = new JLabel();
        la9.setForeground(Color.white);
        JLabel la10 = new JLabel();
        la10.setForeground(Color.white);
        JLabel la11 = new JLabel();
        la11.setForeground(Color.white);
        JLabel la12 = new JLabel();
        la12.setForeground(Color.white);
        JLabel la13 = new JLabel();
        la13.setForeground(Color.white);

        J1.setLayout(null);

        J1.add(Heading);
        final int Label2X1 = 250;
        J1.add(la1);
        la1.setBounds(Label2X1, 100, 100, 20);
        J1.add(la2);
        la2.setBounds(Label2X1, 150, 100, 20);
        J1.add(la3);
        la3.setBounds(Label2X1, 200, 100, 20);
        J1.add(la4);
        la4.setBounds(Label2X1, 250, 100, 20);
        J1.add(la5);
        la5.setBounds(Label2X1, 300, 100, 20);
        J1.add(la6);
        final int Label2X2 = 500;
        la6.setBounds(Label2X1, 400, 400, 20);
        J1.add(la7);
        la7.setBounds(Label2X2, 150, 100, 20);
        J1.add(la8);
        la8.setBounds(Label2X2, 200, 100, 20);
        J1.add(la9);
        la9.setBounds(Label2X2, 250, 100, 20);
        J1.add(la10);
        la10.setBounds(Label2X2, 300, 100, 20);
        J1.add(la11);
        la11.setBounds(Label2X1, 350, 100, 20);
        J1.add(la12);
        la12.setBounds(Label2X2, 100, 100, 20);
        J1.add(la13);
        la13.setBounds(Label2X2, 350, 100, 20);


        final int labelX1 = 150;
        J1.add(l1);
        l1.setBounds(labelX1, 100, 100, 20);
        J1.add(l2);
        l2.setBounds(labelX1, 150, 100, 20);
        J1.add(l3);
        l3.setBounds(labelX1, 200, 100, 20);
        J1.add(l4);
        l4.setBounds(labelX1, 250, 100, 20);
        J1.add(l5);
        l5.setBounds(labelX1, 300, 100, 20);
        J1.add(l6);

        final int labelX2 = 400;
        l6.setBounds(labelX1, 400, 400, 20);
        J1.add(l7);
        l7.setBounds(labelX2, 150, 100, 20);
        J1.add(l8);
        l8.setBounds(labelX2, 200, 100, 20);
        J1.add(l9);
        l9.setBounds(labelX2, 250, 100, 20);
        J1.add(l10);
        l10.setBounds(labelX2, 300, 100, 20);
        J1.add(l11);
        l11.setBounds(labelX1, 350, 100, 20);
        J1.add(l12);
        l12.setBounds(labelX2, 100, 100, 20);
        J1.add(l13);
        l13.setBounds(labelX2, 350, 100, 20);


        String sql = "Select * from Employee where Eno = ?";
        PreparedStatement Stmt2 = connect.prepareStatement(sql);

        Stmt2.setString(1, n);
        ResultSet detFull = Stmt2.executeQuery();

        String sql2= "Select ENO from Employee where Eno ="+n;
        Statement stmt1 = connect.createStatement();
        ResultSet checkRS = stmt1.executeQuery(sql2);
        boolean check = true;

        while(checkRS.next()){
            if(checkRS.getString(1).equals(n)){
                J1.setVisible(true);
                check = false;
                break;
            }else{
                J1.setVisible(false);
            }
        }


        String type = null,rev=null;
        while (detFull.next()) {
            la1.setText(detFull.getString(1));
            Heading.setText("WELCOME " + detFull.getString(2).toUpperCase() + " HAVE A GOOD DAY.");
            la2.setText(detFull.getString(2));
            la3.setText(detFull.getString(3));
            la4.setText(detFull.getString(4));
            la5.setText(detFull.getString(5));
            la6.setText(detFull.getString(6));
            la7.setText(detFull.getString(7));
            la8.setText(detFull.getString(8));
            la9.setText(detFull.getString(9));
            la10.setText(detFull.getString(10));
            la11.setText(detFull.getString(11));

                rev = reverseDate(detFull.getString(12));

            la12.setText(rev);
            la13.setText(detFull.getString(13));
             type = detFull.getString(13);
        }
          Attendance att =new Attendance();
        JFrame Frame1 = null;
                try {
                    if(user.equals("r")){
                         Frame1 = att.Attendanceframe(n, type);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

        if(user.equals("r")) {
            JButton LogOutButton = new JButton("LOGOUT");
            J1.add(LogOutButton);
            LogOutButton.setBounds(650, 600, 100, 20);

            JFrame finalFrame = Frame1;
            LogOutButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        J1.setVisible(false);
                        Login l = new Login();
                        l.LoginFrame();
                        finalFrame.setVisible(false);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
        }


        c.setBackground(Color.WHITE);
        c.setForeground(Color.WHITE);




        J1.setSize(800, 700);
        J1.setResizable(false);
        return check;
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




}


