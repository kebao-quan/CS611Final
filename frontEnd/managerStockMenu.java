package frontEnd;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class managerStockMenu extends JFrame {
	private JPanel panel;

	public managerStockMenu() 
    {
		setTitle("Stock");
		setSize(1000, 600);
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        currentUser user = currentUser.getInstance();

		JLabel title = new JLabel("Bank ATM");
		title.setFont(new Font("Arial", Font.PLAIN, 25));
		title.setBounds(0, 0, 200, 50);
		panel.add(title);
		
        JButton stockList = new JButton("Stock List");
        stockList.setBounds(200, 0, 200, 50);
		panel.add(stockList);

		stockList.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
				if(!mainGUI.managerStockList.isVisible())
				{
					mainGUI.managerStockList.setVisible(true);
					mainGUI.managerStockList.updateList();
				}
			}
		});
		
        JButton addStock = new JButton("Add Stock");
        addStock.setBounds(400, 0, 200, 50);
		panel.add(addStock);
		addStock.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
				if(!mainGUI.addStock.isVisible())
				{
					mainGUI.addStock.setVisible(true);
				}
			}
		});
    }
}
