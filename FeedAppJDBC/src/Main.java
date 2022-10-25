import java.sql.Connection;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 FeedAppClass jdbc = new FeedAppClass();
		 Connection conn = jdbc.CreateConnection();
		 
		 jdbc.GetAllUsers(conn);
		// jdbc.AddUser(conn, "JOHN DOE9", "JOHNdOE9@GMAIL.COM", "2919283759", "@@@@345", "jDoe3285");
		 
		 
		 jdbc.CloseConnection(conn);

	}

}
