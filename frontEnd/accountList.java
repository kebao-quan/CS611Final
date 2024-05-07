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
import backEnd.User;
import backEnd.Account;
import javax.swing.DefaultListModel;

public class accountList extends JFrame {
    
	private JPanel panel;
	public static DefaultListModel<Account> listModel;
	private JList<Account> list;

    public accountList()
    {
        setTitle("Account List");
		setSize(1200, 600);
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

        JButton loanButton = new JButton("Take Loan");
        loanButton.setBounds(800, 0, 200, 50);
		panel.add(loanButton);

		loanButton.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
				if(!mainGUI.takeLoan.isVisible())
				{
					mainGUI.takeLoan.setVisible(true);
				}
			}
		});


		JButton select = new JButton("Details");
		select.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				if (list != null)
				{
					JOptionPane.showConfirmDialog(panel, "You Selected : " + list.getSelectedValue(), "Display",
					JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No Available Accounts", "No Accounts", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		select.setBounds(1000, 0, 200, 50);
		panel.add(select);
    }

	public void updateList()
	{
		listModel = new DefaultListModel<Account>();
		// for displaying list of account
		JScrollPane listAccount = new JScrollPane();
		listAccount.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listAccount.setBounds(0, 50, 950, 500);
		panel.add(listAccount);
		String username = currentUser.getInstance().getUsername();
		
		List<Account> userAccounts = App.getAccounts(username);

		
		if (userAccounts != null)
		{
			System.out.println(username);
			System.out.println("num of accounts: " + userAccounts.size());
			for(Account val : userAccounts)
			listModel.addElement(val);
		
			list = new JList<Account>(listModel);

			listAccount.setViewportView(list);
		}
		else
		{
			System.out.println(username + " username");
		}
	}

	
}
