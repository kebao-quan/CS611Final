package frontEnd;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import backEnd.Account;
import backEnd.App;

import javax.swing.JLabel;
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
				// check if depo amount is a double
                //TODO put in db
				String accountId = currentUser.getInstance().getAccount();
				String amount = withdrawAmount.getText();
				try {
					Double.parseDouble(amount);
				} catch (NumberFormatException ex) {
					System.out.println("Invalid amount");
					return;
				}
				double amountDouble = Double.parseDouble(amount);
				if (amountDouble <= Account.getTransactionFee()) {
					System.out.println("Invalid amount");
					return;
				}
				App.deposit(accountId, amountDouble);
				System.out.println("Deposited " + amount + " to account " + accountId);
			}
		});
    }
}
