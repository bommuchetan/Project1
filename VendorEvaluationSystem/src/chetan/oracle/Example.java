package chetan.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Example 
{
	Connection c=null;
	static Statement s=null;
	public Example() 
	{
		try 
		{
			Class.forName("org.postgresql.Driver").newInstance();
			c= DriverManager.getConnection("jdbc:postgresql://localhost:5432/vendordb","postgres", "database");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			if(c==null) System.out.println("null!!");
		} 
		catch (Exception e) 
		{
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
	        
		}
		
	}
	/*public static void main(String[] args) 
	{
		Example e=new Example();
		e.insertData(20,"kaif","kaif@oracle.com");
	}*/
	public void insertVendorData(String name,String email)
	{
		try 
		{
			s= c.createStatement();
			String data="INSERT INTO VENDOR(vendor_name,vendor_email)"+ "VALUES ("+"'"+name+"','"+email+"');";
			s.executeUpdate(data);
			s.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	public void insertEvalSystemData(int completenessRating,String safetyRating,String costEffectiveNess,
									String recommendRating,int rating,String comments) 
	{
		try 
		{
			s= c.createStatement();
			String data="INSERT INTO evalsystem(cr,sr,ce,recommend,rating,comments,date)"+ "VALUES ("
					+ completenessRating+",'"+safetyRating+"','"+costEffectiveNess+"','"+recommendRating+"',"+
					rating+",'"+comments+"',CURRENT_TIMESTAMP);";
			s.executeUpdate(data);
			s.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
