package Bank;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.JPasswordField;

import Screen.Screen;

/*
 * The Login class represents a login screen for the bank application.
 * It allows users to enter their username and password to access the system.
 */

public class Login extends Screen
{
	
	private JTextField usernameField;
	private JPasswordField passwordField;

	public Login()
	{
		initialize();
		frame.setVisible(true);
	}
	
	// Initializes the login screen.
	protected void initialize()
	{
		// Initialize the frame.
		frame = createFrame("Login", 400, 300);

		// Main Panel
		JPanel panel = createPanel(new BorderLayout(), new Color(44, 62, 80));
		
		// Form Panel
		JPanel formPanel = createPanel(panel, new GridLayout(3, 1, 0, 10), BorderFactory.createEmptyBorder(20, 20, 20, 20), new Color(52, 73, 94));
		
		// Header Label
		createLabel(formPanel, "Welcome to Toro's ATM", JLabel.CENTER, new Font("Arial", Font.BOLD, 20), new Color(255, 255, 255));
		
		// Input Panel
		JPanel inputPanel = createPanel(formPanel, new GridLayout(2, 2, 10, 10), new Color(52, 73, 94));

		// Username Label & Field
		createLabel(inputPanel, "Username:", new Color(255, 255, 255));
		usernameField = createTextField(inputPanel);
		
		// Password Label & Field
		createLabel(inputPanel, "Password:", new Color(255, 255, 255));
		passwordField = createPasswordField(inputPanel);

		// Login Button
		createButton(formPanel, "Login", new Color(46, 204, 113), true, false, Color.WHITE, this::loginAction);

		// Add Main Panel to Frame
		frame.add(panel);
	}

	// Action listener for the login button
	private void loginAction(ActionEvent event)
	{
		// Get username and password from input fields
		String activeUsername = usernameField.getText();
		String password = new String(passwordField.getPassword());

		// Check if username and password are valid
		if (activeUsername.equals("admin") && password.equals("admin"))
		{
			// If valid, open dashboard panel
			frame.dispose();
			new BankSystem(activeUsername);
		}
		else
		{
			// If invalid, display error message
			activeUsername = "";
			JOptionPane.showMessageDialog(frame, "Invalid username or password. Please try again.");
		}
		passwordField.setText("");
	}

}
