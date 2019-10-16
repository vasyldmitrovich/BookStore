import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class BookStore {
	private Connection connection;
	public BookStore() {
		String url = "jdbc:mysql://localhost:3306/boockstore?characterEncoding=utf8&serverTimezone=UTC";
		String user = "root";
		String password = "512891";
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Ми підключились до бази");
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM boockstore.books";
			ResultSet resultset = statement.executeQuery(query);
			printResults(resultset);
			System.out.println("Ми відключаємось від бази");
			connection.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	private void printResults(ResultSet resultset) throws SQLException {
		String author, title, comment;
		double price;
		while(resultset.next()) {
			author = resultset.getString("author");
			title = resultset.getString("title");
			comment = resultset.getString("comment");
			price = resultset.getDouble("price");
			System.out.println("******************************");
			System.out.println("Author: " + author);
			System.out.println("Title: " + title);
			System.out.println("Price: " + price);
			System.out.println("comment: " + comment);
			System.out.println("******************************");
		}
		
	}
	public static void main(String[]args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loading success!");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		BookStore bookstore = new BookStore();
	}

}
