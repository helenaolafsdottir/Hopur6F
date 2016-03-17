import java.util.ArrayList;

public class SearchMock {
	public ArrayList<Flight> searchMock(){
		ArrayList<Flight> flug = new ArrayList<Flight>(); 
	
		Flight flug1 = new Flight();
	
		flug1.setAirline("Flugfélag Íslands");
		flug1.setArrivalLocation("Akureyri");
		flug1.setArrivalTime("13:00");
		flug1.setDepartureDate("01.06.2016");
		flug1.setDepartureLocation("Reykjavík");
		flug1.setDepartureTime("12:00");
		flug1.setDuration("01:00");
		flug1.setFoodInfo("Epli og Kók");
		flug1.setMaximumLuggageWeight(20);
		flug1.setNumberOfPassengers(27);
		flug1.setTotalPrice(10000);

		flug.add(flug1);
		
		Flight flug2 = new Flight();
		
		flug2.setAirline("Flugfélag Íslands");
		flug2.setArrivalLocation("Reykjavík");
		flug2.setArrivalTime("15:00");
		flug2.setDepartureDate("01.06.2016");
		flug2.setDepartureLocation("Akureyri");
		flug2.setDepartureTime("16:00");
		flug2.setDuration("01:00");
		flug2.setFoodInfo("Epli og Kók");
		flug2.setMaximumLuggageWeight(20);
		flug2.setNumberOfPassengers(24);
		flug2.setTotalPrice(10000);

		flug.add(flug2);
		return flug;
	}
}
