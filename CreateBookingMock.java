import java.util.ArrayList;

public class CreateBookingMock {
	
	public ArrayList<Flight> createBookingMock(){
		ArrayList<Flight> bokadFlug = new ArrayList<Flight>(); 
	
		Flight depFlight = new Flight();
	
		depFlight.setAirline("Flugfélag Íslands");
		depFlight.setArrivalLocation("Akureyri");
		depFlight.setArrivalTime("13:00");
		depFlight.setDepartureDate("01.06.2016");
		depFlight.setDepartureLocation("Reykjavík");
		depFlight.setDepartureTime("12:00");
		depFlight.setDuration("01:00");
		depFlight.setFoodInfo("Epli og Kók");
		depFlight.setMaximumLuggageWeight(20);
		depFlight.setNumberOfPassengers(27);
		depFlight.setTotalPrice(10000);

		bokadFlug.add(depFlight);
		return bokadFlug;
	}
}
