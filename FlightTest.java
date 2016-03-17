import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FlightTest {

	Flight flug = new Flight();
	private String arrTime;
	private String dur;
	private int maxLuggage;
	private int tickets;
	private int numberOfPass;
	private int totPrice;
	
	@Before
	public void setUp(){
		
		arrTime = "13:00";
		dur = "01:00";
		maxLuggage = 20;
		tickets = 30;
		numberOfPass = 1;
		totPrice = 10000;
				
		flug.setArrivalTime(arrTime);
		flug.setDuration(dur);
		flug.setMaximumLuggageWeight(maxLuggage);
		flug.setTicketsAvailable(tickets);		
		flug.setNumberOfPassengers(numberOfPass);
		flug.setTotalPrice(totPrice);
	}
	
	@After
	public void tearDown(){
		arrTime = null;
		dur = null;
		maxLuggage = 0;
		tickets = 0;
		numberOfPass = 0;
		totPrice = 0;
	}
	
	@Test
	public void testGetNumberOfPassengers() {
		assertEquals(numberOfPass, flug.getNumberOfPassengers());
	}

	@Test
	public void testGetTotalPrice() {
		assertEquals(totPrice, flug.getTotalPrice());
	}

	@Test
	public void testGetArrivalTime() {
		assertEquals(arrTime, flug.getArrivalTime());
	}

	@Test
	public void testGetDuration() {
		assertEquals(dur, flug.getDuration());
	}

	@Test
	public void testGetMaximumLuggageWeight() {
		assertEquals(maxLuggage, flug.getMaximumLuggageWeight());
	}

	@Test
	public void testGetTicketsAvailable() {
		assertEquals(tickets, flug.getTicketsAvailable());
	}

}
