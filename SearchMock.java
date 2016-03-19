import java.util.ArrayList;

/**
 * Mock fyrir aðgerðina Search sem finnur flug sem uppfylla skilyrði.
 * @author Arna Björgvinsdóttir, Hannes Jón Ívarsson, Helena Ólafsdóttir, Sandra Gunnarsdóttir
 */
public class SearchMock {
	
	//Lögleg dagsetning
	private String dagsetning = "01.06.2016";
	
	/**
	 * searchMock skilgreinir tvö flug ef date er lögleg dagsetning.
	 */
	public ArrayList<Flight> searchMock(String date, int numberOfPassengers, String departureLocation, String arrivalLocation){
		ArrayList<Flight> flug = new ArrayList<Flight>(); 
	
		Flight flug1 = new Flight();
		
		if(date == dagsetning){

			flug1.setAirline("Flugfélag Íslands");
			flug1.setArrivalLocation("Akureyri");
			flug1.setArrivalTime("13:00");
			flug1.setDepartureDate(date);
			flug1.setDepartureLocation("Reykjavík");
			flug1.setDepartureTime("12:00");
			flug1.setDuration("01:00");
			flug1.setFoodInfo("Epli og Kók");
			flug1.setMaximumLuggageWeight(20);
			flug1.setNumberOfPassengers(27);
			flug1.setTotalPrice(10000);
			
			//Viljum bara bæta við þeim flugum sem uppfylla kröfur notanda
			if(flug1.getDepartureLocation() == departureLocation && flug1.getArrivalLocation() == arrivalLocation && flug1.getNumberOfPassengers() >= numberOfPassengers){
				flug.add(flug1);
			}
			
			Flight flug2 = new Flight();
			
			flug2.setAirline("Flugfélag Íslands");
			flug2.setArrivalLocation("Akureyri");
			flug2.setArrivalTime("15:00");
			flug2.setDepartureDate(date);
			flug2.setDepartureLocation("Reykjavík");
			flug2.setDepartureTime("16:00");
			flug2.setDuration("01:00");
			flug2.setFoodInfo("Epli og Kók");
			flug2.setMaximumLuggageWeight(20);
			flug2.setNumberOfPassengers(24);
			flug2.setTotalPrice(10000);
			
			//Viljum bara bæta við þeim flugum sem uppfylla kröfur notanda
			if(flug2.getDepartureLocation() == departureLocation && flug2.getArrivalLocation() == arrivalLocation && flug2.getNumberOfPassengers() >= numberOfPassengers){
				flug.add(flug2);
			}
		}
		//Villumeðhöndlun ef date er ólögleg dagsetning
		else {
			throw new IllegalArgumentException();
		}
		return flug;
	}
	
}
