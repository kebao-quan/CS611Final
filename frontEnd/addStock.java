/*
 * Allows the ability to add a new stock to the market
 */
package frontEnd;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import backEnd.App;


public class addStock extends JFrame {
    
	private JPanel panel;

    public addStock()
    {
        setTitle("Add Stock");
		setSize(1000, 600);
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel("Bank ATM");
		title.setFont(new Font("Arial", Font.PLAIN, 25));
		title.setBounds(0, 0, 200, 50);
		panel.add(title);

        JLabel nameLabel = new JLabel("Stock name:");
		nameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		nameLabel.setBounds(400, 200, 100, 50);
		panel.add(nameLabel);
		
        JTextField nameText = new JTextField();
		nameText.setBounds(500, 210, 100, 30);
		panel.add(nameText);

		JLabel stockPrice = new JLabel("Stock Price:");
		stockPrice.setFont(new Font("Arial", Font.PLAIN, 15));
		stockPrice.setBounds(400, 250, 100, 50);
		panel.add(stockPrice);
		
        JTextField enteredPrice = new JTextField();
		enteredPrice.setBounds(500, 260, 100, 30);
		panel.add(enteredPrice);
		
		JLabel stockSymbol = new JLabel("Stock Symbol:");
		stockSymbol.setFont(new Font("Arial", Font.PLAIN, 15));
		stockSymbol.setBounds(400, 300, 100, 50);
		panel.add(stockSymbol);
		
        JTextField symbol = new JTextField();
		symbol.setBounds(500, 310, 100, 30);
		panel.add(symbol);

		JButton addButton = new JButton("Add");
        addButton.setBounds(400, 350, 100, 30);
		panel.add(addButton);

		addButton.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
				mainGUI.addStock.setVisible(false);

				String name = nameText.getText();
				String price = enteredPrice.getText();
				String stockSymbol = symbol.getText();
				try {
					Double.parseDouble(price);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid Price", "Invalid Price", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				App.addStock(stockSymbol, name, Double.parseDouble(price));;
			}
		});
    }
}
