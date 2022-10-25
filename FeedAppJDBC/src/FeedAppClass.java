
import java.sql.*;
public class FeedAppClass {

	private static final String userName = "postgres";
    // If you've changed your password for your database, you will need to change the following line to match your new password: 
   private static final String password = "pg123";
   private static final String dbName = "FeedApplication";
   private static final String port = "5432";
   private static final String dbUrl = "localhost";
 //opening a connection with your database using DriverManager.getConnection() method
   public Connection CreateConnection() {
     Connection conn = null;
     try {
       Class.forName("org.postgresql.Driver");
       conn = DriverManager.getConnection("jdbc:postgresql://localhost/FeedApplication",userName, password);
     } catch (Exception e) {
       System.out.println(e.getClass().getName() + ": " + e.getMessage());
       System.exit(0);
     }
     System.out.println("Opened database successfully");
     return conn;
   }
   //get all details from "UserId" table
   public void GetAllUsers(Connection conn) {
	    try {
	      Statement stmt = null;
	      stmt = conn.createStatement();
	      String sql = "SELECT * FROM \"UserID\"";
	      ResultSet rs = stmt.executeQuery(sql);
	      while (rs.next()) {
	        // Retrieve by column name
	        System.out.print("Name: " + rs.getString("name"));
	        System.out.print("Email ID: " + rs.getString("emailID"));
	        System.out.print("Phone Number: " + rs.getString("phoneNumber"));
	        System.out.print("User password " + rs.getString("userPassword"));
	        System.out.println("Username: " + rs.getString("username"));
	      }
	      stmt.close();
	    } catch (SQLException ex) {
	      //handle exception
	      System.out.println("Exception:" + ex.getMessage());
	    }
	  }
   //inserting a new record into "UserId" table
   
   public void AddUser(Connection conn, String name, String emailID, String phoneNumber,String userPassword,String username) {
	    try {
	      PreparedStatement stmt = null;
	      String sql = "INSERT INTO \"UserID\"(\"name\", \"emailID\", \"phoneNumber\", \"userPassword\",\"username\") VALUES (?, ?, ?, ?,?)";
	      stmt = conn.prepareStatement(sql);
	      stmt.setString(1, name);
	      stmt.setString(2, emailID);
	      stmt.setString(3, phoneNumber);
	      stmt.setString(4, userPassword);
	      stmt.setString(5, username);
	      int resultCount = stmt.executeUpdate();
	      System.out.println(resultCount + " record(s) inserted");
	      stmt.close();
	    } catch (SQLException ex) {
	      //handle exception
	      System.out.println("Exception:" + ex.getMessage());
	    }
	  }
	
   //create a method to close the connection
   public boolean CloseConnection(Connection conn) {
	    boolean flag = true;
	    try {
	      conn.close();
	    } catch (SQLException ex) {
	      flag = false;
	      // Handle exception, in case of any errors:
	      System.out.println("Exception:" + ex.getMessage());
	    }
	    return flag;
	  }
}
