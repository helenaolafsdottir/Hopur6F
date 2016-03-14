import java.util.ArrayList;
import java.sql.*;

public class Search{
	Connection c;
	
	private ArrayList<Flight> flights;
		
	public ArrayList<Flight> gettingCorrectSearchResults(String departureLocation, String arrivalLocation, int numberOfPassengers, String dateString){
		try {
			c = DriverManager.getConnection("jdbc:sqlite:Verkefni6Flug.db");
			
			String select = "SELECT * FROM Flights WHERE DepartureDate = ? AND DepartureLocation = ? AND arrivalLocation = ? AND TicketsAvailable >= ? ";
			String countSelect = "SELECT COUNT(*) FROM Flights WHERE DepartureDate = ? AND DepartureLocation = ? AND arrivalLocation = ? AND TicketsAvailable >= ? ";
			
			PreparedStatement prepState = c.prepareStatement(select);
			PreparedStatement countedPrepState = c.prepareStatement(countSelect);
			
			//Stingum inn fyrir spurningamerkin í SQL statementinu.
			prepState.setString(1, dateString);
			prepState.setString(2, departureLocation);
			prepState.setString(3, arrivalLocation);
			prepState.setInt(4, numberOfPassengers);
				
			countedPrepState.setString(1, "'" + dateString + "'");
			countedPrepState.setString(2, "'" + departureLocation + "'");
			countedPrepState.setString(3, "'" + arrivalLocation + "'");
			countedPrepState.setInt(4, numberOfPassengers);
			
			//Fáum gögnin frá gagnagrunninum
			ResultSet flightResultSet = prepState.executeQuery();
			ResultSet countResultSet = countedPrepState.executeQuery();
			
			int numberOfResults = countResultSet.getInt("COUNT(*)");

			flights = new ArrayList<Flight>(numberOfResults);
			
			//Búum til flughluti með þeim upplýsingu sem þarf að birta notanda
			while(flightResultSet.next()){

				Flight flight = new Flight();
				flight.setID(flightResultSet.getInt("ID"));
				flight.setDepartureDate(dateString);
				flight.setDepartureLocation(departureLocation);
				flight.setArrivalLocation(arrivalLocation);
				flight.setNumberOfPassengers(numberOfPassengers);
				flight.setTotalPrice(flightResultSet.getInt("SeatPrice")*numberOfPassengers);
				flight.setDepartureTime(flightResultSet.getString("DepartureTime"));
				flight.setArrivalTime(flightResultSet.getString("ArrivalTime"));
				flight.setDuration(flightResultSet.getString("Duration"));
				flight.setFoodInfo(flightResultSet.getString("FoodInfo"));
				flight.setAirline(flightResultSet.getString("Airline"));
				flight.setMaximumLuggageWeight(flightResultSet.getInt("MaximumLuggageWeight"));
				flight.setTicketsAvailable(flightResultSet.getInt("TicketsAvailable"));
				
				System.out.println(flight.getTicketsAvailable());

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

}
