package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class SavePointEx {
    public static void main(String[] args) {
        String jdbc_driver = "com.mysql.cj.jdbc.Driver";
        String host = "jdbc:mysql://localhost:3307/student";
        String username = "root";
        String password = "";
        Connection con = null;
        Savepoint sp1= null, sp2=null;
        try {
            Class.forName(jdbc_driver);
            con = DriverManager.getConnection(host, username, password);
            Statement smt = con.createStatement();
            con.setAutoCommit(false);
            smt.executeUpdate("""
                    insert into student(name,course,marks) values
                    ('Student3','B.Tech(CS)',80)
                    """);
            sp1 = con.setSavepoint("Insert");
            smt.executeUpdate("""
                    update student set course="MCA" where name="Student3"
                    """);
            sp2 = con.setSavepoint("Update");
            smt.executeUpdate("""
                    delete from student where name="Student3"
                    """);  
            con.commit();          
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            try{
                con.rollback(sp2);
            }catch(SQLException e1){
                e1.printStackTrace();
            }
        }finally{
            try{
                con.commit();
                con.setAutoCommit(true);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

}
