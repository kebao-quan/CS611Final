package frontEnd;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import backEnd.App;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class openAccount extends JFrame {
    
	private JPanel panel;

    public openAccount()
    {
        setTitle("Open Account");
		setSize(1000, 600);
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel("Bank ATM");
		title.setFont(new Font("Arial", Font.PLAIN, 25));
		title.setBounds(0, 0, 200, 50);
		panel.add(title);

        JLabel typeLabel = new JLabel("Account Type");
		typeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		typeLabel.setBounds(400, 100, 100, 50);
		panel.add(typeLabel);

        String[] typeList = {"Checking", "Saving", "Securities"};
		JComboBox<String> typeBox = new JComboBox<String>(typeList);
		typeBox.setBounds(500, 110, 100, 30);
		panel.add(typeBox);
		
        JButton openButton = new JButton("Open");
        openButton.setBounds(400, 300, 100, 30);
		panel.add(openButton);

		openButton.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
                //TODO add to account list/ database
				mainGUI.openAccount.setVisible(false);
				System.out.println("Opening account" + typeBox.getSelectedItem().toString());
				App.createAccount(currentUser.getInstance().getUsername(), typeBox.getSelectedItem().toString(), 0, java.util.Currency.getInstance("USD"));
			}
		});
    }
}
