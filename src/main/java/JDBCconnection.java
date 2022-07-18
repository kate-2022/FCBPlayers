import java.sql.*;
//Java Database Connectivity

/*
* 1. import --> java.sql.*;
* 2. load and register the driver --> com.mysql.jdbc.Driver
* 3. create connection
* 4. create a statement
* 5. execute the query
* 6. process the results
* 7. close
*/

//DAO = data access object

public class JDBCconnection {

	public static void main(String[] args) throws Exception{
		
		String url = "jdbc:mysql://localhost:3306/fcbayernplayers";
		String uname  = "root";
		String pass = "1234";
		
	//	String query = "select * from players";
	//	String query = "insert into players values ('Goretzka', 'Leon', 8)";
		int shirtNumber = 11;
		String lastName = "Coman";
		String firstName = "Kingsley";
	//  String query = "insert into players values (" + "'" + lastName + "',"+ "'" + firstName + "'," + shirtNumber +  " )";
		String query = "insert into players values (?,?,?)";
		
		Class.forName("com.mysql.cj.jdbc.Driver");                        // in detail: @ youtube "class forname" telusko
		Connection con = DriverManager.getConnection(url, uname,pass);
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1,lastName);
		st.setString(2,firstName);
		st.setInt(3,shirtNumber);
		
    //  Statement st = con.createStatement();   // use PreparedStatement instead!
	//	ResultSet rs = st.executeQuery(query);  // DDL= data definition language: e.g. creating table, changing structure of db), 
		                                        // DML= data modifying language: changing/deleting/updating a value/row of a table, inserting a new value
		                                        // DQL= data query language: fetch data from data base (executeQuery(query) 
		
		
		int count = st.executeUpdate();    // count = number of rows that are effected                                     
		
		System.out.println(count + " row/s affected");
		
	/*	String userData ="";
		
		while(rs.next()) {                                               // rs.next() is responsible to take the cursor to the next element (next row)!
	//	String name = rs.getString("shirtNumber");                                // and rs.next() gives back a boolean value for if there is a next row or not
		userData = rs.getString(1) + ", " + rs.getString(2)+ " : " + rs.getInt(3); 
		System.out.println(userData);
		}*/
		
		st.close();
		con.close();
	}

}
