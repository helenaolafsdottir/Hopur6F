import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test á SearchMock
 * @author Arna Björgvinsdóttir, Hannes Jón Ívarsson, Helena Ólafsdóttir, Sandra Gunnarsdóttir
 */
public class SearchMockTest {

	private SearchMock mySearch = new SearchMock();
	private String flugfelagIslands;
	private String departureLoc1;
	private String arrivalLoc1;
	private String departureDate1;
	private String foodInfo1;
	private String departureLoc2;
	private String arrivalLoc2;
	private String departureDate2;
	private String foodInfo2;
	
	private String dateForException;
	
	@Before
	public void setUp(){
		flugfelagIslands = "Flugfélag Íslands";
		departureLoc1 = "Reykjavík";
		arrivalLoc1 = "Akureyri";
		departureDate1 = "01.06.2016";
		foodInfo1 = "Epli og Kók";	
		departureLoc2 = "Akureyri";
		arrivalLoc2 = "Reykjavík";
		departureDate2 = "01.06.2016";
		foodInfo2 = "Epli og Kók";	
		dateForException = "01/06/2016";
	}
	
	@After
	public void tearDown(){
		flugfelagIslands = null;
		departureLoc1 = null;
		arrivalLoc1 = null;
		departureDate1 = null;
		foodInfo1 = null;	
		departureLoc2 = null;
		arrivalLoc2 = null;
		departureDate2 = null;
		foodInfo2 = null;	
		dateForException = null;
	}
	
	/**
	 * Athugum hvort að searchMock sækji rétt gildi fyrir flughlut.
	 */
	@Test
	public void testSearchMock() {
		ArrayList<Flight> flug = mySearch.searchMock(departureDate1);
		
		assertEquals(flugfelagIslands,flug.get(0).getAirline());
		assertEquals(departureLoc1, flug.get(0).getDepartureLocation());
		assertEquals(arrivalLoc1, flug.get(0).getArrivalLocation());
		assertEquals(departureDate1, flug.get(0).getDepartureDate());
		assertEquals(foodInfo1, flug.get(0).getFoodInfo());
		assertEquals(flugfelagIslands,flug.get(1).getAirline());
		assertEquals(departureLoc2, flug.get(1).getDepartureLocation());
		assertEquals(arrivalLoc2, flug.get(1).getArrivalLocation());
		assertEquals(departureDate2, flug.get(1).getDepartureDate());
		assertEquals(foodInfo2, flug.get(1).getFoodInfo());
	}
	
	/**
	 * Erum bara með tvö flug í SearchMock.java, athugum hvort 
	 * það komi rétt exception
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void testTooManyFlights(){
		ArrayList<Flight> flug = mySearch.searchMock(departureDate1);
		Flight flug11 = flug.get(10);
	}
	
	/**
	 * Setjum inn dagsetningu sem er á vitlausu formi.
	 * Athugum hvort það komi rétt exception.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalDate(){
		ArrayList<Flight> flug = mySearch.searchMock(dateForException);
	}

}
