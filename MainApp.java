import java.sql.*;
public class MainApp 
 {
	public static Connection getOurConnection()
	{
		Connection con=null;
		try
		{
			//1.load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. establish the connection
			 con=DriverManager.getConnection("jdbc:mysql://localhost/novdb"
					,"root","7893798353");
		}
		catch(ClassNotFoundException ce)
		{
			System.out.println("Driver class not found");
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
		return con;
	}
public static void addEmployee()
    {
	try
	{
		
		/*no need to write the below code again because ,new method is created for 
		 * connection class ...so we can call it by getOurConnection method
		 * 
		 * 1.load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2. establish the connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/novdb"
				,"root","7893798353"); */
		
		
		//3. create statement object 
	// 	String str="insert into emp values(1212,'martin',5000)";
		
		Connection con=getOurConnection();
		Statement st=con.createStatement();
		  
		
		
		//4.execute the sql command via statement object
		String str="insert into emp values(1414,'jack',7000)";
		st.executeUpdate(str);
		
		
		
	// instead of writing the above 2 lines code write below 1 line code
		//but during the update of code it will be difficult
	//	st.executeUpdate("insert into emp values(1212,'martin',5000)");
		
		
		System.out.println("success");
		
	}
	
	catch(SQLException se)
	{
		System.out.println(se);
	}

	}  // end of addEmployee


public static void updateEmployee()
    {
	try
	{
		Connection con=getOurConnection();
		//3. create statement object 
	// 	String str="insert into emp values(1212,'martin',5000)";
		Statement st=con.createStatement();
		  
		
		
		//4.execute the sql command via statement object
		String str="update emp set empname='john',salary=8000 where empid=1313";
		st.executeUpdate(str);
		
		
		
	
		
		System.out.println("update success");
		
	}  //end of updateEmployee
	
	catch(SQLException se)
	{
		System.out.println(se);
	}

	} 
public static void deleteEmployee() throws SQLException
{
	Connection con=getOurConnection();
	Statement st=con.createStatement();
	String str=" delete from emp where empid=1414";
	st.executeUpdate(str);
	System.out.println("delete success");
	
}
public static void showEmployees()
{
try
{
	//used for getting connection between java and mysql(dbms)
	
	Connection con=getOurConnection();
	//3. create statement object 
	Statement st=con.createStatement();
	  
	
	
	//4.execute the sql command via statement object
	String str="select * from emp";
	st.executeQuery(str);
		ResultSet rs=st.executeQuery(str);
	System.out.println("Showing employee records");
	while(rs.next())
	{
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+
	                             rs.getDouble(3));
	}
	con.close();
	
}  //end of showEmployee

catch(SQLException se)
{
	System.out.println(se);
}

} 


	public static void main(String[] args) throws SQLException 
	 {
	//addEmployee();
	//updateEmployee();
	//deleteEmployee();
	showEmployees();
	}

}
