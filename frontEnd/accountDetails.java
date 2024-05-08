/*
 * Displays all information and neccessary buttons regarding a chosen account of the current user
 */
package frontEnd;

import javax.swing.JFrame;
import javax.swing.JPanel;

import backEnd.App;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class accountDetails extends JFrame {
	private JPanel panel;
    private JButton stockButton = new JButton("Stock");
    private JButton loanButton = new JButton("Take Loan");

	public accountDetails() 
    {
		setTitle("Account Details");
		setSize(1000, 600);
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel title = new JLabel("Bank ATM");
		title.setFont(new Font("Arial", Font.PLAIN, 25));
		title.setBounds(0, 0, 200, 50);
		panel.add(title);
		
        JButton accountList = new JButton("Account Details");
        accountList.setBounds(200, 0, 200, 50);
		panel.add(accountList);

		accountList.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
				if(!mainGUI.accountList.isVisible())
				{
					mainGUI.accountList.setVisible(true);
                    mainGUI.accountDetails.setVisible(false);
                    mainGUI.accountList.updateList();
				}
			}
		});
		
        JButton deposite = new JButton("Deposit");
        deposite.setBounds(400, 0, 200, 50);
		panel.add(deposite);

		deposite.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
				if(!mainGUI.deposite.isVisible())
				{
					mainGUI.deposite.setVisible(true);
				}
			}
		});

        JButton withdraw = new JButton("Withdraw");
        withdraw.setBounds(600, 0, 200, 50);
		panel.add(withdraw);

		withdraw.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
				if(!mainGUI.withdraw.isVisible())
				{
					mainGUI.withdraw.setVisible(true);
				}
			}
		});

        JButton closeAccount = new JButton("Close Account");
        closeAccount.setBounds(0, 510, 200, 50);
		panel.add(closeAccount);

		closeAccount.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
                mainGUI.userMenu.setVisible(true);
                String accountId = currentUser.getInstance().getAccount();
				App.closeAccount(accountId);
			}
		});

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

        stockButton.setBounds(800, 0, 200, 50);
		panel.add(stockButton);

		stockButton.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
				if(!mainGUI.stock.isVisible())
				{
					mainGUI.stock.setVisible(true);
                    mainGUI.accountDetails.setVisible(false);
                    mainGUI.stock.updateList();
				}
			}
		});
	}
    public void update()
    {
        currentUser user = currentUser.getInstance();
		String accountType = App.getAccount(user.getAccount()).getAccountType();
        if (accountType.equals("Securities"))
        {
            stockButton.setVisible(true);
            loanButton.setVisible(false);
        }
        else
        {
            stockButton.setVisible(false);
            loanButton.setVisible(true);        
        }
    }
        
}
