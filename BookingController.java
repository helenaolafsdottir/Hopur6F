import java.util.ArrayList;
import java.sql.*;

/**
 * Klasi sem útfærir aðgerðir sem bóka flug og uppfæra gagnagrunninn í samræmi við það.
 * @author Arna Björgvinsdóttir, Hannes Jón Ívarsson, Helena Ólafsdóttir, Sandra Gunnarsdóttir
 */
public class BookingController {
	
	Connection c;
	
	/**
	 * Fækkar fjölda lausra sæta í hverju flugi um þann fjölda sæta sem verið er að bóka.
	 * @param numberOfPassengers Sá fjöldi sæta sem verið er að bóka
	 * @param ticketsAvailable Fjöldi lausra sæta í vélinni fyrir bókun
	 * @param id auðkenni flugsins
	 */
	public void reduceNumberOfSeats(int numberOfPassengers, int ticketsAvailable, int id){
		
		//Reiknum út þann fjölda sæta sem eftir verða þegar búið er að bóka.
		int finalTicketsAvailable = ticketsAvailable - numberOfPassengers;

		try {
			c = DriverManager.getConnection("jdbc:sqlite:Verkefni6Flug.db");
			c.setAutoCommit(false);
		
			//Finnum viðeigandi flug í gagnagrunninum uppfærum fjölda lausra sæta.
			String update = "UPDATE Flights SET TicketsAvailable = ? WHERE ID = ?";
			PreparedStatement prepState = c.prepareStatement(update);
		
			prepState.setInt(1, finalTicketsAvailable);
			prepState.setInt(2, id);
			
			//Uppfærum gagnagrunninn.
			prepState.executeUpdate();
			c.commit();
			prepState.close();
			c.close();
		}catch(Exception evt){
			System.err.println( evt.getClass().getName() + ": " + evt.getMessage() );
			System.exit(0);
		}
	}
	
	/**
	 * Býr til bókun
	 * @param departureFlight Brottfararflug sem bóka skal
	 * @param arrivalFlight Heimkomuflug sem bóka skal
	 * @return Það flug sem var bókað.
	 */
	public Booking createBooking(Flight departureFlight, Flight arrivalFlight){
		Booking bokudFlug = new Booking(); 

		int depPrice = 0;
		int arrPrice = 0;
		int totalBookingPrice = 0;
		
		//Ef bóka skal brottfararflug
		if(departureFlight != null){
			bokudFlug.setDepartureFlight(departureFlight);
			depPrice = departureFlight.getTotalPrice();
		}
		System.out.println(departureFlight);
		//System.out.println(arrivalFlight);
		
		//Ef bóka skal heimkomuflug
		if(arrivalFlight != null){
			bokudFlug.setArrivalFlight(arrivalFlight);
			depPrice = arrivalFlight.getTotalPrice();
		}
		totalBookingPrice = depPrice + arrPrice;
		
		System.out.println(bokudFlug);
		return bokudFlug;
		
	}
}
