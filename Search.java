import java.util.ArrayList;
import java.sql.*;

/**
 * Search inniheldur eina aðgerð sem finnur þau flug sem uppfylla skilyrði frá notanda.
 * @author Arna Björgvinsdóttir, Hannes Jón Ívarsson, Helena Ólafsdóttir, Sandra Gunnarsdóttir
 */
public class Search{
	Connection c;
	
	private ArrayList<Flight> flights;
	/**
	 * Finnur öll þau flug sem uppfylla þau skilyrði sem notandi setti á flugið.
	 * @param departureLocation skilyrði frá notanda - brottfararstaður
	 * @param arrivalLocation skilyrði frá notanda - áfangastaður
	 * @param numberOfPassengers  skilyrði frá notanda - fjöldi farþega
	 * @param dateString skilyrði frá notanda - dagsetning 
	 * @return þau flug sem uppfylla skilyrðin sem notandin setti.
	 */
	public ArrayList<Flight> gettingCorrectSearchResults(String departureLocation, String arrivalLocation, int numberOfPassengers, String dateString){
		try {
			c = DriverManager.getConnection("jdbc:sqlite:Verkefni6Flug.db");
			
			String select = "SELECT * FROM Flights WHERE DepartureDate = ? AND DepartureLocation = ? AND arrivalLocation = ? AND TicketsAvailable >= ? ";
			String count = "SELECT COUNT(*) FROM Flights WHERE DepartureDate = ? AND DepartureLocation = ? AND arrivalLocation = ? AND TicketsAvailable >= ? ";
			PreparedStatement prepState = c.prepareStatement(select);
			PreparedStatement prepStateCount = c.prepareStatement(count);
			
			//Stingum inn fyrir spurningamerkin í SQL statementinu.
			prepState.setString(1, dateString);
			prepState.setString(2, departureLocation);
			prepState.setString(3, arrivalLocation);
			prepState.setInt(4, numberOfPassengers);
			
			prepStateCount.setString(1, dateString);
			prepStateCount.setString(2, departureLocation);
			prepStateCount.setString(3, arrivalLocation);
			prepStateCount.setInt(4, numberOfPassengers);
			
			//Fáum gögnin frá gagnagrunninum
			ResultSet flightResultSet = prepState.executeQuery();
			ResultSet flightResultSetCount = prepStateCount.executeQuery();
			
			//Fjoldi niðurstaða úr gagnagrunni
			int numResults = flightResultSetCount.getInt("COUNT(*)");
			
			//flights mun innihalda öll þau flug sem uppfylltu skilyrðin
			flights = new ArrayList<Flight>();
			
			//Initialize-um flights ArrayListann með einu flugi til að vita muninn á því annars vegar að notandinn hafi leitað að 
			//flugi og enginn flug fundist og hins vegar að notandinn hafi ekki leitað að tilteknu flugi (t.d. einungis leitað að 
			//brottfararflugi en ekki heimkomuflugi)
			Flight flight0 = new Flight();
			flight0.setTotalPrice(0);
			flights.add(flight0);
			
			//Ef einhverjar niðurstöður fundust í gagnagrunni þá tæmum við flights Arraylistann
			if(numResults != 0){
				flights.clear();
			}
			
			//Búum til flughluti með þeim upplýsingum sem þarf að birta notanda og setjum þá í ArrayListann flights
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
				flight.setFlightNumber(flightResultSet.getString("FlightNumber"));


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
