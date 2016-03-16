import java.util.ArrayList;
import java.sql.*;

public class BookingController {
	
	Connection c;
	
	public void reduceNumberOfSeats(int numberOfPassengers, int ticketsAvailable, int id){
		int finalTicketsAvailable = ticketsAvailable - numberOfPassengers;
		System.out.println(finalTicketsAvailable);
		try {
			c = DriverManager.getConnection("jdbc:sqlite:Verkefni6Flug.d"
					+ "b");
			c.setAutoCommit(false);
		
			String update = "UPDATE Flights SET TicketsAvailable = ? WHERE ID = ?";
			PreparedStatement prepState = c.prepareStatement(update);
		
			prepState.setInt(1, finalTicketsAvailable);
			prepState.setInt(2, id);
			
			prepState.executeUpdate();
			c.commit();
			prepState.close();
			c.close();
		}catch(Exception evt){
			System.err.println( evt.getClass().getName() + ": " + evt.getMessage() );
			System.exit(0);
		}
	}
	
	public ArrayList<Flight> createBooking(Flight departureFlight, Flight arrivalFlight){
		ArrayList<Flight> bokudFlug = new ArrayList<Flight>(); 
		
		Flight depFlight = new Flight();
		depFlight.setAirline(departureFlight.getAirline());
		depFlight.setArrivalLocation(departureFlight.getArrivalLocation());
		depFlight.setArrivalTime(departureFlight.getArrivalTime());
		depFlight.setDepartureDate(departureFlight.getDepartureDate());
		depFlight.setDepartureLocation(departureFlight.getDepartureLocation());
		depFlight.setDepartureTime(departureFlight.getDepartureTime());
		depFlight.setDuration(departureFlight.getDuration());
		depFlight.setFoodInfo(departureFlight.getFoodInfo());
		depFlight.setMaximumLuggageWeight(departureFlight.getMaximumLuggageWeight());
		depFlight.setNumberOfPassengers(departureFlight.getNumberOfPassengers());
		depFlight.setTotalPrice(departureFlight.getTotalPrice());
		
		bokudFlug.add(depFlight);
		
		System.out.println(arrivalFlight);
		
		if(!(arrivalFlight == null)){
			Flight arrFlight = new Flight();
			arrFlight.setAirline(arrivalFlight.getAirline());
			arrFlight.setArrivalLocation(arrivalFlight.getArrivalLocation());
			arrFlight.setArrivalTime(arrivalFlight.getArrivalTime());
			arrFlight.setDepartureDate(arrivalFlight.getDepartureDate());
			arrFlight.setDepartureLocation(arrivalFlight.getDepartureLocation());
			arrFlight.setDepartureTime(arrivalFlight.getDepartureTime());
			arrFlight.setDuration(arrivalFlight.getDuration());
			arrFlight.setFoodInfo(arrivalFlight.getFoodInfo());
			arrFlight.setMaximumLuggageWeight(arrivalFlight.getMaximumLuggageWeight());
			arrFlight.setNumberOfPassengers(arrivalFlight.getNumberOfPassengers());
			arrFlight.setTotalPrice(arrivalFlight.getTotalPrice());
			
			
			bokudFlug.add(arrFlight);
		}
		
		System.out.println(bokudFlug);
		return bokudFlug;
		
	}
}
