package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueary_SampleCode {

	public static void main(String[] args) throws SQLException {
		 Connection conn = null;
		Driver driverref = new Driver();
		/* step 1 : load / register *mysql* the data base*/
		DriverManager.registerDriver(driverref);
		 /* step 2 : connect to data base*/
		  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects ", "root","root");
		 System.out.println("connection is done");
		/* step 3: create queary statment*/
		Statement stat = conn.createStatement();
		String queary = "select * from project";
		
		/*step 4: executive the queary*/
		 ResultSet resultset = stat.executeQuery(queary);
		 while(resultset.next())
		 {
			 System.out.println(resultset.getString(1)+"\t"+resultset.getString(2));
		 }
		 /* step 5: close the database*/
	conn.close();
	}

}
