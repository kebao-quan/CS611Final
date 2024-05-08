/*
 * Manager view of the list of stocks
 */
package frontEnd;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import backEnd.App;
import backEnd.Stock;
import javax.swing.DefaultListModel;

public class managerStockList extends JFrame {
    
	private JPanel panel;
	public static DefaultListModel<Stock> listModel = new DefaultListModel<Stock>();


	private JList<Stock> list = new JList<Stock>(listModel);

    public managerStockList()
    {
        setTitle("Stock List");
		setSize(1000, 600);
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);

		JLabel title = new JLabel("Bank ATM");
		title.setFont(new Font("Arial", Font.PLAIN, 25));
		title.setBounds(0, 0, 200, 50);
		panel.add(title);
		
        JButton stockList = new JButton("Stock List");
        stockList.setBounds(400, 0, 200, 50);
		panel.add(stockList);

		stockList.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
				if(!mainGUI.managerStockList.isVisible())
				{
					mainGUI.managerStockList.setVisible(true);
				}
                updateList();
			}
		});

        JScrollPane listStocks = new JScrollPane();
		listStocks.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listStocks.setBounds(0, 50, 950, 500);
		panel.add(listStocks);
		listStocks.setViewportView(list);
		updateList();

    }

	public void updateList()
	{
		List<Stock> stockList = App.getStocks();
		listModel.removeAllElements();
		if (stockList != null)
		{
			for(Stock val : stockList)
				listModel.addElement(val);
		}
	}

	
}
