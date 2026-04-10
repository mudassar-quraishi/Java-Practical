package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentPre {

	public static void main(String[] args) {
		String jdbc_driver="com.mysql.cj.jdbc.Driver";
		String host="jdbc:mysql://localhost:3307/student";
		String username="root";
		String password="";
		String query="select * from student where course=?";
        String insert = "insert into student (name, course, marks) values(?, ?, ?)";
        String update = "update student set marks=? where course =?";
		
		try {
			Class.forName(jdbc_driver);
			Connection con =DriverManager.getConnection(host,username,password);
            //insert query
		    PreparedStatement inputPst=con.prepareStatement(insert);
            inputPst.setString(1, "Mohan");
            inputPst.setString(2, "Btech");
            inputPst.setLong(3, 85);
            inputPst.executeUpdate();
            //Update query
            PreparedStatement updatePst = con.prepareStatement(update);
            updatePst.setLong(1, 95);
            updatePst.setString(2, "MCA");
            updatePst.executeUpdate();
            //Data reterival
		    PreparedStatement pst=con.prepareStatement(query);
		    pst.setString(1, "MCA");
		    ResultSet rs= pst.executeQuery();
			System.out.println("ID\tName\t\tCourse\t\tMarks");
		    while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String course=rs.getString("course");
				long marks=rs.getLong("marks");
				System.out.println(
						String.format("%d\t%s\t%s\t\t%d", id,name,course,marks)
						);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}