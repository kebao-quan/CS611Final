/*
 * Shows the transaction history for our user
 */
package frontEnd;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import backEnd.App;
import backEnd.Transaction;

import java.awt.Font;
import java.util.List;

public class transactionHistory extends JFrame {
    
	private JPanel panel;
	public static DefaultListModel<Transaction> listModel = new DefaultListModel<Transaction>();
	private JList<Transaction> list = new JList<Transaction>(listModel);

    public transactionHistory()
    {
        setTitle("Transaction History");
		setSize(1000, 600);
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);

		
		JLabel title = new JLabel("Transaction History");
		title.setFont(new Font("Arial", Font.PLAIN, 25));
		title.setBounds(0, 0, 300, 50);
		panel.add(title);
		
		JScrollPane listTrans = new JScrollPane();
		listTrans.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listTrans.setBounds(0, 50, 950, 500);
		panel.add(listTrans);
		listTrans.setViewportView(list);
    }

	public void updateList()
	{
		List<Transaction> userAccounts = App.getUserTransactions(currentUser.getInstance().getUsername());
		listModel.removeAllElements();
		if (userAccounts != null)
		{
			for(Transaction val : userAccounts)
				listModel.addElement(val);
		}
	}
}
