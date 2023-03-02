import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class demo implements ActionListener{
   
	static JButton login;
	static JButton forgotPassword;
	static JTextField textField;
	static JPasswordField passwordField;
	static JFrame frame;
	
	public static void main(String[] args) {
		
		  
		frame = new JFrame();
		JPanel panel = new JPanel();
		ImageIcon icon = new 
ImageIcon("Graphicloads-Colorful-Long-Shadow-User.64.png");

		//so that components like label can be put specific x,y 
coordinates
		panel.setLayout(null);


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(380,400);


		JLabel label = new JLabel("User");
		label.setBounds(75,40,80,25);

		textField = new JTextField(30);
		textField.setBounds(150,40,120,25);

		JLabel label2 = new JLabel("Password");
		label2.setBounds(75,80,80,25);


		passwordField = new JPasswordField();
		passwordField.setBounds(150,80,120,25);

		login = new JButton();
		login.setText("Login");
		login.setBounds(75,120,70,25);
		login.setFont(new Font("Sanserif",Font.ITALIC,10));

		forgotPassword = new JButton("Forgot Password");
		forgotPassword.setBounds(150,120,120,25);
		forgotPassword.setFont(new 
Font("Sanserif",Font.ITALIC,10));

		//disable the forgot password button because lets give the 
user a try
		forgotPassword.setEnabled(false);

		/*
		This is good when you have multiple buttons. We are using 
this method in the inner class
		We could have passed the word this in the constructor if 
we were declaring our buttons in the constructor
		because the word this belongs to the class that 
instantiated the object.
		And we can use the below method instead of the 
actionPerformed method that will be triggered when a button is clicked
		 */

		
		 

		//but another way to do it is the below one
		
		 
	  login.addActionListener(new demo () {
			public void actionPerformed(ActionEvent e) {
				loginButton(textField, passwordField, 
login, forgotPassword,frame);
			}
		});
		 

		//The best one to use is the below one. The below one uses 
lambda expression

	//	login.addActionListener(e -> loginButton(textField, 
passwordField, login, forgotPassword,frame));
	  
	  //if user clicks the forgotpassword button, make the rest of the 
fields to be editable or enabled
		forgotPassword.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				textField.setEditable(true);
				passwordField.setEditable(true);
				login.setEnabled(true);

			}
		});

		//add the labels to the panel and panels to the frame
		panel.add(label);
		panel.add(textField);
		panel.add(label2);
		panel.add(passwordField);
		panel.add(login);
		panel.add(forgotPassword);
		frame.add(panel);
		frame.setVisible(true);

	}

	//the below method will be triggered when a button is clicked
	//can also use this instead of using the one in the class

	@Override
	public  void actionPerformed(ActionEvent e) {
	}
	
	/*
	public  void actionPerformed(ActionEvent e) {
	
		//check if the button clicked is the login button 
		if(e.getSource() == login) 

			//call loginButton method and pass the static 
objects
			loginButton(textField, passwordField, login, 
forgotPassword,frame);

		//check if forgotPassword button was clicked
//		else if( e.getSource() == forgotPassword) {
//			textField.setEditable(true);
//			passwordField.setEditable(true);
//			login.setEnabled(true);
//		}
	}
	*/
	public static void loginButton(JTextField textField, 
JPasswordField passwordField, JButton login, JButton forgotPassword, 
JFrame frame) {
		String username = textField.getText();
		String password = passwordField.getText();
		int choice = 0;

		//user successfully logins
		if(username.equals("mohaa204080") && 
password.equals("12345"))
			JOptionPane.showMessageDialog(null, "You 
succesfully logged in","Succesful login",JOptionPane.INFORMATION_MESSAGE);

		else
			//store the returned option (0 for YES and 1 for 
NO
			choice =  
JOptionPane.showConfirmDialog(null,"Login Again", "Login Failed", 
JOptionPane.ERROR_MESSAGE , JOptionPane.YES_NO_OPTION);

		//user clicked on YES
		if(choice == 0) {
			//forgot password will be enabled if user login 
fails
			forgotPassword.setEnabled(true);

			//set the text and password to be empty
			textField.setText(null);
			passwordField.setText(null);

		}
		//user clicked on NO and doesn't want to login again
		else if(choice == 1) {
			// frame.dispose();

			//can dispose the frame as in the above meaning 
exit out of the window or use the below
			//set methods
			//set the text and password to be empty
			textField.setText(null);
			passwordField.setText(null);

			//disable the text and password fields
			textField.setEditable(false);
			passwordField.setEditable(false);

			//login button will be disabled because the user 
doesn't want to login again
			login.setEnabled(false);
			
			//if user clicks on no, set the forgotPassword to 
be true and thats the only field that can be clicked
			forgotPassword.setEnabled(true);
		}



	}

}

