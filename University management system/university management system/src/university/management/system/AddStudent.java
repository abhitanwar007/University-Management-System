package university.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class AddStudent extends JFrame implements ActionListener{
	JTextField tfname, tffname ,tfaddress,tfphone,tfemail,tfx,tfxii,tfaadhar ;
	JLabel labelrollno;
	JDateChooser dcdob;
	JComboBox cbcourse, cbbranch;
	JButton submit, cancel;
	
	Random ran = new Random();
	long first4 = Math.abs((ran.nextLong() % 9000L)+1000L);

	
	AddStudent() {
		
		setSize(900,600);
		setLocation(300,10);
		
		setLayout(null);
		
		JLabel heading = new JLabel("New Student Details");
		heading.setBounds(300,30,500,50);
		heading.setFont(new Font("serif",Font.BOLD,30));
		add(heading);
		
		JLabel name = new JLabel("Name");
		name.setBounds(50,100,200,30);
		name.setFont(new Font("serif",Font.BOLD,20));
		add(name);
		
		tfname = new JTextField();
		tfname.setBounds(200,100,150,30);
		add(tfname);
		
		JLabel fname = new JLabel("Father's Name");
		fname.setBounds(400,100,200,30);
		fname.setFont(new Font("serif",Font.BOLD,20));
		add(fname);
		
		tffname = new JTextField();
		tffname.setBounds(600,100,150,30);
		add(tffname);
		
		JLabel rollno = new JLabel("Roll Number");
		rollno.setBounds(50,150,200,30);
		rollno.setFont(new Font("serif",Font.BOLD,20));
		add(rollno);
		
		labelrollno = new JLabel("1533"+first4);
		labelrollno.setBounds(200,150,150,30);
		labelrollno.setFont(new Font("serif",Font.BOLD,20));
		add(labelrollno);
		
		JLabel dob = new JLabel("Date Of Birth");
		dob.setBounds(400,150,200,30);
		dob.setFont(new Font("serif",Font.BOLD,20));
		add(dob);
		
		dcdob = new JDateChooser();
		dcdob.setBounds(600, 150, 150, 30);
		add(dcdob);
		
		JLabel address = new JLabel("Address");
		address.setBounds(50,200,200,30);
		address.setFont(new Font("serif",Font.BOLD,20));
		add(address);
		
		tfaddress = new JTextField();
		tfaddress.setBounds(200,200,150,30);
		add(tfaddress);
		
		JLabel phone = new JLabel("Phone");
		phone.setBounds(400,200,200,30);
		phone.setFont(new Font("serif",Font.BOLD,20));
		add(phone);
		
		tfphone = new JTextField();
		tfphone.setBounds(600,200,150,30);
		add(tfphone);
		
		JLabel email = new JLabel("Email Id");
		email.setBounds(50,250,200,30);
		email.setFont(new Font("serif",Font.BOLD,20));
		add(email);
		
		tfemail = new JTextField();
		tfemail.setBounds(200,250,150,30);
		add(tfemail);
		
		JLabel x = new JLabel("Class X (%)");
		x.setBounds(400,250,200,30);
		x.setFont(new Font("serif",Font.BOLD,20));
		add(x);
		
		tfx = new JTextField();
		tfx.setBounds(600,250,150,30);
		add(tfx);
		
		JLabel xii = new JLabel("Class XII (%)");
		xii.setBounds(50,300,200,30);
		xii.setFont(new Font("serif",Font.BOLD,20));
		add(xii);
		
		tfxii = new JTextField();
		tfxii.setBounds(200,300,150,30);
		add(tfxii);
		
		JLabel aadhar = new JLabel("Aadhar Number");
		aadhar.setBounds(400,300,200,30);
		aadhar.setFont(new Font("serif",Font.BOLD,20));
		add(aadhar);
		
		tfaadhar = new JTextField();
		tfaadhar.setBounds(600,300,150,30);
		add(tfaadhar);
		
		JLabel course = new JLabel("Course");
		course.setBounds(50,350,200,30);
		course.setFont(new Font("serif",Font.BOLD,20));
		add(course);
		
		String courses[] = {"B.Tech","BBA","Bca","Bsc","Msc","MCA","MBA"};
		cbcourse = new JComboBox(courses);
		cbcourse.setBounds(200,350,150,30);
		cbcourse.setBackground(Color.WHITE);
		add(cbcourse);
		
		JLabel branch = new JLabel("Branch");
		branch.setBounds(400,350,200,30);
		branch.setFont(new Font("serif",Font.BOLD,20));
		add(branch);
		
		String branchs[] = {"Computer Sciene","Mechanical","Electronics","Civil"};
		cbbranch = new JComboBox(branchs);
		cbbranch.setBounds(600,350,150,30);
		cbbranch.setBackground(Color.WHITE);
		add(cbbranch);
		
		submit = new JButton("Submit");
		submit.setBounds(250,450,120,30);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.white);
		submit.setFont(new Font("Raleway", Font.BOLD,15));
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(450,450,120,30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Raleway", Font.BOLD,15));
		cancel.addActionListener(this);
		add(cancel);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()== submit) {
			String name = tfname.getText();
			String fname= tffname.getText();
			String rollno = labelrollno.getText();
			String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
			String address = tfaddress.getText();
			String phone = tfphone.getText();
			String email = tfemail.getText();
			String x = tfx.getText();
			String xii = tfxii.getText();
			String aadhar = tfaadhar.getText();
			String course = (String) cbcourse.getSelectedItem();
			String branch = (String) cbbranch.getSelectedItem();
			
			try {
				String query = "insert into student values('"+name+"','"+fname+"','"+rollno+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+branch+"')";
				Conn c = new Conn();
				c.stmt.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Student details inserted successfully");
				setVisible(false);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new AddStudent();
	}

}
