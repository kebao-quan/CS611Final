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
import backEnd.Stock;
import javax.swing.DefaultListModel;

public class stockList extends JFrame {
    
	private JPanel panel;
	public static DefaultListModel<Stock> listModel = new DefaultListModel<Stock>();


	private JList<Stock> list = new JList<Stock>(listModel);

    public stockList()
    {
        setTitle("Stock List");
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
                    mainGUI.stockList.setVisible(false);
                    mainGUI.accountList.updateList();
				}
			}
		});
		
        JButton stockList = new JButton("Stock List");
        stockList.setBounds(400, 0, 200, 50);
		panel.add(stockList);

		stockList.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
				if(!mainGUI.stockList.isVisible())
				{
					mainGUI.stockList.setVisible(true);
				}
                updateList();
			}
		});

        JButton backButton = new JButton("Back");
        backButton.setBounds(800, 0, 200, 50);
		panel.add(backButton);

		backButton.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
				if(!mainGUI.stock.isVisible())
				{
					mainGUI.stock.setVisible(true);
                    mainGUI.stockList.setVisible(false);

				}
                mainGUI.stock.updateList();
			}
		});

		JButton select = new JButton("Invest");
		select.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				if (list != null)
				{
					System.out.println(list.getSelectedValue());
					if (list.getSelectedValue() != null)
					{
						currentUser.getInstance().setStock((list.getSelectedValue()));
						System.out.println("Selected Stock: " + currentUser.getInstance().getStock());
						mainGUI.invest.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Select a stock", "No Selected Stock", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No Available Accounts", "No Accounts", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		select.setBounds(600, 0, 200, 50);
		panel.add(select);

        JScrollPane listStocks = new JScrollPane();
		listStocks.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listStocks.setBounds(0, 50, 950, 500);
		panel.add(listStocks);
		listStocks.setViewportView(list);
		updateList();

    }

	public void updateList()
	{
		List<Stock> userAccounts = App.getStocks();
		listModel.removeAllElements();
		if (userAccounts != null)
		{
			for(Stock val : userAccounts)
				listModel.addElement(val);
		}
	}

	
}
