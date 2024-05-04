package frontEnd;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class register {

	public JFrame frame;
	private JTextField usernameText;
	private JPasswordField passwordText;

	public register() 
    {
		frame = new JFrame();
		frame.setSize(1000, 600);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel title = new JLabel("Bank ATM");
		title.setFont(new Font("Arial", Font.PLAIN, 25));
		title.setBounds(0, 0, 200, 50);
		frame.getContentPane().add(title);
		
		JLabel loginLabel = new JLabel("Register Account");
		loginLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		loginLabel.setBounds(400, 100, 200, 50);
		frame.getContentPane().add(loginLabel);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		usernameLabel.setBounds(400, 200, 100, 50);
		frame.getContentPane().add(usernameLabel);
		
        usernameText = new JTextField();
		usernameText.setBounds(500, 210, 100, 30);
		frame.getContentPane().add(usernameText);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		passwordLabel.setBounds(400, 250, 100, 50);
		frame.getContentPane().add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(500, 260, 100, 30);
		frame.getContentPane().add(passwordText);
		passwordText.setColumns(10);
		

		JButton registerButton = new JButton("Register");
        registerButton.setBounds(400, 300, 100, 30);
		frame.getContentPane().add(registerButton);
		registerButton.addActionListener(new ActionListener() 
        {    
			public void actionPerformed(ActionEvent e) 
            {
				String username = usernameText.getText();
				char[] passChar = passwordText.getPassword();

                // converting password char[] to a string
                StringBuilder sb = new StringBuilder();
                for (Character ch : passChar) {
                    sb.append(ch);
                }
                String password = sb.toString();

                
				if ((username.equalsIgnoreCase("manager")))
                {
                    // TODO display cant register as manager
                }
				else
				{
                    // TODO register a new user 
				}
			}
		});
	}
}