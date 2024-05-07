package frontEnd;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class takeLoan extends JFrame {
	private JPanel panel;

    public takeLoan()
    {
        setTitle("Take Loan");
		setSize(1200, 600);
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel("Bank ATM");
		title.setFont(new Font("Arial", Font.PLAIN, 25));
		title.setBounds(0, 0, 200, 50);
		panel.add(title);

        JLabel loanLabel = new JLabel("Loan Ammount");
		loanLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		loanLabel.setBounds(370, 200, 150, 50);
		panel.add(loanLabel);

		JTextField loanAmmount = new JTextField();
		loanAmmount.setBounds(500, 210, 100, 30);
		panel.add(loanAmmount);
		
        JLabel collatLabel = new JLabel("Collateral");
		collatLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		collatLabel.setBounds(400, 250, 100, 50);
		panel.add(collatLabel);

        JTextField collatName = new JTextField();
		collatName.setBounds(500, 260, 100, 30);
		panel.add(collatName);
        
        JTextField collatAmount = new JTextField();
		collatAmount.setBounds(600, 260, 100, 30);
		panel.add(collatAmount);

        JButton loanButton = new JButton("Take Loan");
        loanButton.setBounds(400, 300, 100, 30);
		panel.add(loanButton);

		loanButton.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
                //TODO loan db, also need to check if colat amount > loan ammount
			}
		});
    }
}
