package frontEnd;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;

public class allTransaction extends JFrame {
    
	private JPanel panel;
	public static DefaultListModel<String> arr = new DefaultListModel<String>();

    public allTransaction()
    {
        setTitle("All Transaction");
		setSize(1200, 600);
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);

		
		JLabel title = new JLabel("Transaction History");
		title.setFont(new Font("Arial", Font.PLAIN, 25));
		title.setBounds(0, 0, 300, 50);
		panel.add(title);
		
        
		JScrollPane transctionList = new JScrollPane();
		transctionList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		transctionList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		transctionList.setBounds(0, 50, 1150, 500);
		panel.add(transctionList);
		
		// TODO populate both lists, transaction and account
    }
}
