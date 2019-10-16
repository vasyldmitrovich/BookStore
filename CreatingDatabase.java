import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class CreatingDatabase {
	private final static String createDataBaseQyery = 
			"CREATE DATABASE boockstore CHARACTER SET utf8 COLLATE utf8_general_ci";
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/new_schema?serverTimezone=UTC";
            String log = "root";
            String pas = "512891";
            connection = DriverManager.getConnection(url,log,pas);
            statement = connection.createStatement();
            statement.executeUpdate(createDataBaseQyery);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(statement != null) {
				try {
					statement.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
