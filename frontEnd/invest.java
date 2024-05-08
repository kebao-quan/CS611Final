package frontEnd;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import backEnd.App;
import backEnd.InsufficientFundsException;
import backEnd.Transaction;
import backEnd.WithdrawalTransaction;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import backEnd.Stock;

public class invest extends JFrame {
	private JPanel panel;

    public invest()
    {
        setTitle("Invest to");
		setSize(1000, 600);
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel("Bank ATM");
		title.setFont(new Font("Arial", Font.PLAIN, 25));
		title.setBounds(0, 0, 200, 50);
		panel.add(title);

        JLabel investLabel = new JLabel("Invest Amount");
		investLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		investLabel.setBounds(370, 200, 150, 50);
		panel.add(investLabel);

		JTextField investAmount = new JTextField();
		investAmount.setBounds(500, 210, 100, 30);
		panel.add(investAmount);
		
        JButton investButton = new JButton("Invest");
        investButton.setBounds(400, 350, 100, 30);
		panel.add(investButton);

		investButton.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
				// gets stock
                Stock stock = currentUser.getInstance().getStock();
				String quantityString = investAmount.getText();
				try {
					Integer.parseInt(quantityString);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid Amount", "Invalid Amount", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				int quantity = Integer.parseInt(quantityString);
				if (quantity <= 0) {
					JOptionPane.showMessageDialog(null, "Invalid Amount", "Invalid Amount", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				String accountId = currentUser.getInstance().getAccount();
				try {
					App.accountBuyStock(accountId, stock, quantity);
				} catch (InsufficientFundsException ex) {
					JOptionPane.showMessageDialog(null, "Insufficient Funds", "Insufficient Funds", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
                // lets user invest in a stock
                // check if invest amount is right
			}
		});
    }
}
