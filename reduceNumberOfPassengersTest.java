import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.sql.*;


public class reduceNumberOfPassengersTest {
	
	Connection c;
	private BookingController bokun = new BookingController();
	static int ticketsAvailable;
	static int ticketsAvailableAfter;
	
	@Before
	public void setUp(){
		try{
			c = DriverManager.getConnection("jdbc:sqlite:Verkefni6Flug.db");

			String select = "SELECT * FROM Flights WHERE ID = ?";
			
			PreparedStatement prepState = c.prepareStatement(select);

			prepState.setInt(1, 1);

			ResultSet resultSet = prepState.executeQuery();
			
			ticketsAvailable = resultSet.getInt("TicketsAvailable");
			
			prepState.close();
			c.close();
			
		}catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
		}
		
	}
	
	@After
	public void tearDown(){
		
	}
	
	@Test
	public void testReduceNumberOfSeats() {
		try{
			bokun.reduceNumberOfSeats(1,ticketsAvailable,1);
		
			c = DriverManager.getConnection("jdbc:sqlite:Verkefni6Flug.db");
			
			String select = "SELECT * FROM Flights WHERE ID = ?";
			
			PreparedStatement prepState = c.prepareStatement(select);
			
			prepState.setInt(1, 1);
			
			ResultSet resultSet = prepState.executeQuery();
			
			ticketsAvailableAfter = resultSet.getInt("TicketsAvailable");
			
		
			prepState.close();
			c.close();
		}catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
		}
		
		assertEquals(ticketsAvailable - 1, ticketsAvailableAfter);
		
	}


}
