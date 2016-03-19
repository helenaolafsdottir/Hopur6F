import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.sql.*;

/**
 * User Interface sem birtir niðurstöður úr flugleitinni.
 * @author Arna Björgvinsdóttir, Hannes Jón Ívarsson, Helena Ólafsdóttir, Sandra Gunnarsdóttir
 */
public class BokaUserInterface {
	
	static BookingController bokun = new BookingController();
	
	static Connection c;
	private JFrame frame;
	static JTextPane[] totalFlightsPanes = new JTextPane[1000];
	static JRadioButton[] totalFlightsButtons = new JRadioButton[1000];
	static JTextPane[] totalFlightsPaness = new JTextPane[1000];
	static JTextPane ekkertLaustDeparture = new JTextPane();
	static JTextPane ekkertLaustArrival = new JTextPane();
	static JTextPane departureFlightsPane = new JTextPane();
	static JTextPane arrivalFlightsPane = new JTextPane();
	static JRadioButton[] totalFlightsButtonss = new JRadioButton[1000];
	static JButton jBookFlightButton = new JButton();
	static Booking bokudFlug;
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
	 * Hér eru flugniðurstöðurnar sem fengust úr search fallinu birtar notandanum.
	 */
	public static Booking bokaFlug(ArrayList<Flight> departureFlights, ArrayList<Flight> arrivalFlights) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.print(departureFlights);
					//System.out.print(arrivalFlights);
					BokaUserInterface window = new BokaUserInterface();
					window.frame.setVisible(true);
					
					JPanel panel = new JPanel();
					panel.setBounds(0, 0, 450, 300);
				    window.frame.getContentPane().add(panel);
					
					int departureSize = departureFlights.size();
					int v=25;
					int i=0;
					
					//Ef initialize-flugið er í departureFlights þá fengust engar niðurstöður úr database og við segjum notanda frá því.
					if(departureFlights.get(0).getTotalPrice() == 0){
						ekkertLaustDeparture = new JTextPane();
						ekkertLaustDeparture.setBounds(10,10,375,20);
						ekkertLaustDeparture.setText("Ekkert brottfaraflug er laust");
						panel.add(ekkertLaustDeparture);
					}
					//Niðurstöður fundust, við birtum þær notanda.
					else {
						departureFlightsPane.setText("Brottfararflug:");
						panel.add(departureFlightsPane);
						while(i<departureSize){
								totalFlightsPanes[i] = new JTextPane();
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
					}
					
					//Notandi vildi einungis bóka brottfararflug
					if(arrivalFlights.isEmpty()){
						//Do nothing
					}
					//Notandi vildi bóka tvö flug en ekkert heimkomuflug fannst.
					else if(arrivalFlights.get(0).getTotalPrice() == 0){
						ekkertLaustArrival = new JTextPane();
						ekkertLaustArrival.setBounds(10,10,375,20);
						ekkertLaustArrival.setText("Ekkert heimkomuflug er laust");
						panel.add(ekkertLaustArrival);
					}
					//Notandi vildi bóka tvö flug, einhver heimkomuflug fundust, birtum þær notanda.
					else{
						arrivalFlightsPane.setText("Heimkomuflug:");
						panel.add(arrivalFlightsPane);
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
					
					//Búum til bóka takka.
					JButton jBookFlightButton = new JButton();
					jBookFlightButton.setBounds(110, 100, 350, 100);
					jBookFlightButton.setText("Bóka flug");
				    jBookFlightButton.addActionListener(new ActionListener() {
				    	public void actionPerformed(ActionEvent e) {

							//Ef notandi leitaði að brottfarar- og heimkomuflugum
				    		if(!(arrivalFlights.isEmpty())){
				    			
				    				//Ef engin flug heimkomuflug fundust
					    			if(arrivalFlights.get(0).getTotalPrice() == 0 ){
					    				//Notandi verður að haka við það flug sem hann vill bóka, ef hann gerir það ekki fær hann villuskilaboð
						    			if(departureButtonGroup.getSelection() ==null){
						    				JOptionPane.showMessageDialog(null, "Vinsamlegast veldu það flug sem þú vilt bóka.");
						    			}
						    			else{
						    				bokun.reduceNumberOfSeats(departureNumberOfPassengers, departureTicketsAvailable, departureID);
						    				bokudFlug = bokun.createBooking(departureFlight, null);
						    			}
					    			}
					    			
					    			//Ef engin brottfararflug fundust
					    			else if(departureFlights.get(0).getTotalPrice() == 0 ){
					    				//Notandi verður að haka við það flug sem hann vill bóka, ef hann gerir það ekki fær hann villuskilaboð
						    			if(arrivalButtonGroup.getSelection() == null){
						    				JOptionPane.showMessageDialog(null, "Vinsamlegast veldu það flug sem þú vilt bóka.");
						    			}
						    			else{
						    				bokun.reduceNumberOfSeats(arrivalNumberOfPassengers, arrivalTicketsAvailable, arrivalID);
						    				bokudFlug = bokun.createBooking(null, arrivalFlight);
						    			}
					    				
					    			}
					    			//Ef bæði brottfarar- og heimkomuflug fundust
					    			else{
						    			//Notandi verður að haka við þau tvö flug sem hann vill bóka, ef hann gerir það ekki fær hann villuskilaboð
						    			if(departureButtonGroup.getSelection() == null || arrivalButtonGroup.getSelection() == null){
						    				JOptionPane.showMessageDialog(null, "Vinsamlegast veldu þau flug sem þú vilt bóka.");
						    			}
						    			else{
						    				bokun.reduceNumberOfSeats(departureNumberOfPassengers, departureTicketsAvailable, departureID);
						    				bokun.reduceNumberOfSeats(arrivalNumberOfPassengers, arrivalTicketsAvailable, arrivalID);
						    				bokudFlug = bokun.createBooking(departureFlight, arrivalFlight);
						    			}
					    				
					    			}
				    			
				    			
				    		}
							//Ef notandi leitaði einungis af brottfararflugum
				    		else {
				    			//Notandi verður að haka við það flug sem hann vill bóka, ef hann gerir það ekki fær hann villuskilaboð
				    			if(departureButtonGroup.getSelection() ==null){
				    				JOptionPane.showMessageDialog(null, "Vinsamlegast veldu það flug sem þú vilt bóka.");
				    			}
				    			else{
				    				//Þurfum bara eitt tilfelli því engin takki er birtur ef engar niðurstöður fundust. 
				    				bokun.reduceNumberOfSeats(departureNumberOfPassengers, departureTicketsAvailable, departureID);
				    				bokun.reduceNumberOfSeats(arrivalNumberOfPassengers, arrivalTicketsAvailable, arrivalID);
				    				bokudFlug = bokun.createBooking(departureFlight, arrivalFlight);
				    			}
				    		}
				    	}
				    });
				    
				    //Birtum bóka flug takkann einungis ef einhver flug fundust:
				    
				    //Notandi leitaði að tveimur flugum
				    if(!(arrivalFlights.isEmpty())){
				    	//Birtum takka ef einhver flug fundust.
				    	if(!(arrivalFlights.get(0).getTotalPrice() == 0 && departureFlights.get(0).getTotalPrice() == 0)){
				    		panel.add(jBookFlightButton);
				    	}
					}
				    //Notandi einungis af brottfararflugi
				    else {
				    	//Birtum takka ef brottfararflug fannst.
				    	if(!(departureFlights.get(0).getTotalPrice() == 0)){
				    		panel.add(jBookFlightButton);
				    	}
				    }
				    	
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
