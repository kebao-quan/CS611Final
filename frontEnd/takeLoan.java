/*
 * Allows user to take loan on the account they have chosen
 */
package frontEnd;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import backEnd.App;

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
					JOptionPane.showMessageDialog(null, "Invalid Amount", "Invalid Amount", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				double amountDouble;
				double collatAmmountDouble;
				try {
					amountDouble = Double.parseDouble(amount);
					collatAmmountDouble = Double.parseDouble(collatAmmount);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid Amount", "Invalid Amount", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				if (amountDouble <= 100) {
					JOptionPane.showMessageDialog(null, "Loan Amount Must Be Greater Than 100", "Invalid Amount", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				if (collatAmmountDouble <= 0) {
					JOptionPane.showMessageDialog(null, "Collateral Amount Must Be Greater Than 0", "Invalid Amount", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				if (collatAmmountDouble < amountDouble) {
					JOptionPane.showMessageDialog(null, "Collateral Amount Must Be Greater Than Loan Amount", "Invalid Amount", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				App.loan(accountId, amountDouble, collat, collatAmmountDouble);
				JOptionPane.showMessageDialog(null, "Loan taken for " + amountDouble + " with collateral " + collat + " costing " + collatAmmountDouble, "Took Loan", JOptionPane.INFORMATION_MESSAGE);
			}
		});
    }
}
