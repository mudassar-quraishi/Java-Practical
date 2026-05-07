package jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClobBlob {
    public static void main(String[] args) {
        String jdbc_driver = "com.mysql.cj.jdbc.Driver";
        String host = "jdbc:mysql://localhost:3307/student";
        String username = "root";
        String password = "";
        String insertQuery = """
                insert into studentInfo(name, photo, resume) values(?, ?, ?);
                """;
        File resume = new File("jdbc/demo.txt");
        File photo = new File("jdbc/photo.jpeg");
        // try {
        //     //Data insertion in database
        //     FileReader frResume = new FileReader(resume);
        //     FileInputStream fisphoto = new FileInputStream(photo);
        //     Class.forName(jdbc_driver);
        //     Connection con = DriverManager.getConnection(host, username, password);
        //     PreparedStatement pst = con.prepareStatement(insertQuery);
        //     pst.setString(1, "Student1");
        //     pst.setBinaryStream(2, fisphoto, (int) photo.length());
        //     pst.setCharacterStream(3, frResume, (int) resume.length());
        //     pst.executeUpdate();
        //     System.out.println("Resume Inserted");

        // } catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
        //     e.printStackTrace();
        // }

        try {
            //Data retrieval in database
            FileReader frResume = new FileReader(resume);
            FileInputStream fisphoto = new FileInputStream(photo);
            Class.forName(jdbc_driver);
            Connection con = DriverManager.getConnection(host, username, password);
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery("Select * from studentInfo");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                InputStream is = rs.getBinaryStream("photo");
                FileOutputStream fos = new FileOutputStream("photo.jpeg");
                byte[] buff = new byte[1024];
                int len=0;
                while((len=is.read(buff))!=-1){
                    fos.write(buff, 0, len);
                }
                fos.close();
                Reader rd = rs.getCharacterStream("resume");
                BufferedReader br = new BufferedReader(rd);
                System.out.println("ID= " + id + ", Name= " + name);
                String line=null;
                while((line=br.readLine())!=null){
                    System.out.println(line);
                }
            }

        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }


    }

}
