import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CreateBookingMockTest {

	private CreateBookingMock bokun = new CreateBookingMock();
	private String flugfelagIslands;
	private String departureLoc;
	private String arrivalLoc;
	private String departureDate;
	private String foodInfo;
	
	@Before
	public void setUp(){
		flugfelagIslands = "Flugfélag Íslands";
		departureLoc = "Reykjavík";
		arrivalLoc = "Akureyri";
		departureDate = "01.06.2016";
		foodInfo = "Epli og Kók";	
	}
	
	@After
	public void tearDown(){
		flugfelagIslands = null;
		departureLoc = null;
		arrivalLoc = null;
		departureDate = null;
		foodInfo = null;
	}
	
	@Test
	public void testCreateBooking() {
		ArrayList<Flight> flug = bokun.createBookingMock();
		
		assertEquals(flugfelagIslands,flug.get(0).getAirline());
		assertEquals(departureLoc, flug.get(0).getDepartureLocation());
		assertEquals(arrivalLoc, flug.get(0).getArrivalLocation());
		assertEquals(departureDate, flug.get(0).getDepartureDate());
		assertEquals(foodInfo, flug.get(0).getFoodInfo());
	}

}
