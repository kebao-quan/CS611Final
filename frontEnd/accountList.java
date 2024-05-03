package frontEnd;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultListModel;

public class accountList extends JFrame {
    
	private JPanel panel;
	public static DefaultListModel<String> arr = new DefaultListModel<String>();

    public accountList()
    {
        setTitle("Account List");
		setSize(1000, 600);
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		
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

		JScrollPane listAccount = new JScrollPane();
		listAccount.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listAccount.setBounds(0, 50, 950, 500);
		panel.add(listAccount);
		
		
    }
}
