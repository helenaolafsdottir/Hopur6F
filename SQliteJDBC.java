import java.sql.*;

public class SQLiteJDBC
{
  public static void main( String args[] )
  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:Verkefni6Flug.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();

      ResultSet rs = stmt.executeQuery( "SELECT * FROM Flights;" );
      while ( rs.next() ) {
         int id = rs.getInt("ID");
         String  name = rs.getString("FlightNumber");
         String age  = rs.getString("DepartureLocation");
         String  address = rs.getString("ArrivalLocation");
         int  bla = rs.getInt("SeatPrice");
         String  adwdress = rs.getString("DepartureTime");
         String  adeweess = rs.getString("DepartureDate");
         String  aeess = rs.getString("ArrivalTime");
         String  as = rs.getString("Duration");
         String  ass = rs.getString("FoodInfo");
         String  aess = rs.getString("Airline");
         int  adress = rs.getInt("MaximumLuggageWeight");
         int  asdf = rs.getInt("TicketsAvailable");
         

         System.out.println(id + name + age + address + bla + adwdress + adeweess + aeess + as + ass + aess + adress + asdf );
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Operation done successfully");
  }
}