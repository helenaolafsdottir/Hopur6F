/**
 * Flughlutur
 * @author Arna Björgvinsdóttir, Hannes Jón Ívarsson, Helena Ólafsdóttir, Sandra Gunnarsdóttir
 */
public class Flight {
	
	private String departureDate;
	private String departureLocation;
	private String arrivalLocation;
	private int numberOfPassengers;
	private int totalPrice;
	private String departureTime;
	private String arrivalTime;
	private String duration;
	private String foodInfo;
	private String airline;
	private int maximumLuggageWeight;
	private int id;
	private int ticketsAvailable;
	
	public Flight(){	
	}
	
	public void setID(int ids){
		this.id = ids;
	}
	public int getID(){
		return this.id;
	}
	

	public void setDepartureDate(String date){
		this.departureDate = date;
	}

	public String getDepartureDate(){
		return this.departureDate;
	}
	
	public void setDepartureLocation(String departureLoc){
		this.departureLocation = departureLoc;
	}
	public String getDepartureLocation(){
		return this.departureLocation;
	}
	
	public void setArrivalLocation(String arrivalLoc){
		this.arrivalLocation = arrivalLoc;
	}
	public String getArrivalLocation(){
		return this.arrivalLocation;
	}
	
	public void setNumberOfPassengers(int numberOfPass){
		this.numberOfPassengers = numberOfPass;
	}
	public int getNumberOfPassengers(){
		return this.numberOfPassengers;
	}
	
	public void setTotalPrice(int price){
		this.totalPrice = price;
	}
	public int getTotalPrice(){
		return this.totalPrice;
	}
	
	public void setDepartureTime(String depTime){
		this.departureTime = depTime;
	}
	public String getDepartureTime(){
		return this.departureTime;
	}
	
	public void setArrivalTime(String arrTime){
		this.arrivalTime = arrTime;
	}
	public String getArrivalTime(){
		return this.arrivalTime;
	}
	
	public void setDuration (String dur){
		this.duration = dur;
	}
	public String getDuration(){
		return this.duration;
	}
	
	public void setFoodInfo (String food){
		this.foodInfo = food;
	}
	public String getFoodInfo(){
		return this.foodInfo;
	}
	
	public void setAirline (String airl){
		this.airline = airl;
	}
	public String getAirline(){
		return this.airline;
	}
	
	public void setMaximumLuggageWeight (int luggageWeight){
		this.maximumLuggageWeight = luggageWeight;
	}
	public int getMaximumLuggageWeight(){
		return this.maximumLuggageWeight;
	}
	
	public void setTicketsAvailable (int tickets){
		this.ticketsAvailable = tickets;
	}
	public int getTicketsAvailable(){
		return this.ticketsAvailable;
	}
	
}

