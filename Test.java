import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Test {
	private final static String createDataBaseQyery = 
			"CREATE DATABASE boockstore CHARACTER SET utf8 COLLATE utf8_general_ci"; 
	public static void main(String[] args)   {
		try {//Downloading drivers
			Class.forName("com.mysql.jdbc.Driver");
			System.out.print("I download driver\n");
			String host = "jdbc:mysql://localhost:3306/new_schema?serverTimezone=UTC";
            String log = "root";
            String pas = "512891";
            try {
            	Connection con = DriverManager.getConnection(host,log,pas);
            	System.out.print("Connected\n");
            	con.close();
            	System.out.print("Disconnection");
            }
            catch(SQLException e) {
            	e.printStackTrace();
            }
            }
            catch(ClassNotFoundException e) {
            	e.printStackTrace();
		}
	}
}
