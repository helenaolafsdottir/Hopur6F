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
		jFjoldiLabel.setBounds(66, 200, 57, 32);
		frame.getContentPane().add(jFjoldiLabel);
		
		String[] Brottfararstadir = {"Reykjavík", "Akureyri", "Egilsstaðir", "Ísafjörður"};
		JComboBox jBrottfararstadurComboBox = new JComboBox(Brottfararstadir);
		jBrottfararstadurComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jBrottfararstadurComboBoxActionPerformed(e);
			}
		});
		jBrottfararstadurComboBox.setBounds(236, 105, 156, 32);
		frame.getContentPane().add(jBrottfararstadurComboBox);
		
		String[] Afangastadir = {"Reykjavík", "Akureyri", "Egilsstaðir", "Ísafjörður"};
		JComboBox jAfangastadurComboBox = new JComboBox(Afangastadir);
		jAfangastadurComboBox.setBounds(236, 143, 156, 32);
		frame.getContentPane().add(jAfangastadurComboBox);
		
		testTextField = new JTextField();
		testTextField.setBounds(199, 321, 97, 32);
		frame.getContentPane().add(testTextField);
		testTextField.setColumns(10);
		
		String[] fjoldiFerdamanna = {"1", "2", "3", "4"};
		JComboBox jFjoldiComboBox = new JComboBox(fjoldiFerdamanna);
		jFjoldiComboBox.setBounds(128, 196, 69, 32);
		frame.getContentPane().add(jFjoldiComboBox);
		
	} 
	private void jBrottfararstadurComboBoxActionPerformed(java.awt.event.ActionEvent e) { 
			JComboBox cb = (JComboBox)e.getSource();
			String brottfor =  (String)cb.getSelectedItem();
			if(brottfor.equals("Reykjavík")){???};
	}
    private void jAframButtonActionPerformed(java.awt.event.ActionEvent e) { 
		testTextField.setText(Arrays.toString((String[])jBrottfararstadurComboBox.getSelectedItem()));
        //String text = "brottfararstadur: " + brottfararstadur + "afangastadur: " + afangastadur + "   :)";
    }
}
