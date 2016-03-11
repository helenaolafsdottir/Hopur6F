import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Search{
	Connection c;
	
	private ArrayList<Flight> flights;
		
	public ArrayList<Flight> gettingCorrectSearchResults(String departureLocation, String arrivalLocation, int numberOfPassengers, String dateString){
		try {
			c = DriverManager.getConnection("jdbc:sqlite:Verkefni6Flug.db");
			
			String selectStatement = "SELECT * FROM Flights WHERE DepartureDate = ? AND DepartureLocation = ? AND arrivalLocation = ? AND TicketsAvailable >= ? ";
			String countSelectStatement = "SELECT COUNT(*) FROM Flights WHERE DepartureDate = ? AND DepartureLocation = ? AND arrivalLocation = ? AND TicketsAvailable >= ? ";
			
			PreparedStatement prepState = c.prepareStatement(selectStatement);
			PreparedStatement countedPrepState = c.prepareStatement(countSelectStatement);
			
			System.out.println(dateString);
			System.out.println(departureLocation);
			System.out.println(arrivalLocation);
			System.out.println(numberOfPassengers);
			
			//Stingum inn fyrir spurningamerkin í SQL statementinu.
			prepState.setString(1, "'" + dateString + "'");
			prepState.setString(2, "'" + departureLocation + "'");
			prepState.setString(3, "'" + arrivalLocation + "'");
			prepState.setInt(4, numberOfPassengers);
				
			countedPrepState.setString(1, "'" + dateString + "'");
			countedPrepState.setString(2, "'" + departureLocation + "'");
			countedPrepState.setString(3, "'" + arrivalLocation + "'");
			countedPrepState.setInt(4, numberOfPassengers);
			
			//Fáum gögnin frá gagnagrunninum
			ResultSet flightResultSet = prepState.executeQuery();
			ResultSet countResultSet = countedPrepState.executeQuery();
			
			int numberOfResults = countResultSet.getInt("COUNT(*)");
			
			System.out.println(numberOfResults);
			
			flights = new ArrayList<Flight>(numberOfResults);
			
			//Búum til flughluti með þeim upplýsingu sem þarf að birta notanda
			while(flightResultSet.next()){
				
				System.out.println("hæ!");
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
				
				//System.out.println(flight);
			
				flights.add(flight);
			}
			
			prepState.close();
			c.close();
			
		}catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
		}
		//System.out.println(flights);
		return flights;
	}

}
