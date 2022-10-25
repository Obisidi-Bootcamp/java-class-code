
//Your package name goes here

import java.sql.*;
public class StudentAppClass {
  private static final String userName = "postgres";
    // If you've changed your password for your database, you will need to change the following line to match your new password: 
  private static final String password = "pg123";
  private static final String dbName = "Example";
  private static final String port = "5432";
  private static final String dbUrl = "localhost";
//opening a connection with your database using DriverManager.getConnection() method
  public Connection CreateConnection() {
    Connection conn = null;
    try {
      Class.forName("org.postgresql.Driver");
      conn = DriverManager.getConnection("jdbc:postgresql://localhost/Example",userName, password);
    } catch (Exception e) {
      System.out.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
    System.out.println("Opened database successfully");
    return conn;
  }
  //create a statement object to build and submit a SQL query to your database
  //fetch details from database and display the data
  public void GetAllStudents(Connection conn) {
    try {
      Statement stmt = null;
      stmt = conn.createStatement();
      String sql = "SELECT * FROM students";
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        // Retrieve by column name
        System.out.print("Student ID: " + rs.getInt("studentId"));
        System.out.print(", Course ID: " + rs.getInt("courseId"));
        System.out.print(", Student Name: " + rs.getString("studentName"));
        System.out.print(", Student Email: " + rs.getString("studentEmail"));
        System.out.println(", Student Phone: " + rs.getInt("studentPhone"));
      }
      stmt.close();
    } catch (SQLException ex) {
      //handle exception
      System.out.println("Exception:" + ex.getMessage());
    }
  }
    
  public void GetStudentById(Connection conn, Integer studentId) {
    try {
      PreparedStatement stmt = null;
      String sql = "SELECT * FROM students WHERE \"studentId\" = ?";
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, studentId);  //1 specifies the first parameter in the query
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        // Retrieve by column name
        System.out.print("Student ID: " + rs.getInt("studentId"));
        System.out.print(", Course ID: " + rs.getInt("courseId"));
        System.out.print(", Student Name: " + rs.getString("studentName"));
        System.out.print(", Student Email: " + rs.getString("studentEmail"));
        System.out.println(", Student Phone: " + rs.getInt("studentPhone"));
      }
      stmt.close();
    } catch (SQLException ex) {
      //Handle exceptions, in case of any errors:
      System.out.println("Exception:" + ex.getMessage());
    }
  }
   //inserting a value into your database 
  public void AddStudent(Connection conn, int courseId, String studentName, String studentEmail, int studentPhone) {
    try {
      PreparedStatement stmt = null;
      String sql = "INSERT INTO students (\"courseId\", \"studentName\", \"studentEmail\", \"studentPhone\") VALUES (?, ?, ?, ?)";
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, courseId);
      stmt.setString(2, studentName);
      stmt.setString(3, studentEmail);
      stmt.setInt(4, studentPhone);
      int resultCount = stmt.executeUpdate();
      System.out.println(resultCount + " record(s) inserted");
      stmt.close();
    } catch (SQLException ex) {
      //handle exception
      System.out.println("Exception:" + ex.getMessage());
    }
  }
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