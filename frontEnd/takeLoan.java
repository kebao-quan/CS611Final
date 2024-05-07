package frontEnd;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import backEnd.Transaction;
import backEnd.App;
import backEnd.LoanTransaction;

public class takeLoan extends JFrame {
	private JPanel panel;

    public takeLoan()
    {
        setTitle("Take Loan");
		setSize(1000, 600);
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel("Bank ATM");
		title.setFont(new Font("Arial", Font.PLAIN, 25));
		title.setBounds(0, 0, 200, 50);
		panel.add(title);

        JLabel loanLabel = new JLabel("Loan Ammount");
		loanLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		loanLabel.setBounds(370, 200, 150, 50);
		panel.add(loanLabel);

		JTextField loanAmmount = new JTextField();
		loanAmmount.setBounds(500, 210, 100, 30);
		panel.add(loanAmmount);
		
        JLabel collatLabel = new JLabel("Collateral");
		collatLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		collatLabel.setBounds(400, 250, 100, 50);
		panel.add(collatLabel);

        JTextField collatName = new JTextField();
		collatName.setBounds(500, 260, 100, 30);
		panel.add(collatName);

        JLabel amountLabel = new JLabel("Cost");
		amountLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		amountLabel.setBounds(400, 300, 100, 50);
		panel.add(amountLabel);

        JTextField collatAmount = new JTextField();
		collatAmount.setBounds(500, 310, 100, 30);
		panel.add(collatAmount);

        JButton loanButton = new JButton("Take Loan");
        loanButton.setBounds(400, 350, 100, 30);
		panel.add(loanButton);

		loanButton.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
				String accountId = currentUser.getInstance().getAccount();

				String amount = loanAmmount.getText();
				String collat = collatName.getText();
				String collatAmmount = collatAmount.getText();

				if (amount.isEmpty() || collat.isEmpty() || collatAmmount.isEmpty()) {
					System.out.println("Invalid amount");
					return;
				}

				double amountDouble;
				double collatAmmountDouble;
				try {
					amountDouble = Double.parseDouble(amount);
					collatAmmountDouble = Double.parseDouble(collatAmmount);
				} catch (NumberFormatException ex) {
					System.out.println("Invalid amount");
					return;
				}

				if (amountDouble <= 100) {
					System.out.println("Loan amount must be greater than 100");
					return;
				}

				if (collatAmmountDouble <= 0) {
					System.out.println("Collateral amount must be greater than 0");
					return;
				}

				if (collatAmmountDouble < amountDouble) {
					System.out.println("Collateral amount must be greater than loan amount");
					return;
				}

				App.loan(accountId, amountDouble, collatAmmount, collatAmmountDouble);
				System.out.println("Loan taken for " + amountDouble + " with collateral " + collat + " costing " + collatAmmountDouble);
			}
		});
    }
}
