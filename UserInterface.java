package Hopur6F;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.util.Arrays;
import java.util.ArrayList;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.util.Date;

public class UserInterface {

	private JFrame frame;
	private JTextField textField;
	private JComboBox jBrottfararstadurComboBox;
	private JComboBox jAfangastadurComboBox;
	private JComboBox jFjoldiComboBox;
	private JDateChooser jDepartureDateChooser;
	
	Search mySearch = new Search();
	
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
		
		textField = new JTextField();
		frame.getContentPane().add(textField, BorderLayout.CENTER);
		
		textField = new JTextField();
		frame.getContentPane().add(textField, BorderLayout.WEST);
		frame.getContentPane().setLayout(null);
		
		JButton jAframButton = new JButton("\u00C1fram");
		jAframButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jAframButtonActionPerformed(e);
			}
		});
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
		jFjoldiLabel.setBounds(70, 300, 57, 32);
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
		jFjoldiComboBox.setBounds(135, 300, 69, 32);
		frame.getContentPane().add(jFjoldiComboBox);
		
		JDateChooser jDepartureDateChooser = new JDateChooser();
		jDepartureDateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jDepartureDateChooser.setBounds(236, 218, 156, 32);
		frame.getContentPane().add(jDepartureDateChooser);
		
		JLabel jDatelabel = new JLabel("Dagsetning:");
		jDatelabel.setBounds(66, 218, 139, 32);
		frame.getContentPane().add(jDatelabel);
		
	} 
    private void jAframButtonActionPerformed(java.awt.event.ActionEvent e) { 
		String departureLocation = jBrottfararstadurComboBox.getSelectedItem().toString();
		String arrivalLocation = jAfangastadurComboBox.getSelectedItem().toString();
		int numberOfPassengers = Integer.parseInt(jFjoldiComboBox.getSelectedItem().toString());
		Date date = jDepartureDateChooser.getDate();
		ArrayList<Flight> flights = mySearch.gettingCorrectSearchResults(departureLocation, arrivalLocation, numberOfPassengers, date);
    }
}
