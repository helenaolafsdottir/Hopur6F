import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.sql.*;

public class BokaUserInterface {
	
	static Connection c;
	private JFrame frame;
	static JTextPane[] totalFlightsPanes = new JTextPane[1000];
	static JButton[] totalFlightsButtons = new JButton[1000];
	/**
	 * Launch the application.
	 */
	public static void NewScreen(ArrayList<Flight> flights) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BokaUserInterface window = new BokaUserInterface();
					window.frame.setVisible(true);
					
					JPanel panel = new JPanel();
					panel.setBounds(0, 0, 450, 300);
				    window.frame.add(panel);
					
					int size = flights.size();
					int v=25;
					int i=0;
					
					while(i<size){
							totalFlightsPanes[i] = new JTextPane();
							totalFlightsPanes[i].setBounds(10,v,375,20);
							totalFlightsPanes[i].setText(flights.get(i).getAirline() + "\n" + flights.get(i).getArrivalLocation());
							panel.add(totalFlightsPanes[i]);
							
							totalFlightsButtons[i] = new JButton();
							totalFlightsButtons[i].setBounds(10,v+10,375,20);
							totalFlightsButtons[i].setText("Velja");
							int a = i;
							totalFlightsButtons[i].addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									int numberOfPassengers = flights.get(a).getNumberOfPassengers();
									int id = flights.get(a).getID();
									int ticketsAvailable = flights.get(a).getTicketsAvailable();
									int finalTicketsAvailable = ticketsAvailable - numberOfPassengers;								
									try {
										c = DriverManager.getConnection("jdbc:sqlite:Verkefni6Flug.db");
										c.setAutoCommit(false);
									
										String update = "UPDATE Flights SET TicketsAvailable = ? WHERE ID = ?";
										PreparedStatement prepState = c.prepareStatement(update);
									
										prepState.setInt(1, finalTicketsAvailable);
										prepState.setInt(2, id);
										
										prepState.executeUpdate();
										c.commit();
										prepState.close();
										c.close();
									}catch(Exception evt){
										System.err.println( evt.getClass().getName() + ": " + evt.getMessage() );
										System.exit(0);
									}
							
									
									
									
								}
							});
							panel.add(totalFlightsButtons[i]);
							
							i++;
							v+=100;
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
