import java.util.Random;

/**
 * Bókunarhlutur
 * @author Arna Björgvinsdóttir, Hannes Jón Ívarsson, Helena Ólafsdóttir, Sandra Gunnarsdóttir
 */
public class Booking {
	
	private Flight departureFlight;
	private Flight arrivalFlight;
	private int totalPrice;
	private String bookingNumber;
	
	public Booking(){	
	}
	
	public void setDepartureFlight (Flight flight){
		this.departureFlight = flight;
	}
	public Flight getDepartureFlight (){
		return this.departureFlight;
	}

	public void setArrivalFlight (Flight flight){
		this.arrivalFlight = flight;
	}
	public Flight getArrivalFlight (){
		return this.arrivalFlight;
	}
	
	public void setTotalPrice(int price){
		this.totalPrice = price;
	}
	public int getTotalPrice(){
		return this.totalPrice;
	}
	
	public void setBookingNumber(){
		Random rnd = new Random();

		 char[] code = new char[5];

		 //Insert random letters

		 for (int i = 0; i < code.length; i++) {
		    char c = (char) (rnd.nextInt( 25 ) + 65);
		    code[i] = c;
		
		}
		String text = new String(code);

		this.bookingNumber = text;
		
	}
	public String getBookingNumber(){
		return this.bookingNumber;
	}


}

