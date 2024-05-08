/*
 * Displays all users in our bank
 */
package frontEnd;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.util.List;

import backEnd.Account;
import backEnd.User;
import backEnd.App;

public class allUsers extends JFrame {
    
	private JPanel panel;
	public static DefaultListModel<User> listModel = new DefaultListModel<User>();
	private JList<User> list = new JList<User>(listModel);
    public allUsers()
    {
        setTitle("All Users");
		setSize(1000, 600);
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);

		
		JLabel title = new JLabel("User List");
		title.setFont(new Font("Arial", Font.PLAIN, 25));
		title.setBounds(0, 0, 300, 50);
		panel.add(title);
		
		JScrollPane listUsers = new JScrollPane();
		listUsers.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listUsers.setBounds(0, 50, 950, 500);
		panel.add(listUsers);
		listUsers.setViewportView(list);
		updateList();
    }
	
	public void updateList()
	{
		List<User> userAccounts = App.getAllUsers();
		listModel.removeAllElements();
		if (userAccounts != null)
		{
			for(User val : userAccounts)
				listModel.addElement(val);
		}
		else
		{
		}
	}
}
