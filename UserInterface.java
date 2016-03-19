

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.util.ArrayList;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;


/**
 * Upphafs User Interface
 * @author Arna Björgvinsdóttir, Hannes Jón Ívarsson, Helena Ólafsdóttir, Sandra Gunnarsdóttir
 */
public class UserInterface {

	private JFrame frame;
	private JComboBox jBrottfararstadurComboBox;
	private JComboBox jAfangastadurComboBox;
	private JComboBox jFjoldiComboBox;
	private String departureDateString;
	private String arrivalDateString = null;
	
	Search mySearch = new Search();
	BokaUserInterface nw = new BokaUserInterface();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton jAframButton = new JButton("\u00C1fram");
		jAframButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jAframButtonActionPerformed(e);
			}
		});
		frame.getContentPane().setLayout(null);
		jAframButton.setBounds(0, 444, 624, 35);
		frame.getContentPane().add(jAframButton);
		
		JLabel lblBkauFlug = new JLabel("Bókaðu flug! :)");
		lblBkauFlug.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblBkauFlug.setBounds(192, 21, 242, 59);
		frame.getContentPane().add(lblBkauFlug);
		
		JLabel jBrottfararstadurLabel = new JLabel("Brottfararstaður:");
		jBrottfararstadurLabel.setBounds(66, 105, 149, 32);
		frame.getContentPane().add(jBrottfararstadurLabel);
		
		JLabel jAfangastadurLabel = new JLabel("Áfangastaður:");
		jAfangastadurLabel.setBounds(66, 143, 139, 32);
		frame.getContentPane().add(jAfangastadurLabel);
		
		JLabel jFjoldiLabel = new JLabel("Fjöldi:");
		jFjoldiLabel.setBounds(66, 322, 57, 32);
		frame.getContentPane().add(jFjoldiLabel);
		
		String[] Brottfararstadir = {"Reykjavík", "Akureyri", "Egilsstaðir", "Ísafjörður"};
		jBrottfararstadurComboBox = new JComboBox(Brottfararstadir);
		jBrottfararstadurComboBox.setBounds(236, 105, 156, 32);
		frame.getContentPane().add(jBrottfararstadurComboBox);
		
		String[] Afangastadir = {"Reykjavík", "Akureyri", "Egilsstaðir", "Ísafjörður"};
		jAfangastadurComboBox = new JComboBox(Afangastadir);
		jAfangastadurComboBox.setBounds(236, 143, 156, 32);
		frame.getContentPane().add(jAfangastadurComboBox);
		
		String[] fjoldiFerdamanna = {"1", "2", "3", "4"};
		jFjoldiComboBox = new JComboBox(fjoldiFerdamanna);
		jFjoldiComboBox.setBounds(136, 322, 69, 32);
		frame.getContentPane().add(jFjoldiComboBox);
		
		JDateChooser jDepartureDateChooser = new JDateChooser();
		/*
		 * Breytir Date breytunni frá JDepartureDateChooser í String breytu
		 */
		jDepartureDateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				Date date = jDepartureDateChooser.getDate();
				if(date == null){
					departureDateString = null;
				}
				else{
					departureDateString = String.format("%1$td.%1$tm.%1$tY", date);
				}
				
			}
		});
		jDepartureDateChooser.setBounds(236, 218, 156, 32);
		frame.getContentPane().add(jDepartureDateChooser);
		
		JLabel jDatelabel = new JLabel("Brottför:");
		jDatelabel.setBounds(66, 218, 139, 32);
		frame.getContentPane().add(jDatelabel);

		
		JDateChooser jArrivalDateChooser = new JDateChooser();
		/*
		 * Breytir Date breytunni frá JArrivalDateChooser í String breytu
		 */
		jArrivalDateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				Date date = jArrivalDateChooser.getDate();
				if(date == null){
					arrivalDateString = null;
				}
				else{
					arrivalDateString = String.format("%1$td.%1$tm.%1$tY", date);
				}
			}
		});
		jArrivalDateChooser.setBounds(236, 256, 156, 32);
		frame.getContentPane().add(jArrivalDateChooser);
		jArrivalDateChooser.setVisible(false);
		
		JLabel jDateLabel1 = new JLabel("Heimkoma:");
		jDateLabel1.setBounds(66, 256, 139, 32);
		frame.getContentPane().add(jDateLabel1);
		jDateLabel1.setVisible(false);
		
		JRadioButton jRoundTripRadioButton = new JRadioButton("Round Trip");
		/*
		 * Birtir annað JDateChooser fyrir notanda ef hann hakar í RoundTrip.
		 */
		jRoundTripRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jRoundTripRadioButton.isSelected()){
					jArrivalDateChooser.setVisible(true);
					arrivalDateString = "null";
					jDateLabel1.setVisible(true);
				}
				else{
					jArrivalDateChooser.setVisible(false);
					jDateLabel1.setVisible(false);
				}
			}
		});
		jRoundTripRadioButton.setBounds(297, 321, 201, 35);
		frame.getContentPane().add(jRoundTripRadioButton);
		
	} 
	/*
	 * Takkinn tekur inn skilyrði frá notanda, finnur laus flug sem uppfylla skilyrðin
	 * og birtir þau fyrir notandanum.
	 */
    private void jAframButtonActionPerformed(java.awt.event.ActionEvent e) { 
		
    	//Sækjum upplýsingar af UI
    	String departureLocation = jBrottfararstadurComboBox.getSelectedItem().toString();
		String arrivalLocation = jAfangastadurComboBox.getSelectedItem().toString();
		int numberOfPassengers = Integer.parseInt(jFjoldiComboBox.getSelectedItem().toString());
		
		//Notandi verður að fylla inn upplýsingar um dagsetningu flugsins.
		if(departureDateString == null || arrivalDateString == "null"){
			JOptionPane.showMessageDialog(null, "Vinsamlegast veldu viðeigandi dagsetningar.");
		}
		
		else {
			ArrayList<Flight> departureFlights = mySearch.gettingCorrectSearchResults(departureLocation, arrivalLocation, numberOfPassengers, departureDateString);
			ArrayList<Flight> arrivalFlights = new ArrayList<Flight>();
			//Athugum hvort notandi ætli sér að bóka eitt eða tvö flug.
			if(!(arrivalDateString == null)){
				arrivalFlights = mySearch.gettingCorrectSearchResults(arrivalLocation, departureLocation, numberOfPassengers, arrivalDateString);
			}
			
			Booking bokadFlug = nw.bokaFlug(departureFlights, arrivalFlights);
		}
	
    }
}
