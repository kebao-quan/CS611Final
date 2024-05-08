package frontEnd;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import backEnd.App;
public class profit extends JFrame {
	private JPanel panel;

	public profit() 
    {
		setTitle("Profit");
		setSize(1000, 600);
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel title = new JLabel("Bank ATM");
		title.setFont(new Font("Arial", Font.PLAIN, 25));
		title.setBounds(0, 0, 200, 50);
		panel.add(title);
		

        JLabel profitLabel = new JLabel("Your Profit");
        profitLabel.setBounds(400, 200, 200, 50);
		panel.add(profitLabel);
        
        JLabel userProfit = new JLabel();
        userProfit.setBounds(500, 210, 200, 50);
		panel.add(userProfit);

        // calculate profit and set it
        userProfit.setText("SET PROFIT HERE");
    }
}
