
import javax.imageio.ImageIO;
import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;
import java.sql.*;

import static java.lang.Thread.sleep;


public class Attendance {


    public static void main(String[] args) throws SQLException, IOException {
        Attendance a = new Attendance();
        a.AddAttendance();
    }


    public Attendance() throws SQLException {


    }

    Connection connect = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:XE", "c##ABIKASH", "DBMS");


    public void AddAttendance() throws SQLException, IOException {
        JFrame ji = new JFrame("Add Attendance");ji.setFont(new Font("TimesRoman",Font.BOLD,14));

        final Image backgroundImage = ImageIO.read(new File("Images/BackGroundDetails.png"));
        ji.setContentPane(new JPanel(new BorderLayout()) {
            @Override public void paintComponent(Graphics g) {
                g.drawImage(backgroundImage,0,0,800,700,null);
            }
        });

        JButton b1 = new JButton("INSERT");b1.setBackground(Color.white);

        JLabel l1 =new JLabel("ENumber:");l1.setForeground(Color.WHITE);
        JLabel l2 =new JLabel("Name:");l2.setForeground(Color.WHITE);
        JLabel l3 =new JLabel("Date:");l3.setForeground(Color.WHITE);
        JLabel l4 =new JLabel("Attendance(0 or 1):");l4.setForeground(Color.WHITE);


        JLabel lt1 = new JLabel();
        JLabel lt2 = new JLabel();
        JTextField t3 = new JTextField();
        JTextField t4 = new JTextField();


        ji.setLayout(null);

        ji.add(b1);
        b1.setBounds(150,400,200,20);

        final int TextX1 = 275;
        ji.add(lt1);
        lt1.setBounds(TextX1,100,100,20);lt1.setBackground(Color.white);lt1.setForeground(Color.WHITE);
        ji.add(lt2);
        lt2.setBounds(TextX1,150,100,20);lt2.setBackground(Color.white);lt2.setForeground(Color.WHITE);
        ji.add(t3);
        t3.setBounds(TextX1,200,100,20);
        ji.add(t4);
        t4.setBounds(TextX1,250,100,20);



        final int labelX1 = 125;
        ji.add(l1);
        l1.setBounds(labelX1,100,100,20);
        ji.add(l2);
        l2.setBounds(labelX1,150,100,20);
        ji.add(l3);
        l3.setBounds(labelX1,200,100,20);
        ji.add(l4);
        l4.setBounds(labelX1,250,100,20);

        String sql2 = "insert into EmpAttendance values (?,?,?,?)";
        String Emp =  "select Eno,Ename from Employee";

        PreparedStatement Stmt = connect.prepareStatement(sql2);
        Statement stmtEmp = connect.createStatement();
        ResultSet E = stmtEmp.executeQuery(Emp);

        int row = 0;
        final int[] i = {0};
        String[][] Attend = new String[10000][2];
         while(E.next()){
             for(int j=0;j<E.getMetaData().getColumnCount();j++) {
                 Attend[i[0]][j] = E.getString(j+1);
             }
             i[0]++;
             row++;
        }


        final String[] D = {"01.01.2022"};
        String P = "1";

        i[0] =0;
        final String[] n = {Attend[i[0]][0]};
        final String[] Name = {Attend[i[0]][1]};

            lt1.setText(n[0]);
            lt2.setText(Name[0]);
            t3.setText(D[0]);
            t4.setText(P);

        int finalRow = row;
        b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String WDate = t3.getText();
                    D[0] = t3.getText();
                    String Present = t4.getText();
                    if(n[0]==null){}

                    if (n[0] != null && Name[0] != null && WDate != null && Present != null) {
                        try {
                            Stmt.setString(1, n[0]);
                            Stmt.setString(2, Name[0]);
                            Stmt.setString(3, WDate);
                            Stmt.setString(4, Present);

                            if(repetationControl(n[0],WDate)==false){

                            Stmt.executeUpdate();
                            b1.setText(n[0] +" Successful");
                            }else{
                                b1.setText("Redundant date.");
                            }
                            i[0]++;
                          if(i[0] < finalRow){
                            lt1.setText(repeatNo(Attend,i[0]));
                            lt2.setText(repeatName(Attend,i[0]));
                            n[0] =repeatNo(Attend,i[0]);
                            Name[0] =repeatName(Attend,i[0]);
                          }
                          else{
                              ji.setVisible(false);
                          }
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }



                    }


                }
            });




        ji.setLayout(null);
        ji.setSize(500,500);
        ji.setResizable(false);
        ji.setVisible(true);
    }
    public String repeatNo(String[][] a,int i){
        String num= a[i][0];
        return num ;
    }
    public String repeatName(String[][] a,int i){
        String nam = a[i][1];
        return nam;
    }



    public JFrame Attendanceframe(String number, String User) throws SQLException, IOException {
        JFrame FrameAttendance = new JFrame("Attendance Details");
        FrameAttendance.setLayout(null);
        FrameAttendance.setSize(500, 500);



        String sqlA = "select * from EmpAttendance Order By Eno asc ,DateWork asc";
        Statement Stmt = connect.createStatement();
        ResultSet rs = Stmt.executeQuery(sqlA);


        ResultSetMetaData metadata = rs.getMetaData();
        int numberOfColumns = metadata.getColumnCount();


        String[][] RSArray = new String[10000][numberOfColumns];
        int i = 0, row = 0;

        while (rs.next()) {
            for (int j = 0; j < numberOfColumns; j++) {

                RSArray[i][j] = rs.getString(j + 1);
            }
            RSArray[i][2] = ReverseDateAtt(RSArray[i][2]);
            row++;
            i++;
        }

        final Image backgroundImage = javax.imageio.ImageIO.read(new File("Images/BackGroundDetails.png"));
        FrameAttendance.setContentPane(new JPanel(new BorderLayout()) {
            @Override
            public void paintComponent(Graphics g) {
                g.drawImage(backgroundImage, 0, 0, 1400, 800, null);
            }
        });


        String[] columnNames = {"ENO", "ENAME", "DATE", "Attendance"};

        JTable jt = new JTable(RSArray, columnNames);
        JScrollPane ScrollPane1 = new JScrollPane(jt);
        FrameAttendance.add(ScrollPane1);

        ScrollPane1.setBounds(0, 0, 500, 300);

        JTextField t1 = new JTextField();
        t1.setBounds(250, 350, 100, 20);
        FrameAttendance.add(t1);

        JButton b1 = new JButton("Get Details");
        b1.setBounds(150, 400, 200, 20);
        b1.setIcon(new ImageIcon(((new ImageIcon("Images/SearchIcon.jpg"))
                .getImage()).getScaledInstance(30, 20, java.awt.Image.SCALE_SMOOTH)));
        FrameAttendance.add(b1);


        JLabel l1 = new JLabel("EmpNumber");
        l1.setForeground(Color.WHITE);
        l1.setBounds(150, 350, 100, 20);
        FrameAttendance.add(l1);

         JLabel l2 = new JLabel();
         FrameAttendance.add(l2);

        int finalRow = row;
        final int[] totalDays = {0};
        final int[] daysPresent = {0};
        final float[] percent = new float[1];
        final String[] name = new String[1];

        String[][] DetailArray = new String[100000][numberOfColumns];

        final JFrame[] JFAttendanceDetails = {null};

        if(!User.equals("r")){
             FrameAttendance.setVisible(true);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String no = t1.getText();

                try {
                    if(no != null && EnoValid(no)) {

                        totalDays[0] = 0;
                        daysPresent[0] = 0;
                        for (int i = 0; i < finalRow; i++) {
                            if (RSArray[i][0].equals(no) && RSArray[i][3].equals("1")) {
                                daysPresent[0] += 1;
                            }
                            if (RSArray[i][0].equals(no)) {
                                name[0] = RSArray[i][1];
                                totalDays[0] += 1;
                            }
                        }


                        for (int i = 0; i < finalRow; i++) {
                            for (int j = 0; j < numberOfColumns; j++) {
                                DetailArray[i][j] = null;
                            }
                        }


                        int r = 0;
                        int c = 0;
                        for (int i = 0; i < finalRow; i++) {
                            c = 0;
                            for (int j = 0; j < numberOfColumns; j++) {

                                if (RSArray[i][0].equals(no)) {
                                    DetailArray[r][c] = RSArray[i][j];
                                    c += 1;
                                }
                            }
                            if (RSArray[i][0].equals(no)) {
                                r++;
                            }
                        }




                            if(totalDays[0]==0){
                                totalDays[0]=1;
                                percent[0] = (daysPresent[0] * 100) / totalDays[0];
                                totalDays[0]=0;
                                JFAttendanceDetails[0] = AttendanceDetails(totalDays, daysPresent, percent, no, name, DetailArray, columnNames);
                            }else {
                                percent[0] = (daysPresent[0] * 100) / totalDays[0];
                                JFAttendanceDetails[0] = AttendanceDetails(totalDays, daysPresent, percent, no, name, DetailArray, columnNames);
                            }
                    }else{JOptionPane.showMessageDialog(FrameAttendance,"The entered Employee number is not in the list or null. ");}
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


    }else{
            FrameAttendance.setVisible(false);
            totalDays[0]=0;
            daysPresent[0]=0;
            for( i = 0; i< finalRow; i++) {
                if(RSArray[i][0].equals(number) &&RSArray[i][3].equals("1") ){
                    daysPresent[0] += 1;
                }
                if(RSArray[i][0].equals(number)) {
                    name[0] = RSArray[i][1];
                    totalDays[0] += 1;
                }
            }
            for(i =0 ;i<finalRow;i++){
                for (int j =0;j<numberOfColumns;j++){
                    DetailArray[i][j] = null;
                }
            }

            int r=0;int c=0;
            for( i=0;i<finalRow;i++){
                c=0;
                for(int j =0;j<numberOfColumns;j++){

                    if(RSArray[i][0].equals(number)){
                        DetailArray[r][c]= RSArray[i][j];
                        c+=1;
                    }
                }
                if(RSArray[i][0].equals(number)){ r++;  }
            }
            if(totalDays[0]==0){
                totalDays[0]=1;
                percent[0] = (daysPresent[0] * 100) / totalDays[0];
                totalDays[0]=0;
                JFAttendanceDetails[0] = AttendanceDetails(totalDays, daysPresent, percent, number, name, DetailArray, columnNames);
            }else {
                percent[0] = (daysPresent[0] * 100) / totalDays[0];
                JFAttendanceDetails[0] = AttendanceDetails(totalDays, daysPresent, percent, number, name, DetailArray, columnNames);
            }



        }
        FrameAttendance.setResizable(false);
       return JFAttendanceDetails[0];
    }

    private JFrame AttendanceDetails(int[] totalDays, int[] daysPresent, float[] percent, String Enum, String[] name,String[][] DArray,String[] columnName) throws IOException {
        JFrame JADetails = new JFrame();

        final Image backgroundImage = javax.imageio.ImageIO.read(new File("Images/BackGroundDetails.png"));
        JTable jt = null;
        JADetails.setContentPane(new JPanel(new BorderLayout()) {
            @Override
            public void paintComponent(Graphics g) {
                g.drawImage(backgroundImage, 0, 0, 500, 500, null);
            }
        });

        JLabel l1 = new JLabel("EmpNumber");l1.setForeground(Color.WHITE);
        l1.setBounds(25,300,100,20);
        JADetails.add(l1);
        JLabel l2 = new JLabel("Name");l2.setForeground(Color.WHITE);
        l2.setBounds(25,350,100,20);
        JADetails.add(l2);
        JLabel l3 = new JLabel("TotalDays");l3.setForeground(Color.WHITE);
        l3.setBounds(275,300,100,20);
        JADetails.add(l3);
        JLabel l4 = new JLabel("DaysPresent");l4.setForeground(Color.WHITE);
        l4.setBounds(275,350,100,20);
        JADetails.add(l4);
        JLabel l5 = new JLabel("AttendancePercentage");l5.setForeground(Color.WHITE);
        l5.setBounds(150,400,100,20);
        JADetails.add(l5);

        JLabel l6 = new JLabel();l6.setForeground(Color.WHITE);
        l6.setBounds(125,300,100,20);
        JADetails.add(l6);
        JLabel l7 = new JLabel();l7.setForeground(Color.WHITE);
        l7.setBounds(125,350,100,20);
        JADetails.add(l7);
        JLabel l8 = new JLabel();l8.setForeground(Color.WHITE);
        l8.setBounds(375,300,100,20);
        JADetails.add(l8);
        JLabel l9 = new JLabel();l9.setForeground(Color.WHITE);
        l9.setBounds(375,350,100,20);
        JADetails.add(l9);
        JLabel l10 = new JLabel();l10.setForeground(Color.WHITE);
        l10.setBounds(250,400,100,20);
        JADetails.add(l10);


        l6.setText(Enum);
        l7.setText(name[0]);
        l8.setText(String.valueOf(totalDays[0]));
        l9.setText(String.valueOf(daysPresent[0]));
        l10.setText(String.valueOf(percent[0])+"%");

        JTable jad =  new JTable(DArray,columnName);
        JScrollPane scrollpane2 = new JScrollPane(jad);
        JADetails.add(scrollpane2);
        scrollpane2.setBounds(0,0,500,200);


        JADetails.setLayout(null);
        JADetails.setSize(500,500);
        JADetails.setVisible(true);
        JADetails.setResizable(false);

        return  JADetails;
    }

    public String ReverseDateAtt(String unsplit){

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
        return rev;
    }

    public boolean repetationControl(String Enum,String AttDate) throws SQLException {

        String sqlA = "select * from EmpAttendance";
        Statement Stmt = connect.createStatement();
        ResultSet rs = Stmt.executeQuery(sqlA);

        boolean flag = false;

        ResultSetMetaData metadata = rs.getMetaData();
        int numberOfColumns = metadata.getColumnCount();


        String[][] RSArray = new String[10000][numberOfColumns];
        int i = 0, row = 0;

        while (rs.next()) {
            for (int j = 0; j < numberOfColumns; j++) {

                RSArray[i][j] = rs.getString(j + 1);
            }
            RSArray[i][2] = ReverseDateAtt(RSArray[i][2]);
            row++;
            i++;
        }

        for(int j = 0;j < row;j++) {
            if (RSArray[j][0].equals(Enum) && RSArray[j][2].equals(AttDate)){
                flag = true;

                break;
            }
        }


        return flag;
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
