import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomePage implements ActionListener{

	JFrame frame= new JFrame();
	JLabel welcomeLabel = new JLabel("Hello!");
	JButton backButton = new JButton("back");
	JButton exitButton = new JButton("exit");
	IDandPasswords idandPasswords = new IDandPasswords();

	
	WelcomePage(String userID){
		
		
		welcomeLabel.setBounds(100,10,200,35);
		welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
		welcomeLabel.setText("Hello "+userID);
		
		backButton.setBounds(100,200,100,35);
		backButton.addActionListener(this);
		exitButton.setBounds(210,200,100,35);
		exitButton.addActionListener(this);
		
		frame.add(backButton);
		frame.add(exitButton);
		frame.add(welcomeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==backButton) {
			LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());
			loginPage.frame.setVisible(true);
			frame.dispose();
		}
		if(e.getSource()==exitButton) {
			frame.dispose();
		}
		
	}
	
	
	
}
