

import java.sql.*;
import javax.swing.JFrame;


public class DBConnection extends JFrame {
public Connection c;
Statement s;
ResultSet rs;
static DBConnection db;

public DBConnection(){
	 try {
		Class.forName("com.mysql.jdbc.Driver");
		
		try {
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/mits_minor","root","");
			s=c.createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
public void dbBanaya(){
	db =new DBConnection();
}
public boolean login(String username,String password ){

	String q= "SELECT * FROM admin WHERE username='"+username+"' AND password='"+password+"'";
	System.out.print(q);
	String id = "";
	try {
		rs=s.executeQuery(q);
		System.out.println("DATA: \n");
		
		while(rs.next()){
			//id +=rs.getString("u_id");
			//id+="\n";
			//String name=rs.getString("u_fname");
			//System.out.println(id);
			return true;
			
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
	
}


}
