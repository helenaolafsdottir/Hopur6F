import java.sql.*;//adds everything related to sql
import javax.swing.*;
public class SqliteConnection {
	
	Connection conn=null;
	public static Connection dbConnector()
	{
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\helen_000\\Documents\\Helena\\HÍ\\2. ár vor\\Þróun Hugbúnaðar\\FlightData.sqlite");
			System.out.println("working!");
			return conn;
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			System.out.println("doesnt work");
			return null;
		}
	}
}
