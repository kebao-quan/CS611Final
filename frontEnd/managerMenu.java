package frontEnd;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class managerMenu extends JFrame {
	private JPanel panel;

	public managerMenu() 
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
		

        // TODO manager
        
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
                    mainGUI.managerMenu.setVisible(false);					
				}
			}
		});

		JButton dailyTransaction = new JButton("Daily Transaction");
        dailyTransaction.setBounds(400, 0, 200, 50);
		panel.add(dailyTransaction);

		dailyTransaction.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
				if(!mainGUI.allTransaction.isVisible())
				{
					mainGUI.allTransaction.setVisible(true);
                    mainGUI.managerMenu.setVisible(false);					
				}
			}
		});

		JButton userList = new JButton("User List");
        userList.setBounds(600, 0, 200, 50);
		panel.add(userList);

		userList.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
				if(!mainGUI.allUsers.isVisible())
				{
					mainGUI.allUsers.setVisible(true);
                    mainGUI.managerMenu.setVisible(false);					
				}
			}
		});
	}
}
