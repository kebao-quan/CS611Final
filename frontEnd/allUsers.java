package frontEnd;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;

public class allUsers extends JFrame {
    
	private JPanel panel;
	public static DefaultListModel<String> arr = new DefaultListModel<String>();

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
		
		JScrollPane transctionList = new JScrollPane();
		transctionList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		transctionList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		transctionList.setBounds(0, 50, 950, 500);
		panel.add(transctionList);
		
		// TODO populate list
    }
}