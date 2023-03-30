package university.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	JButton login , cancel;
	JTextField tfusername , tfpassword;
	
	Login(){
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel username = new JLabel("UserName:");
		username.setBounds(40,20,100,20);
		add(username);
		
		tfusername = new JTextField();
		tfusername.setBounds(150, 20, 150, 20);
		add(tfusername);
		
		JLabel password = new JLabel("Password:");
		password.setBounds(40,70,100,20);
		add(password);
		
		tfpassword = new JPasswordField();
		tfpassword.setBounds(150, 70, 150, 20);
		add(tfpassword);
		
		login = new JButton("Login");
		login.setBounds(40,120,120,30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.white);
		login.setFont(new Font("Raleway", Font.BOLD,15));
		login.addActionListener(this);
		add(login);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(180,120,120,30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Raleway", Font.BOLD,15));
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 0, 200, 200);
		add(image);
		
		setSize(600,300);
		setLocation(400,200);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==login) {
			String username = tfusername.getText();
			String password = tfpassword.getText();
			
			String query ="Select * from login where username='"+username+"' and password='"+password+"'";
			
			try {
				Conn c=new Conn();
				ResultSet rs = c.stmt.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Project();
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect username or password");
					setVisible(false);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(ae.getSource()==cancel) {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new Login();
	}
}
