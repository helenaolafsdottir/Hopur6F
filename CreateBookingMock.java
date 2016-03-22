
/**
 * Mock fyrir aðgerðina CreateBooking sem býr til bókun.
 * @author Arna Björgvinsdóttir, Hannes Jón Ívarsson, Helena Ólafsdóttir, Sandra Gunnarsdóttir
 */
public class CreateBookingMock {
	
	/**
	 * Býr til einn flughlut
	 * @return skilar flughlut
	 */
	public Booking createBookingMock(Flight departureFlight, Flight arrivalFlight){
		
		Booking bokadFlug = new Booking(); 
		
		bokadFlug.setDepartureFlight(departureFlight);
		bokadFlug.setArrivalFlight(arrivalFlight);
		
		int price = 20000;
		
		bokadFlug.setBookingNumber();
		bokadFlug.setTotalPrice(price);
		bokadFlug.setBookingNumber();
		
		return bokadFlug;
	}
}
