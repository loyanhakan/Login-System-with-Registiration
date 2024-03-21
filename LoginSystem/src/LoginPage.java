import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener{

	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("userID:");
	JLabel userPasswordLabel = new JLabel("password:");
	JLabel messageLabel = new JLabel("ASH LOGIN");
	JButton registerButton = new JButton("REGISTER");
	
	HashMap<String, String> logininfo = new HashMap<String, String>();
	
	LoginPage(HashMap<String, String> loginInfoOriginal){
		
		logininfo = loginInfoOriginal;
		
		userIDLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
		
		userIDField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);
		
		loginButton.setBounds(125,200,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(225,200,100,25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		registerButton.setBounds(210,300,100,25);
		registerButton.setFocusable(true);
		registerButton.addActionListener(this);
		
		messageLabel.setBounds(125,250,250,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		
		frame.add(registerButton);
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //bunu sor
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
			messageLabel.setText("ASH LOGIN");
			messageLabel.setForeground(Color.black);
		}
		
		else if(e.getSource()==registerButton) {
			RegisterPage registerPage = new RegisterPage(logininfo);
			frame.dispose();
		}
		
		else if(e.getSource()==loginButton){
			
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(logininfo.containsKey(userID)) {
				if(logininfo.get(userID).equals(password)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login succesful!");  //!!!!!!!! buraya bekleme komutu eklenmeli fakat işlem beklemeye alındığından ekran donuyor LOGİN SUCSESS gözükmüyor!!!!!!
					WelcomePage welcomePage = new WelcomePage(userID);
					frame.dispose(); //frame.setVisible(false); // de yapabiliriz ama işlemi döndürür sadece görünmez yapar
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("SUSPICIOUS?");
				}
			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("user name not found!");
			}
		}
	}

}