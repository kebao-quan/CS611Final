package frontEnd;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import backEnd.InsufficientFundsException;
import backEnd.Transaction;
import backEnd.WithdrawalTransaction;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class withdraw extends JFrame {
	private JPanel panel;

    public withdraw()
    {
        setTitle("Withdraw From Account");
		setSize(1000, 600);
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel("Bank ATM");
		title.setFont(new Font("Arial", Font.PLAIN, 25));
		title.setBounds(0, 0, 200, 50);
		panel.add(title);

        JLabel withdrawLabel = new JLabel("Withdraw Amount");
		withdrawLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		withdrawLabel.setBounds(370, 200, 150, 50);
		panel.add(withdrawLabel);

		JTextField withdrawAmount = new JTextField();
		withdrawAmount.setBounds(500, 210, 100, 30);
		panel.add(withdrawAmount);
		
        JButton loanButton = new JButton("Withdraw");
        loanButton.setBounds(400, 350, 100, 30);
		panel.add(loanButton);

		loanButton.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
				// check if withdraw amount is a number
				String accountId = currentUser.getInstance().getAccount();
				String amount = withdrawAmount.getText();
				try {
					double amountDouble = Double.parseDouble(amount);
					Transaction transaction = new WithdrawalTransaction(accountId, amountDouble);
					transaction.execute();
					System.out.println("Withdrawn " + amountDouble + " from account " + accountId);
				} catch (NumberFormatException ex) {
					System.out.println("Invalid amount");
					return;
				} catch (InsufficientFundsException ex) {
					System.out.println("Insufficient funds");
					return;
				}

			}
		});
    }
}
