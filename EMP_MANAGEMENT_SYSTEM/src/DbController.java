

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DbController {

    JFrame jf = new JFrame("EMPLOYEE DETAILS");




    private String[][] ResultSetArray;

    Connection connect = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:XE", "c##ABIKASH", "DBMS");

    public DbController() throws SQLException {
    }


    public Container DetailsView(String UserType) throws SQLException, IOException {


        JButton b1 = new JButton("  Search");
        b1.setIcon(new ImageIcon(((new ImageIcon("Images/SearchIcon.jpg"))
                .getImage()).getScaledInstance(30, 20, java.awt.Image.SCALE_SMOOTH)));

        JLabel l1 = new JLabel("Enter Eno of Employee To Be Searched: ");
        JTextField t1 = new JTextField();

        Statement Stmt2 = connect.createStatement();
        ResultSet detFull = Stmt2.executeQuery("Select * from Employee ORDER BY Eno");



        ResultSetMetaData metadata =  detFull.getMetaData();
        int numberOfColumns = metadata.getColumnCount();



        ResultSetArray= new String[10000][numberOfColumns];

        int i=0,row=0;

        while (detFull.next()) {
            for (int j = 0; j < numberOfColumns; j++) {
                ResultSetArray[i][j] = detFull.getString(j + 1);
            }
            ResultSetArray[i][11]=reverseDate(ResultSetArray[i][11]);
            row++;
            i++;
        }
        final Image backgroundImage = javax.imageio.ImageIO.read(new File("Images/BackGroundDetails.png"));
        jf.setContentPane(new JPanel(new BorderLayout()) {
            @Override public void paintComponent(Graphics g) {
                g.drawImage(backgroundImage,0,0,1400,800,null);
            }
        });

        String[] column={"Emp_No","EmpName","Designation","Department","PhoneNumber","Address","Salary","BloodGroup",
                "AadharNo","PanNumber","Experience","DateOfBirth","UserType"};

            JTable detail_Table = new JTable(ResultSetArray, column);
            JScrollPane JScrollPane1 = new JScrollPane( detail_Table );
            jf.add(JScrollPane1);
            JScrollPane1.setOpaque(false);


        jf.add(b1);
        b1.setBounds(625,650,150,20);

        jf.add(l1);
        l1.setBounds(450,600,250,20);l1.setForeground(Color.WHITE);
        jf.add(t1);
        t1.setBounds(700,600,200,20);




        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String n = t1.getText();
                if (!n.isBlank()) {
                    MENU m = null;
                    try {
                        m = new MENU();
                        boolean c = m.UserMenu(n, UserType);
                        if(c==true){JOptionPane.showMessageDialog(jf,"The given Employee number is not in the DataBase !!!");}
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            }
        });

        JScrollPane1.setBounds(0,0,1400,500);



        jf.setLayout(null);
        jf.setVisible(true);
        jf.setSize(1400,800);

        return null;
    }

    public String reverseDate(String unsplit){

        if(unsplit==null){unsplit=".............";}
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
        if(rev.equals("..........")){
            rev=null;
        }
        return rev;
    }




}