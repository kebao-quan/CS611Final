/*
 * Main login UI
 */
package frontEnd;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import backEnd.App;
import backEnd.User;

public class Login {

	public JFrame frame;
	private JTextField usernameText;
	private JPasswordField passwordText;

	public Login() 
    {
		frame = new JFrame();
		frame.setSize(1000, 600);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel title = new JLabel("Bank ATM");
		title.setFont(new Font("Arial", Font.PLAIN, 25));
		title.setBounds(0, 0, 200, 50);
		frame.getContentPane().add(title);
		
		JLabel loginLabel = new JLabel("Login");
		loginLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		loginLabel.setBounds(400, 100, 100, 50);
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
		

		JButton loginButton = new JButton("Login");
        loginButton.setBounds(400, 300, 100, 30);
		frame.getContentPane().add(loginButton);
		loginButton.addActionListener(new ActionListener() 
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

                
				if ((username.equalsIgnoreCase("manager") && (password.equalsIgnoreCase("manager"))))
                {
                    frame.setVisible(false);
                    mainGUI.managerMenu.setVisible(true);
					return;
                }
				User user = App.getUserValidate(username, password);
				currentUser.getInstance().setUsername(username);

                if (user != null)
                {
                    frame.setVisible(false);
                    mainGUI.userMenu.setVisible(true);
                }
				else
				{
        			JOptionPane.showMessageDialog(null, "Login Failed. Invalid Username/Password", "Login Failed", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});


		JButton register = new JButton("Register");
        register.setBounds(400, 350, 100, 30);
		frame.getContentPane().add(register);

		register.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
            {
				if(!mainGUI.register.frame.isVisible())
				{
					mainGUI.register.frame.setVisible(true);
                    frame.setVisible(false);
				}
			}
		});
		
		
	}
}