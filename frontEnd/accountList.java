/*
 * Displays a list of all the accounts that the current user owns.
 */
package frontEnd;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import backEnd.App;
import backEnd.Account;
import javax.swing.DefaultListModel;

public class accountList extends JFrame {
    
	private JPanel panel;
	public static DefaultListModel<Account> listModel = new DefaultListModel<Account>();


	private JList<Account> list = new JList<Account>(listModel);

    public accountList()
    {
        setTitle("Account List");
		setSize(1000, 600);
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel title = new JLabel("Bank ATM");
		title.setFont(new Font("Arial", Font.PLAIN, 25));
		title.setBounds(0, 0, 200, 50);
		panel.add(title);

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
				}
				updateList();
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

		JButton select = new JButton("Details");
		select.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				if (list != null)
				{
					System.out.println(list.getSelectedValue());
					if (list.getSelectedValue() != null)
					{
						currentUser.getInstance().setAccount(list.getSelectedValue().getAccountId());
						System.out.println("Selected Account: " + currentUser.getInstance().getAccount());
						mainGUI.accountList.setVisible(false);
						mainGUI.accountDetails.setVisible(true);
						mainGUI.accountDetails.update();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Select an account", "No Selected Account", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No Available Accounts", "No Accounts", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		select.setBounds(800, 0, 200, 50);
		panel.add(select);
		// for displaying list of account
		JScrollPane listAccount = new JScrollPane();
		listAccount.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listAccount.setBounds(0, 50, 950, 500);
		panel.add(listAccount);
		listAccount.setViewportView(list);

    }

	public void updateList()
	{
		// for fetching updating our user list		
		String username = currentUser.getInstance().getUsername();
		List<Account> userAccounts = App.getAccounts(username);
		listModel.removeAllElements();
		if (userAccounts != null)
		{
			for(Account val : userAccounts)
				listModel.addElement(val);
		}
		else
		{
			System.out.println(username + " username");
		}
	}

	
}
