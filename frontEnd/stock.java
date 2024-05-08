package frontEnd;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class stock extends JFrame {
	private JPanel panel;

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
        stockList.setBounds(200, 0, 200, 50);
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
    }
}
