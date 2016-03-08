import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Choice;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class UserInterface {

	private JFrame frame;
	private JTextField textField;
	private JTextField testTextField;
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
		
		String[] Brottfararstadir = { "Reykjavík", "Akureyri", "Egilsstaðir", "Ísafjörður"};
		JComboBox jBrottfararstadurComboBox = new JComboBox(Brottfararstadir);
		jBrottfararstadurComboBox.setBounds(236, 105, 156, 32);
		frame.getContentPane().add(jBrottfararstadurComboBox);
		
		String[] Afangastadir = { "Reykjavík", "Akureyri", "Egilsstaðir", "Ísafjörður"};
		JComboBox jAfangastadurComboBox = new JComboBox(Afangastadir);
		jAfangastadurComboBox.setBounds(236, 143, 156, 32);
		frame.getContentPane().add(jAfangastadurComboBox);
		
		testTextField = new JTextField();
		testTextField.setBounds(199, 321, 97, 32);
		frame.getContentPane().add(testTextField);
		testTextField.setColumns(10);
		
	}
    private void jAframButtonActionPerformed(java.awt.event.ActionEvent e) { 
    	testTextField.setText(jBrottfararstadurComboBox.getSelectedItem().toString());
        String text = "brottfararstadur: " + brottfararstadur + "afangastadur: " + afangastadur + "   :)";
    }                                               
}
