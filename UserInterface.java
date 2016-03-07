import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Choice;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;

public class UserInterface {

	private JFrame frame;
	private JTextField textField;
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
		
		JButton jAframBtn = new JButton("\u00C1fram");
		jAframBtn.setBounds(0, 444, 624, 35);
		frame.getContentPane().add(jAframBtn);
		
		Choice jBrottfararstadurChoice = new Choice();
		jBrottfararstadurChoice.add("Reykjavik");
		jBrottfararstadurChoice.add("Ísafjörður");
		jBrottfararstadurChoice.add("Akureyri");
		jBrottfararstadurChoice.add("Egilsstaðir");
		jBrottfararstadurChoice.setBounds(211, 105, 196, 32);
		frame.getContentPane().add(jBrottfararstadurChoice);
		
		Choice jAfangastadurChoice = new Choice();
		jAfangastadurChoice.add("Reykjavik");
		jAfangastadurChoice.add("Ísafjörður");
		jAfangastadurChoice.add("Akureyri");
		jAfangastadurChoice.add("Egilsstaðir");
		jAfangastadurChoice.setBounds(211, 143, 196, 32);
		frame.getContentPane().add(jAfangastadurChoice);
		
		JRadioButton jOneWayRadio = new JRadioButton("One Way");
		jOneWayRadio.setBounds(406, 181, 201, 35);
		frame.getContentPane().add(jOneWayRadio);
		
		JRadioButton jRoundTripRadio = new JRadioButton("Round Trip");
		jRoundTripRadio.setBounds(406, 229, 201, 35);
		frame.getContentPane().add(jRoundTripRadio);
		
		JLabel lblBkauFlug = new JLabel("B\u00F3ka\u00F0u flug! :)");
		lblBkauFlug.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblBkauFlug.setBounds(192, 21, 242, 59);
		frame.getContentPane().add(lblBkauFlug);
		
		JLabel jBrottfararstaðurLabel = new JLabel("Brottfararsta\u00F0ur");
		jBrottfararstaðurLabel.setBounds(66, 105, 149, 32);
		frame.getContentPane().add(jBrottfararstaðurLabel);
		
		JLabel jAfangastadurLabel = new JLabel("\u00C1fangasta\u00F0ur");
		jAfangastadurLabel.setBounds(66, 143, 139, 32);
		frame.getContentPane().add(jAfangastadurLabel);
		
		JLabel jFjoldiLabel = new JLabel("Fj\u00F6ldi:");
		jFjoldiLabel.setBounds(66, 200, 57, 32);
		frame.getContentPane().add(jFjoldiLabel);
		
		Choice jFjoldiChoice = new Choice();
		jFjoldiChoice.add("1");
		jFjoldiChoice.add("2");
		jFjoldiChoice.add("3");
		jFjoldiChoice.add("4");
		jFjoldiChoice.setBounds(132, 200, 73, 32);
		frame.getContentPane().add(jFjoldiChoice);
		
	}
}
