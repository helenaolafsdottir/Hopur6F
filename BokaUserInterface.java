import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.sql.*;

public class BokaUserInterface {
	
	static BookingController bokun = new BookingController();
	
	static Connection c;
	private JFrame frame;
	static JTextPane[] totalFlightsPanes = new JTextPane[1000];
	static JRadioButton[] totalFlightsButtons = new JRadioButton[1000];
	static JTextPane[] totalFlightsPaness = new JTextPane[1000];
	static JRadioButton[] totalFlightsButtonss = new JRadioButton[1000];
	static JButton jBookFlightButton = new JButton();
	static ArrayList<Flight> bokudFlug;
	static ButtonGroup departureButtonGroup = new ButtonGroup();
	static ButtonGroup arrivalButtonGroup = new ButtonGroup();
	
	static Flight departureFlight;
	static int departureNumberOfPassengers;
	static int departureID;
	static int departureTicketsAvailable;
	static Flight arrivalFlight;
	static int arrivalNumberOfPassengers;
	static int arrivalID;
	static int arrivalTicketsAvailable;
	
	
	/**
	 * Launch the application.
	 */
	public static ArrayList<Flight> bokaFlug(ArrayList<Flight> departureFlights, ArrayList<Flight> arrivalFlights) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BokaUserInterface window = new BokaUserInterface();
					window.frame.setVisible(true);
					
					JPanel panel = new JPanel();
					panel.setBounds(0, 0, 450, 300);
				    window.frame.getContentPane().add(panel);
					
					int departureSize = departureFlights.size();
					int v=25;
					int i=0;
					System.out.println(arrivalFlights);
					
					while(i<departureSize){
							totalFlightsPanes[i] = new JTextPane();
							totalFlightsPanes[i].setBounds(10,v,375,20);
							totalFlightsPanes[i].setText(departureFlights.get(i).getAirline() + "\n" + departureFlights.get(i).getArrivalLocation());
							panel.add(totalFlightsPanes[i]);
							
							totalFlightsButtons[i] = new JRadioButton();
							totalFlightsButtons[i].setBounds(10,v+10,375,20);
							departureButtonGroup.add(totalFlightsButtons[i]);

							int a = i;
							totalFlightsButtons[i].addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									departureFlight = departureFlights.get(a);
									departureNumberOfPassengers = departureFlights.get(a).getNumberOfPassengers();
									departureID = departureFlights.get(a).getID();
									departureTicketsAvailable = departureFlights.get(a).getTicketsAvailable();							
									
								}
								
							});
							panel.add(totalFlightsButtons[i]);
							
							i++;
							v+=100;
							
					}
					
					if(!(arrivalFlights.isEmpty())){
						int arrivalSize = arrivalFlights.size();
						int j = 0;
						while(j<arrivalSize){
							totalFlightsPaness[j] = new JTextPane();
							totalFlightsPaness[j].setBounds(10,v,375,20);
							totalFlightsPaness[j].setText(arrivalFlights.get(j).getAirline() + "\n" + arrivalFlights.get(j).getArrivalLocation());
							panel.add(totalFlightsPaness[j]);
							
							totalFlightsButtonss[j] = new JRadioButton();
							totalFlightsButtonss[j].setBounds(10,v+10,375,20);
							arrivalButtonGroup.add(totalFlightsButtonss[j]);
							
							int a = j;
							totalFlightsButtonss[j].addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									arrivalFlight = arrivalFlights.get(a);
									arrivalNumberOfPassengers = arrivalFlights.get(a).getNumberOfPassengers();
									arrivalID = arrivalFlights.get(a).getID();
									arrivalTicketsAvailable = arrivalFlights.get(a).getTicketsAvailable();
								}
								
							});
							panel.add(totalFlightsButtonss[j]);
							
							j++;
							v+=100;
						}
					}
					
					JButton jBookFlightButton = new JButton();
					jBookFlightButton.setBounds(110, 100, 350, 100);
					jBookFlightButton.setText("Bóka flug");
				    jBookFlightButton.addActionListener(new ActionListener() {
				    	public void actionPerformed(ActionEvent e) {
				    		bokun.reduceNumberOfSeats(departureNumberOfPassengers, departureTicketsAvailable, departureID);
				    		bokun.reduceNumberOfSeats(arrivalNumberOfPassengers, arrivalTicketsAvailable, arrivalID);
				    		bokudFlug = bokun.createBooking(departureFlight, arrivalFlight);
				    	}
				    });
				    panel.add(jBookFlightButton);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return bokudFlug;
	}

	/**
	 * Create the application.
	 */
	public BokaUserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 1000, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
}
