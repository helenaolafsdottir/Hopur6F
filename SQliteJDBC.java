package Hopur6F;

import java.sql.*;

public class SQliteJDBC
{
  public static void main( String args[] )
  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:Verkefni6F.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = "INSERT INTO Flights (ID,FlightNumber,DepartureLocation,ArrivalLocation,SeatPrice,DepartureTime,DepartureDate,ArrivalTime,Duration,FoodInfo,Airline,MaximumLuggageWeight,TicketsAvailable) " +
                   "VALUES (1, 'RA102', 'Reykjavík', 'Akureyri', 10000, '12:00', '1.6.2016', '13:00', '01:00', 'Epli og Kók', 'Flugfélag Íslands', 20, 30);"; 
      stmt.executeUpdate(sql);

      sql = "INSERT INTO Flights (ID,FlightNumber,DepartureLocation,ArrivalLocation,SeatPrice,DepartureTime,DepartureDate,ArrivalTime,Duration,FoodInfo,Airline,MaximumLuggageWeight,TicketsAvailable) " +
            "VALUES (2, 'RA105', 'Reykjavík', 'Akureyri', 10000, '17:00', '1.6.2016', '18:00', '01:00', 'Banani og Safi', 'Flugfélag Íslands', 20, 30);"; 
      stmt.executeUpdate(sql);

      sql = "INSERT INTO FLights (ID,FlightNumber,DepartureLocation,ArrivalLocation,SeatPrice,DepartureTime,DepartureDate,ArrivalTime,Duration,FoodInfo,Airline,MaximumLuggageWeight,TicketsAvailable) " +
            "VALUES (3, 'AR110', 'Akureyri', 'Reykjavík', 10000, '15:00', '1.6.2016', '16:00', '01:00', 'Epli og Kók', 'Flugfélag Íslands', 20, 30);"; 
      stmt.executeUpdate(sql);

      sql = "INSERT INTO Flights (ID,FlightNumber,DepartureLocation,ArrivalLocation,SeatPrice,DepartureTime,DepartureDate,ArrivalTime,Duration,FoodInfo,Airline,MaximumLuggageWeight,TicketsAvailable) " +
            "VALUES (4, 'RI105', 'Reykjavík', 'Ísafjörður', 10000, '09:30', '2.6.2016', '11:00', '01:30', 'Langloka og vatn', 'Flugfélag Íslands', 20, 30);"; 
      stmt.executeUpdate(sql);
      
      sql = "INSERT INTO Flights (ID,FlightNumber,DepartureLocation,ArrivalLocation,SeatPrice,DepartureTime,DepartureDate,ArrivalTime,Duration,FoodInfo,Airline,MaximumLuggageWeight,TicketsAvailable) " +
              "VALUES (5, 'IR111', 'Ísafjörður', 'Reykjavík', 10000, '13:30', '2.6.2016', '15:00', '01:30', 'Langloka og vatn', 'Flugfélag Íslands', 20, 30);"; 
        stmt.executeUpdate(sql);
        
      sql = "INSERT INTO Flights (ID,FlightNumber,DepartureLocation,ArrivalLocation,SeatPrice,DepartureTime,DepartureDate,ArrivalTime,Duration,FoodInfo,Airline,MaximumLuggageWeight,TicketsAvailable) " +
              "VALUES (6, 'RE101', 'Reykjavík', 'Egilsstaðir', 10000, '08:00', '3.6.2016', '09:40', '01:40', 'Möffins og appelsín', 'Flugfélag Íslands', 20, 30);"; 
        stmt.executeUpdate(sql);
          
      sql = "INSERT INTO Flights (ID,FlightNumber,DepartureLocation,ArrivalLocation,SeatPrice,DepartureTime,DepartureDate,ArrivalTime,Duration,FoodInfo,Airline,MaximumLuggageWeight,TicketsAvailable) " +
              "VALUES (7, 'ER105', 'Egilsstaðir', 'Reykjavík', 10000, '12:00', '2.6.2016', '13:40', '01:40', 'Möffins og appelsín', 'Flugfélag Íslands', 20, 30);"; 
        stmt.executeUpdate(sql);

      stmt.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Records created successfully");
  }
}

