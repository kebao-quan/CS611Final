package frontEnd;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import backEnd.Account;
import backEnd.App;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class deposite extends JFrame {
	private JPanel panel;

    public deposite()
    {
        setTitle("Deposite To Account");
		setSize(1000, 600);
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel("Bank ATM");
		title.setFont(new Font("Arial", Font.PLAIN, 25));
		title.setBounds(0, 0, 200, 50);
		panel.add(title);

        JLabel withdrawLabel = new JLabel("Deposite Amount");
		withdrawLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		withdrawLabel.setBounds(370, 200, 150, 50);
		panel.add(withdrawLabel);

		JTextField withdrawAmount = new JTextField();
		withdrawAmount.setBounds(500, 210, 100, 30);
		panel.add(withdrawAmount);
		
        JButton loanButton = new JButton("Deposite");
        loanButton.setBounds(400, 350, 100, 30);
		panel.add(loanButton);

		loanButton.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
				String accountId = currentUser.getInstance().getAccount();
				String amount = withdrawAmount.getText();
				try {
					Double.parseDouble(amount);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid Amount", "Invalid Amount", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				double amountDouble = Double.parseDouble(amount);
				if (amountDouble <= Account.getTransactionFee()) {
					JOptionPane.showMessageDialog(null, "Invalid Amount", "Invalid Amount", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				App.deposit(accountId, amountDouble);
                JOptionPane.showMessageDialog(null, "Deposited " + amount + " to account " + accountId, "Deposited", JOptionPane.INFORMATION_MESSAGE);
			}
		});
    }
}
