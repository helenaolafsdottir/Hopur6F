import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Search{
	Connection c;
	
	private ArrayList<Flight> flights;
		
	public ArrayList<Flight> gettingCorrectSearchResults(String departureLocation, String arrivalLocation, int numberOfPassengers, Date date){
		try {
			c = DriverManager.getConnection("jdbc:sqlite:Verkefni6F.db");
			
			String selectStatement = "SELECT * FROM Flights WHERE DepartureDate = ? AND DepartureLocation = ? AND arrivalLocation = ? AND TicketsAvailable >= ? ";
			String countSelectStatement = "SELECT COUNT(*) FROM Flights WHERE DepartureDate = ? AND DepartureLocation = ? AND arrivalLocation = ? AND TicketsAvailable >= ? ";
			
			PreparedStatement prepState = c.prepareStatement(selectStatement);
			PreparedStatement countedPrepState = c.prepareStatement(countSelectStatement);
			
			String dateString = dateToString(date);
			
			prepState.setString(1, dateString);
			prepState.setString(2, departureLocation);
			prepState.setString(3, arrivalLocation);
			prepState.setInt(4, numberOfPassengers);
			
			countedPrepState.setString(1, dateString);
			countedPrepState.setString(2, departureLocation);
			countedPrepState.setString(3, arrivalLocation);
			countedPrepState.setInt(4, numberOfPassengers);
			
			ResultSet flightResultSet = prepState.executeQuery();
			ResultSet countResultSet = countedPrepState.executeQuery();
			
			int numberOfResults = countResultSet.getInt("COUNT(*)");
			
			flights = new ArrayList<Flight>(numberOfResults);
			
			//Búum til flughluti með þeim upplýsingu sem þarf að birta notanda
			while(flightResultSet.next()){
				Flight flight = new Flight();
				flight.setDepartureDate(flightResultSet.getString(dateString));
				flight.setDepartureLocation(flightResultSet.getString(departureLocation));
				flight.setArrivalLocation(flightResultSet.getString(arrivalLocation));
				flight.setNumberOfPassengers(flightResultSet.getInt(numberOfPassengers));
				flight.setTotalPrice(flightResultSet.getInt("SeatPrice")*numberOfPassengers);
				flight.setDepartureTime(flightResultSet.getString("DepartureTime"));
				flight.setArrivalTime(flightResultSet.getString("ArrivalTime"));
				flight.setDuration(flightResultSet.getString("Duration"));
				flight.setFoodInfo(flightResultSet.getString("FoodInfo"));
				flight.setAirline(flightResultSet.getString("Airline"));
				flight.setMaximumLuggageWeight(flightResultSet.getInt("MaximumLuggageWeight"));
				
				flights.add(flight);
			}
			
			prepState.close();
			c.close();
			
		}catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
		}
		return flights;
	}
	
	
	public String dateToString(Date date){
	    DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
	    String dateString = df.format(date);
	    return dateString;
	}
}
