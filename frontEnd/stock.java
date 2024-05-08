package frontEnd;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import backEnd.App;
import backEnd.Stock;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class stock extends JFrame {
	private JPanel panel;
	public static DefaultListModel<Stock> listModel = new DefaultListModel<Stock>();
	private JList<Stock> list = new JList<Stock>(listModel);

	public stock() 
    {
		setTitle("Stock");
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
                    mainGUI.stock.setVisible(false);
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
                    mainGUI.stock.setVisible(false);
                    mainGUI.stockList.updateList();
				}
			}
		});

		JLabel owned = new JLabel("Owned Stocks");
		owned.setBounds(0, 50, 200, 50);
		panel.add(owned);

		JScrollPane listStocks = new JScrollPane();
		listStocks.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listStocks.setBounds(0, 100, 950, 500);
		panel.add(listStocks);
		listStocks.setViewportView(list);
    }

	public void updateList()
	{
		List<Stock> userAccounts = App.getStocks(currentUser.getInstance().getAccount());
		listModel.removeAllElements();
		if (userAccounts != null)
		{
			for(Stock val : userAccounts)
				listModel.addElement(val);
		}
	}
}
