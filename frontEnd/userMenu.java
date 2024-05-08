package frontEnd;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class userMenu extends JFrame {
	private JPanel panel;

	public userMenu() 
    {
		setTitle("Menu");
		setSize(1000, 600);
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel title = new JLabel("Bank ATM");
		title.setFont(new Font("Arial", Font.PLAIN, 25));
		title.setBounds(0, 0, 200, 50);
		panel.add(title);
		
		// populate transaction history, all users, all transaction list, allTransactions.java, allUsers.java, transactionHistory.java
		// securities account insides, accountDetails.java
        // TODO close account
        // TODO stocks, accountDetails.java to check what account type the user has, stock.java for rest
			// currencies?

		// manager side 
		// manger needs to add stock
		// user needs to see stock list
        
        JButton accountList = new JButton("Account List");
        accountList.setBounds(200, 0, 200, 50);
		panel.add(accountList);

		accountList.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
				if(!mainGUI.accountList.isVisible())
				{
					mainGUI.accountList.setVisible(true);
					mainGUI.accountList.updateList();
                    mainGUI.userMenu.setVisible(false);
				}

			}
		});
		
        JButton transactionHistory = new JButton("Transaction History");
        transactionHistory.setBounds(400, 0, 200, 50);
		panel.add(transactionHistory);

		transactionHistory.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
				if(!mainGUI.transactionHistory.isVisible())
				{
					mainGUI.transactionHistory.setVisible(true);
					mainGUI.transactionHistory.updateList();
				}
			}
		});

        JButton openAccount = new JButton("Open Account");
        openAccount.setBounds(600, 0, 200, 50);
		panel.add(openAccount);

		openAccount.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
				if(!mainGUI.openAccount.isVisible())
				{
					mainGUI.openAccount.setVisible(true);
				}
			}
		});


	}
}
