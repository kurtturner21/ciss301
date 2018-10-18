import java.sql.*;

// Help editing this code
// https://www.tutorialspoint.com/sqlite/sqlite_java.htm
// https://sqlite.org/download.html
// https://bitbucket.org/xerial/sqlite-jdbc/downloads/

// Example CSV:
// https://quantquote.com/historical-stock-data

public class UsersDB {
	Connection c = null;
	
	// override method to create the class, connect to the database and 
	// create the tables needed
	public UsersDB(){
		connectDB();
		createTable();
	}
	
	// main class which creates the UserDB object
	public static void main( String args[] ) {
		new UsersDB();
	}
   
	// connecting to the data base file 
	private void connectDB(){
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:Users.db");
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	}
   
	// This methis creates the people table if does not exist. 
	private void createTable(){
		Statement stmt = null;
		try {
			stmt = c.createStatement();
			String sql = "create table if not exists people \n" +
				"(id integer primary key autoincrement, \n" +
				" name           text    not null, \n" + 
				" age            int     not null, \n" + 
				" address        char(50), \n" + 
				" city        	 char(50), \n" + 
				" state        	 char(50), \n" + 
				" zip        	 char(15), \n" + 
				" salary         real \n)"; 
			stmt.executeUpdate(sql);
			stmt.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}	
	}

	// Adds data to the people table
	public void addDataToPeopleTable(String Name, int Age, String Address, String City, 
		String State, String Zip, Double Salery){
		Statement stmt = null;
		try {
			stmt = c.createStatement();
			String sql = "insert into people (name, age, address, city, state, zip, salary) " +
						"values ('" + Name + "'," + Age + ", '" + Address + "', '" + City + 
						"', '" + State + "', '" + Zip + "', " + Salery + ");"; 
			stmt.executeUpdate(sql);
			stmt.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	}

}