import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test fyrir CreateBookingMock
 * @author Arna Björgvinsdóttir, Hannes Jón Ívarsson, Helena Ólafsdóttir, Sandra Gunnarsdóttir
 */
public class CreateBookingMockTest {

	private CreateBookingMock bokun = new CreateBookingMock();
	private String flugfelagIslands = "Flugfélag Íslands";
	private String departureLoc = "Reykjavík";
	private String arrivalLoc = "Akureyri";
	private String departureDate = "01.06.2016";
	private String foodInfo = "Epli og Kók";
	private int totPrice = 20000;
	Flight depFlight = new Flight();
	Flight arrFlight = new Flight();
	
	@Before
	public void setUp(){

		depFlight.setAirline(flugfelagIslands);
		depFlight.setDepartureLocation(departureLoc);
		depFlight.setArrivalLocation(arrivalLoc);
		depFlight.setDepartureDate(departureDate);
		depFlight.setFoodInfo(foodInfo);

		arrFlight.setAirline(flugfelagIslands);
		arrFlight.setDepartureLocation(departureLoc);
		arrFlight.setArrivalLocation(arrivalLoc);
		arrFlight.setDepartureDate(departureDate);
		arrFlight.setFoodInfo(foodInfo);
	}
	
	@After
	public void tearDown(){
		depFlight = null;
		arrFlight = null;

	}
	
	/**
	 * Athugar hvort get aðferðirnar sæki rétt gildi fyrir flughlut.
	 */
	@Test
	public void testCreateBooking() {
		
		Booking booking = bokun.createBookingMock(depFlight, arrFlight);
		
		assertEquals(flugfelagIslands, booking.getArrivalFlight().getAirline());
		assertEquals(departureLoc, booking.getArrivalFlight().getDepartureLocation());
		assertEquals(arrivalLoc, booking.getArrivalFlight().getArrivalLocation());
		assertEquals(departureDate, booking.getDepartureFlight().getDepartureDate());
		assertEquals(foodInfo, booking.getDepartureFlight().getFoodInfo());
		assertEquals(totPrice, booking.getTotalPrice());
		
		//Athugum hvort að bókunarnúmerið sé af réttri lengd (5 bókstafir)
		String bookingNr = booking.getBookingNumber();
		int bookingNrLength = bookingNr.length();
		assertEquals(5, bookingNrLength);
	}

}
