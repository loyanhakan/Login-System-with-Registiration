import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RegisterPage implements ActionListener {

	
	JFrame frame = new JFrame();
	JTextField usernameField = new JTextField();
	JTextField passwordField = new JTextField();
	JButton saveButton = new JButton("Save and go back!");
	JLabel usernameLabel = new JLabel("userID:");
	JLabel passwordLabel = new JLabel("password:");
	
	
	HashMap<String, String> logininfo = new HashMap<String, String>();
	
	public RegisterPage(HashMap<String, String> loginInfoOriginal) {
		
		logininfo = loginInfoOriginal;
		
		usernameLabel.setBounds(50,100,75,25);
		passwordLabel.setBounds(50,150,75,25);
		
		usernameField.setBounds(125,100,200,25);
		passwordField.setBounds(125,150,200,25);
		
		saveButton.setBounds(50,300,250,25);
		saveButton.setFocusable(true);
		saveButton.setLayout(null);
		saveButton.addActionListener(this);
		
		frame.add(saveButton);
		frame.add(usernameLabel);
		frame.add(passwordLabel);
		frame.add(usernameField);
		frame.add(passwordField);
		
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==saveButton) {
			String userID = usernameField.getText();
			String password1 = passwordField.getText();
			if(logininfo.containsKey(userID)) {
				JOptionPane.showMessageDialog(null," This username is Already Taken!", "Warning", JOptionPane.WARNING_MESSAGE );
			}
			else {
			logininfo.put(userID, password1);
			LoginPage loginPage = new LoginPage(logininfo);
			frame.dispose();
			}
		}
			
		
	}

}
