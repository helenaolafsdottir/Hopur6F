import java.util.*;

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
	
	public Flight(){	
	}
	
	public void setDepartureDate(String date){
		this.departureDate = date;
	}
	
	public void setDepartureLocation(String departureLoc){
		this.departureLocation = departureLoc;
	}
	
	public void setArrivalLocation(String arrivalLoc){
		this.arrivalLocation = arrivalLoc;
	}
	
	public void setNumberOfPassengers(int numberOfPass){
		this.numberOfPassengers = numberOfPass;
	}
	
	public void setTotalPrice(int price){
		this.totalPrice = price;
	}
	
	public void setDepartureTime(String depTime){
		this.departureTime = depTime;
	}
	
	public void setArrivalTime(String arrTime){
		this.arrivalTime = arrTime;
	}
	
	public void setDuration (String dur){
		this.duration = dur;
	}
	
	public void setFoodInfo (String food){
		this.foodInfo = food;
	}
	
	public void setAirline (String airl){
		this.airline = airl;
	}
	
	public void setMaximumLuggageWeight (int luggageWeight){
		this.maximumLuggageWeight = luggageWeight;
	}
}

