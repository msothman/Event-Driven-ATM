package Bank;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Screen.Screen;

/*
 * The BankSystem class represents the main screen for the bank application.
 */

public class BankSystem extends Screen
{
	private String username;

	private JLabel balanceLabel;
	private JTextField depositField;
	private JTextField withdrawField;
	private JComboBox<String> accountTypeComboBox;

	private Account checkingAccount;
	private Account savingsAccount;
	private Account currentAccount;

	// Constructor
	public BankSystem(String loggedInUsername)
	{
		this.username = loggedInUsername;
		initialize();
		frame.setVisible(true);
	}

	// Initializes the main screen.
	protected void initialize() 
	{
		// Create the accounts
		checkingAccount = new Account(1000);
		savingsAccount = new Account(1000);
		currentAccount = checkingAccount;
		
		// Create the main frame
		frame = createFrame("M's Bank", 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		JPanel panel = createPanel(new BorderLayout(), new Color(44, 62, 80));
		
		// Create the main panel
		JPanel mainPanel = createPanel(panel, new GridLayout(6, 2, 10, 10), BorderFactory.createEmptyBorder(20, 20, 20, 20),  new Color(44, 62, 80));

		// Create the header label
		createLabel(mainPanel, "Welcome to M's Bank", JLabel.CENTER, new Font("Arial", Font.BOLD, 20), Color.WHITE);

		// Create the username label
		createLabel(mainPanel, "Logged In: " + username, JLabel.RIGHT, new Font("Arial", Font.PLAIN, 14), Color.WHITE);

		// Create the balance label
		balanceLabel = createLabel(mainPanel, "Current Balance: $" + currentAccount.getBalance(), JLabel.LEFT, new Font("Arial", Font.PLAIN, 16), new Color(34, 139, 34));
		
		// Add a blank label
		mainPanel.add(new JLabel());
		
		// Create the account type label and combo box
		createLabel(mainPanel, "Account Type:", JLabel.LEFT, new Font("Arial", Font.PLAIN, 14), Color.WHITE);
		accountTypeComboBox = createComboBox(mainPanel, new String[] {"Checking", "Savings"}, this::accountTypeChanged);

		// Create the deposit and withdraw labels and text fields
		createLabel(mainPanel, "Deposit", Color.WHITE);
		depositField = createTextField(mainPanel);
		
		createLabel(mainPanel, "Withdraw", Color.WHITE);
		withdrawField = createTextField(mainPanel);

		// Create the deposit and withdraw buttons
		createButton(mainPanel, "Deposit", new Color(0, 128, 0), true, false, Color.WHITE, this::depositAction);
		createButton(mainPanel, "Withdraw", new Color(178, 34, 34), true, false, Color.WHITE, this::withdrawAction);

		// Prepare the top panel and frame
		panel.add(mainPanel, BorderLayout.CENTER);
		frame.add(panel);
	}

	// Action listener for the deposit button
	private void depositAction(ActionEvent e)
	{
		try
		{
			double depositAmount = Double.parseDouble(depositField.getText());

			if (depositAmount < 0) throw new NumberFormatException();

			currentAccount.deposit(depositAmount);
			updateBalanceLabel();
			JOptionPane.showMessageDialog(frame, "Deposit successful!");
		}
		catch (NumberFormatException exception)
		{
			JOptionPane.showMessageDialog(frame, "Invalid deposit amount. Please enter a valid number.");
		}
		depositField.setText("");
	}

	// Action listener for the withdraw button
	private void withdrawAction(ActionEvent event)
	{
		try
		{
			double withdrawAmount = Double.parseDouble(withdrawField.getText());

			if (withdrawAmount < 0) throw new NumberFormatException();

			if (currentAccount.withdraw(withdrawAmount))
			{
				updateBalanceLabel();
				JOptionPane.showMessageDialog(frame, "Withdrawal successful!");
			}
			else JOptionPane.showMessageDialog(frame, "Insufficient funds!");
		}
		catch (NumberFormatException exception)
		{
			JOptionPane.showMessageDialog(frame, "Invalid withdrawal amount. Please enter a valid number.");
		}
		withdrawField.setText("");
	}

	// Action listener for the account type combo box
	private void accountTypeChanged(ActionEvent event)
	{
		String selectedAccountType = (String) accountTypeComboBox.getSelectedItem();
		if (selectedAccountType.equals("Checking"))
		{
			currentAccount = checkingAccount;
		}
		else if (selectedAccountType.equals("Savings"))
		{
			currentAccount = savingsAccount;
		}
		updateBalanceLabel();
	}

	// Updates the balance label
	private void updateBalanceLabel()
	{
		balanceLabel.setText("Current Balance: $" + currentAccount.getBalance());
	}
}
