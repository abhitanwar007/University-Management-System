package university.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class StudentLeave extends JFrame implements ActionListener{
	Choice crollno, ctime;
	JDateChooser dcdate;
	JButton submit, cancel;
	
	StudentLeave() {
		setLayout(null);
		setSize(900,700);
		setLocation(250, 10);
		
		getContentPane().setBackground(Color.WHITE);
		
		JLabel heading = new JLabel("Apply leave(Student)");
		heading.setBounds(40,50,300,30);
		heading.setFont(new Font("Tahoma",Font.BOLD,20));
		add(heading);
		
		JLabel lblrollno = new JLabel("Search By Roll Number");
		lblrollno.setBounds(60,100,300,20);
		lblrollno.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(lblrollno);
		
		crollno = new Choice();
		crollno.setBounds(60, 130, 200, 20);
		add(crollno);
		
		try {
			Conn c = new Conn();
			ResultSet res = c.stmt.executeQuery("select * from student");
			while(res.next()) {
				crollno.add(res.getString("rollno"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel lbldate = new JLabel("Date");
		lbldate.setBounds(60,180,200,20);
		lbldate.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(lbldate);
		
		dcdate = new JDateChooser();
		dcdate.setBounds(60, 210, 200, 25);
		add(dcdate);
		
		JLabel lbltime = new JLabel("Time Duration");
		lbltime.setBounds(60,270,300,20);
		lbltime.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(lbltime);
		
		ctime = new Choice();
		ctime.setBounds(60, 300, 200, 20);
		ctime.add("Full Day");
		ctime.add("Half Day");
		add(ctime);
		
		submit = new JButton("Submit");
		submit.setBounds(60,350,100,30);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.white);
		submit.setFont(new Font("Raleway", Font.BOLD,15));
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(200,350,100,30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Raleway", Font.BOLD,15));
		cancel.addActionListener(this);
		add(cancel);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==submit) {
			String rollno=crollno.getSelectedItem();
			String date = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
			String duration = ctime.getSelectedItem();
			
			String query = "insert into studentleave values('"+rollno+"','"+date+"','"+duration+"')";
			try {
				Conn c = new Conn();
				c.stmt.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Leave Applied");
				setVisible(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new StudentLeave();
	}
}
