package frontEnd;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import backEnd.App;
import backEnd.Account;
import backEnd.InsufficientFundsException;


public class openAccount extends JFrame {
    
	private JPanel panel;

    public openAccount()
    {
        setTitle("Open Account");
		setSize(1000, 600);
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel("Bank ATM");
		title.setFont(new Font("Arial", Font.PLAIN, 25));
		title.setBounds(0, 0, 200, 50);
		panel.add(title);

        JLabel typeLabel = new JLabel("Account Type");
		typeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		typeLabel.setBounds(400, 100, 100, 50);
		panel.add(typeLabel);

        String[] typeList = {"Checking", "Saving", "Securities"};
		JComboBox<String> typeBox = new JComboBox<String>(typeList);
		typeBox.setBounds(500, 110, 100, 30);
		panel.add(typeBox);
		
        JButton openButton = new JButton("Open");
        openButton.setBounds(400, 300, 100, 30);
		panel.add(openButton);

		openButton.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
				mainGUI.openAccount.setVisible(false);

				String accountType = (String) typeBox.getSelectedItem();
				if (accountType.equals("Securities")) {
					List<Account> accounts = App.getAccounts(currentUser.getInstance().getUsername());
					for (Account account : accounts) {
						if (account.getBalance() >= 1000) {
							String securityAccountId = App.createAccount(currentUser.getInstance().getUsername(), accountType, 0, java.util.Currency.getInstance("USD"));
							try {
								App.transfer(account.getAccountId(), securityAccountId, 1000);
							} catch ( InsufficientFundsException ex) {
								System.out.println("Insufficient funds");
							}
							return;
						}
					}
					JOptionPane.showMessageDialog(null, "Do not have an Account that meets the requirements(Balance >= 1000) to open a Securities Account.", "Invalid", JOptionPane.INFORMATION_MESSAGE);
					System.out.println("Do not have an Account that meets the requirements(Balance >= 1000) to open a Securities Account.");
				} else {
					App.createAccount(currentUser.getInstance().getUsername(), accountType, 0, java.util.Currency.getInstance("USD"));
				}
			}
		});
    }
}
