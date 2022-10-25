import java.sql.Connection;

public class Main {

	
 public static void main(String[] args) {
			    	
	 
	 StudentAppClass jdbc = new StudentAppClass();
	 Connection conn = jdbc.CreateConnection();
	 
	// jdbc.GetAllStudents(conn);
	 
	// jdbc.GetStudentById(conn, 12);
	 
	 jdbc.AddStudent(conn, 1, "Alice", "Alice@bptn.com", 123494);
	 
	 jdbc.CloseConnection(conn);
			    }
		}
		
	


